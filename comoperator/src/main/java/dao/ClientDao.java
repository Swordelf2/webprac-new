package dao;

import entities.Client;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;
import java.util.List;

@EnableTransactionManagement
@Transactional
public class ClientDao {

    @Autowired
    SessionFactory sessionFactory;

    @Transactional
    public Client get(int id)
    {
        Session session = sessionFactory.openSession();
        Client client = (Client) session.get(Client.class, id);
        session.close();
        return client;
    }

    @Transactional
    public List<Client> getAll()
    {
        Session session = sessionFactory.openSession();
        List<Client> clients = session.createQuery("from Client").list();
        session.close();
        return clients;
    }

    @Transactional
    public List<Client> getByName(String name)
    {
        Session session = sessionFactory.openSession();
        List<Client> clients = session.createQuery("from Client where name like :name")
                .setParameter("name", "%" + name + "%").list();
        session.close();
        return clients;
    }

    @Transactional
    public int add(Client client)
    {
        Session session = sessionFactory.openSession();
        Serializable id = session.save(client);
        session.close();
        return (Integer) id;
    }

    @Transactional
    public void update(Client client)
    {
        Session session = sessionFactory.openSession();
        session.update(client);
        session.close();
    }

    @Transactional
    public void delete(int id)
    {
        Session session = sessionFactory.openSession();
        Client client = (Client) session.get(Client.class, id);
        session.delete(client);
        session.close();
    }
}
