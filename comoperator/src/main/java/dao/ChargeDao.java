package dao;

import entities.Charge;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;
import java.util.List;

@Repository
public class ChargeDao {

    @Autowired
    SessionFactory sessionFactory;

    public Charge get(int id)
    {
        Session session = sessionFactory.getCurrentSession();
        Charge charge = (Charge) session.get(Charge.class, id);
        return charge;
    }

    public List<Charge> getAll()
    {
        Session session = sessionFactory.getCurrentSession();
        List<Charge> charges = session.createQuery("from Charge").list();
        return charges;
    }

    public int add(Charge charge)
    {
        Session session = sessionFactory.getCurrentSession();
        Serializable id = session.save(charge);
        return (Integer) id;
    }

    public void update(Charge charge)
    {
        Session session = sessionFactory.getCurrentSession();
        session.update(charge);
    }

    public void delete(int id)
    {
        Session session = sessionFactory.getCurrentSession();
        Charge charge = (Charge) session.get(Charge.class, id);
        session.delete(charge);
    }
}
