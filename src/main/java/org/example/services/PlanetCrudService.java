package org.example.services;

import org.example.entities.Planet;
import org.example.utils.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;
import java.util.Objects;

public class PlanetCrudService {

    public void createPlanet(Planet planet) {
        Session session = HibernateUtil.getInstance().getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.persist(planet);
        transaction.commit();
        session.close();
    }

    public Planet readPlanet(String id) {
        Session session = HibernateUtil.getInstance().getSessionFactory().openSession();
        Planet planet = session.get(Planet.class, id);
        session.close();
        return planet;
    }

    public void updatePlanet(String id, String name) {
        Session session = HibernateUtil.getInstance().getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.createQuery("UPDATE Planet SET name =: name WHERE id =: planet_id")
                .setParameter("name", name)
                .setParameter("planet_id", id)
                .executeUpdate();
        transaction.commit();
        session.close();
    }

    public void deletePlanet(String id) {
        Planet planet = readPlanet(id);

        if (Objects.nonNull(planet)) {
            Session session = HibernateUtil.getInstance().getSessionFactory().openSession();
            Transaction transaction = session.beginTransaction();
            session.remove(planet);
            transaction.commit();
            session.close();
        }
    }

    public List<Planet> getAllPlanets() {
        List<Planet> planets;

        Session session = HibernateUtil.getInstance().getSessionFactory().openSession();
        planets = session.createQuery("FROM Planet", Planet.class).list();
        session.close();
        return planets;
    }
}