package dao;

import entities.Activatedservice;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;
import java.util.List;

@EnableTransactionManagement
@Transactional
public class ActivatedserviceDao {

    @Autowired
    SessionFactory sessionFactory;

    @Transactional
    public Activatedservice get(int id)
    {
        Session session = sessionFactory.openSession();
        Activatedservice activatedservice = (Activatedservice) session.get(Activatedservice.class, id);
        session.close();
        return activatedservice;
    }

    public List<Activatedservice> getAll()
    {
        Session session = sessionFactory.openSession();
        List<Activatedservice> activatedservices = session.createQuery("from Activatedservice").list();
        session.close();
        return activatedservices;
    }

    public int add(Activatedservice activatedservice)
    {
        Session session = sessionFactory.openSession();
        Serializable id = session.save(activatedservice);
        session.flush();
        session.close();
        return (Integer) id;
    }

    public void update(Activatedservice activatedservice)
    {
        Session session = sessionFactory.openSession();
        session.update(activatedservice);
        session.flush();
        session.close();
    }

    public void delete(int id)
    {
        Session session = sessionFactory.openSession();
        Activatedservice activatedservice = (Activatedservice) session.get(Activatedservice.class, id);
        session.delete(activatedservice);
        session.flush();
        session.close();
    }
}
