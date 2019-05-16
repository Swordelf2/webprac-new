package dao;

import entities.Deposit;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;
import java.util.List;

@EnableTransactionManagement
@Transactional
public class DepositDao {

    @Autowired
    SessionFactory sessionFactory;

    @Transactional
    public Deposit get(int id)
    {
        Session session = sessionFactory.openSession();
        Deposit deposit = (Deposit) session.get(Deposit.class, id);
        session.close();
        return deposit;
    }

    @Transactional
    public List<Deposit> getAll()
    {
        Session session = sessionFactory.openSession();
        List<Deposit> deposits = session.createQuery("from Deposit").list();
        session.close();
        return deposits;
    }

    @Transactional
    public int add(Deposit deposit)
    {
        Session session = sessionFactory.openSession();
        Serializable id = session.save(deposit);
        session.close();
        return (Integer) id;
    }

    @Transactional
    public void update(Deposit deposit)
    {
        Session session = sessionFactory.openSession();
        session.update(deposit);
        session.close();
    }

    @Transactional
    public void delete(int id)
    {
        Session session = sessionFactory.openSession();
        Deposit deposit = (Deposit) session.get(Deposit.class, id);
        session.delete(deposit);
        session.close();
    }
}
