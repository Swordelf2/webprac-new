package dao;

import entities.Service;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;
import java.util.List;

@Repository
public class ServiceDao {

    @Autowired
    SessionFactory sessionFactory;

    public Service get(int id)
    {
        Session session = sessionFactory.getCurrentSession();
        Service service = (Service) session.get(Service.class, id);
        return service;
    }

    public List<Service> getAll()
    {
        Session session = sessionFactory.getCurrentSession();
        List<Service> services = session.createQuery("from Service").list();
        return services;
    }

    public List<Service> getByNameAndDescription(String name, String description)
    {
        Session session = sessionFactory.getCurrentSession();
        List<Service> clients = session.createQuery("from Service where name like :name " +
                "and description like :description")
                .setParameter("name", "%" + name + "%")
                .setParameter("description", "%" + description + "%").list();
        return clients;
    }

    public int add(Service service)
    {
        Session session = sessionFactory.getCurrentSession();
        Serializable id = session.save(service);
        return (Integer) id;
    }

    public void update(Service service)
    {
        Session session = sessionFactory.getCurrentSession();
        session.update(service);
    }

    public void delete(int id)
    {
        Session session = sessionFactory.getCurrentSession();
        Service service = (Service) session.get(Service.class, id);
        session.delete(service);
    }
}
