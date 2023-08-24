package org.example;

import org.example.entities.Client;
import org.example.entities.Planet;
import org.example.entities.Ticket;
import org.example.services.ClientCrudService;
import org.example.services.PlanetCrudService;
import org.example.services.TicketCrudService;
import org.example.utils.MigrationUtil;

import java.time.LocalDateTime;

public class Main {
    public static void main(String[] args) {
        MigrationUtil migrationUtil = new MigrationUtil();
        migrationUtil.startMigration();

        ClientCrudService clientCrudService = new ClientCrudService();
        clientCrudService.createClient(new Client("Petro"));
        System.out.println(clientCrudService.readClient(2L));
        clientCrudService.updateClient(14L, "Vlad");
        clientCrudService.deleteClient(18L);
        clientCrudService.getAllClients().forEach(System.out::println);

        PlanetCrudService planetCrudService = new PlanetCrudService();
        planetCrudService.createPlanet(new Planet("VEN", "Venus"));
        System.out.println(planetCrudService.readPlanet("VEN"));
        planetCrudService.updatePlanet("VEN", "Luna");
        planetCrudService.deletePlanet("VEN");
        planetCrudService.getAllPlanets().forEach(System.out::println);

        TicketCrudService ticketCrudService = new TicketCrudService();
        ticketCrudService.createTicket(new Ticket(LocalDateTime.now(), clientCrudService.readClient(11L),
                planetCrudService.readPlanet("URAN"), planetCrudService.readPlanet("MARS")));
        System.out.println(ticketCrudService.readTicket(7L));
        ticketCrudService.updateTicket(7L, clientCrudService.readClient(10L),
                planetCrudService.readPlanet("MARS"), planetCrudService.readPlanet("NEP"));
        ticketCrudService.deleteTicket(11L);
        ticketCrudService.getAllTickets().forEach(System.out::println);
    }
}