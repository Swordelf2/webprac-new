package dao;

import entities.Credit;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;
import java.util.List;

@EnableTransactionManagement
@Transactional
public class CreditDao {

    @Autowired
    SessionFactory sessionFactory;

    @Transactional
    public Credit get(int id)
    {
        Session session = sessionFactory.openSession();
        Credit credit = (Credit) session.get(Credit.class, id);
        session.close();
        return credit;
    }

    @Transactional
    public List<Credit> getAll()
    {
        Session session = sessionFactory.openSession();
        List<Credit> credits = session.createQuery("from Credit").list();
        session.close();
        return credits;
    }

    @Transactional
    public int add(Credit credit)
    {
        Session session = sessionFactory.openSession();
        Serializable id = session.save(credit);
        session.flush();
        session.close();
        return (Integer) id;
    }

    @Transactional
    public void update(Credit credit)
    {
        Session session = sessionFactory.openSession();
        session.update(credit);
        session.flush();
        session.close();
    }

    @Transactional
    public void delete(int id)
    {
        Session session = sessionFactory.openSession();
        Credit credit = (Credit) session.get(Credit.class, id);
        session.delete(credit);
        session.flush();
        session.close();
    }
}
