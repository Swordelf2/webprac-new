package dao;

import entities.Activatedservice;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;
import java.util.List;

@Repository
public class ActivatedserviceDao {

    @Autowired
    SessionFactory sessionFactory;

    public Activatedservice get(int id)
    {
        Session session = sessionFactory.getCurrentSession();
        Activatedservice activatedservice = (Activatedservice) session.get(Activatedservice.class, id);
        return activatedservice;
    }

    public List<Activatedservice> getAll()
    {
        Session session = sessionFactory.getCurrentSession();
        List<Activatedservice> activatedservices = session.createQuery("from Activatedservice").list();
        return activatedservices;
    }

    public Activatedservice add(Activatedservice activatedservice)
    {
        Session session = sessionFactory.getCurrentSession();
        Serializable id = session.save(activatedservice);
        return (Activatedservice) id;
    }

    public void update(Activatedservice activatedservice)
    {
        Session session = sessionFactory.getCurrentSession();
        session.update(activatedservice);
    }

    public void delete(int id)
    {
        Session session = sessionFactory.getCurrentSession();
        Activatedservice activatedservice = (Activatedservice) session.get(Activatedservice.class, id);
        session.delete(activatedservice);
    }
}
