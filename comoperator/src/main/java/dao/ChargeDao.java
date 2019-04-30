package dao;

import entities.Charge;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;
import java.util.List;

@EnableTransactionManagement
@Transactional
public class ChargeDao {

    @Autowired
    SessionFactory sessionFactory;

    @Transactional
    public Charge get(int id)
    {
        Session session = sessionFactory.openSession();
        Charge charge = (Charge) session.get(Charge.class, id);
        session.close();
        return charge;
    }

    @Transactional
    public List<Charge> getAll()
    {
        Session session = sessionFactory.openSession();
        List<Charge> charges = session.createQuery("from Charge").list();
        session.close();
        return charges;
    }

    @Transactional
    public int add(Charge charge)
    {
        Session session = sessionFactory.openSession();
        Serializable id = session.save(charge);
        session.flush();
        session.close();
        return (Integer) id;
    }

    @Transactional
    public void update(Charge charge)
    {
        Session session = sessionFactory.openSession();
        session.update(charge);
        session.flush();
        session.close();
    }

    @Transactional
    public void delete(int id)
    {
        Session session = sessionFactory.openSession();
        Charge charge = (Charge) session.get(Charge.class, id);
        session.delete(charge);
        session.flush();
        session.close();
    }
}
