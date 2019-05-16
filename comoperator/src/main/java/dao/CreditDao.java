package dao;

import entities.Credit;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;
import java.util.List;

@Repository
public class CreditDao {

    @Autowired
    SessionFactory sessionFactory;

    public Credit get(int id)
    {
        Session session = sessionFactory.getCurrentSession();
        Credit credit = (Credit) session.get(Credit.class, id);
        return credit;
    }

    public List<Credit> getAll()
    {
        Session session = sessionFactory.getCurrentSession();
        List<Credit> credits = session.createQuery("from Credit").list();
        return credits;
    }

    public int add(Credit credit)
    {
        Session session = sessionFactory.getCurrentSession();
        Serializable id = session.save(credit);
        return (Integer) id;
    }

    public void update(Credit credit)
    {
        Session session = sessionFactory.getCurrentSession();
        session.update(credit);
    }

    public void delete(int id)
    {
        Session session = sessionFactory.getCurrentSession();
        Credit credit = (Credit) session.get(Credit.class, id);
        session.delete(credit);
    }
}
