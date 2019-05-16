package dao;

import entities.Client;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;
import java.util.List;

@Repository
public class ClientDao {

    @Autowired
    SessionFactory sessionFactory;

    public Client get(int id)
    {
        Session session = sessionFactory.getCurrentSession();
        Client client = (Client) session.get(Client.class, id);
        return client;
    }

    public List<Client> getAll()
    {
        Session session = sessionFactory.getCurrentSession();
        List<Client> clients = session.createQuery("from Client").list();
        return clients;
    }

    public List<Client> getByName(String name)
    {
        Session session = sessionFactory.getCurrentSession();
        List<Client> clients = session.createQuery("from Client where name like :name")
                .setParameter("name", "%" + name + "%").list();
        return clients;
    }

    public int add(Client client)
    {
        Session session = sessionFactory.getCurrentSession();
        Serializable id = session.save(client);
        return (Integer) id;
    }

    public void update(Client client)
    {
        Session session = sessionFactory.getCurrentSession();
        session.update(client);
    }

    public void delete(int id)
    {
        Session session = sessionFactory.getCurrentSession();
        Client client = (Client) session.get(Client.class, id);
        session.delete(client);
    }
}
