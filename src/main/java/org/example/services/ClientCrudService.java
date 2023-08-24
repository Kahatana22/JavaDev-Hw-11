package org.example.services;

import org.example.entities.Client;
import org.example.utils.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;
import java.util.Objects;

public class ClientCrudService {

    public void createClient(Client client) {
        Session session = HibernateUtil.getInstance().getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.persist(client);
        transaction.commit();
        session.close();
    }

    public Client readClient(Long id) {
        Session session = HibernateUtil.getInstance().getSessionFactory().openSession();
        Client client = session.get(Client.class, id);
        session.close();
        return client;
    }

    public void updateClient(Long id, String name) {
        Session session = HibernateUtil.getInstance().getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.createQuery("UPDATE Client SET name =: name WHERE id =: client_id")
                .setParameter("name", name)
                .setParameter("client_id", id)
                .executeUpdate();
        transaction.commit();
        session.close();
    }

    public void deleteClient(Long id) {
        Client client = readClient(id);

        if (Objects.nonNull(client)) {
            Session session = HibernateUtil.getInstance().getSessionFactory().openSession();
            Transaction transaction = session.beginTransaction();
            session.remove(client);
            transaction.commit();
            session.close();
        }
    }

    public List<Client> getAllClients() {
        List<Client> clients;

        Session session = HibernateUtil.getInstance().getSessionFactory().openSession();
        clients = session.createQuery("FROM Client", Client.class).list();
        session.close();
        return clients;
    }
}