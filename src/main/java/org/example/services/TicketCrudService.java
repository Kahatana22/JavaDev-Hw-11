package org.example.services;

import org.example.entities.Client;
import org.example.entities.Planet;
import org.example.entities.Ticket;
import org.example.utils.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;
import java.util.Objects;

public class TicketCrudService {
    public void createTicket(Ticket ticket) {
        Session session = HibernateUtil.getInstance().getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.persist(ticket);
        transaction.commit();
        session.close();
    }

    public Ticket readTicket(Long id) {
        Session session = HibernateUtil.getInstance().getSessionFactory().openSession();
        Ticket ticket = session.get(Ticket.class, id);
        session.close();
        return ticket;
    }

    public void updateTicket(Long id, Client client, Planet fromPlanet, Planet toPlanet) {
        Session session = HibernateUtil.getInstance().getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.createQuery("UPDATE Ticket SET client =: client, " +
                        "fromPlanet =: fromPlanet," +
                        "toPlanet =: toPlanet WHERE id =: planet_id")
                .setParameter("client", client)
                .setParameter("fromPlanet", fromPlanet)
                .setParameter("toPlanet", toPlanet)
                .setParameter("planet_id", id)
                .executeUpdate();
        transaction.commit();
        session.close();
    }

    public void deleteTicket(Long id) {
        Ticket ticket = readTicket(id);

        if (Objects.nonNull(ticket)) {
            Session session = HibernateUtil.getInstance().getSessionFactory().openSession();
            Transaction transaction = session.beginTransaction();
            session.remove(ticket);
            transaction.commit();
            session.close();
        }
    }

    public List<Ticket> getAllTickets() {
        List<Ticket> tickets;

        Session session = HibernateUtil.getInstance().getSessionFactory().openSession();
        tickets = session.createQuery("FROM Ticket", Ticket.class).list();
        session.close();
        return tickets;
    }
}
