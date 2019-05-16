package dao;

import entities.Service;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;
import java.util.List;

@EnableTransactionManagement
@Transactional
public class ServiceDao {

    @Autowired
    SessionFactory sessionFactory;

    @Transactional
    public Service get(int id)
    {
        Session session = sessionFactory.openSession();
        Service service = (Service) session.get(Service.class, id);
        session.close();
        return service;
    }

    @Transactional
    public List<Service> getAll()
    {
        Session session = sessionFactory.openSession();
        List<Service> services = session.createQuery("from Service").list();
        session.close();
        return services;
    }

    @Transactional
    public List<Service> getByNameAndDescription(String name, String description)
    {
        Session session = sessionFactory.openSession();
        List<Service> clients = session.createQuery("from Service where name like :name " +
                "and description like :description")
                .setParameter("name", "%" + name + "%")
                .setParameter("description", "%" + description + "%").list();
        session.close();
        return clients;
    }

    @Transactional
    public int add(Service service)
    {
        Session session = sessionFactory.openSession();
        Serializable id = session.save(service);
        session.close();
        return (Integer) id;
    }

    @Transactional
    public void update(Service service)
    {
        Session session = sessionFactory.openSession();
        session.update(service);
        session.close();
    }

    @Transactional
    public void delete(int id)
    {
        Session session = sessionFactory.openSession();
        Service service = (Service) session.get(Service.class, id);
        session.delete(service);
        session.close();
    }
}
