package dao;

import entities.Deposit;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.Serializable;
import java.util.List;

@Repository
public class DepositDao {

    @Autowired
    SessionFactory sessionFactory;

    public Deposit get(int id)
    {
        Session session = sessionFactory.getCurrentSession();
        Deposit deposit = (Deposit) session.get(Deposit.class, id);
        return deposit;
    }

    public List<Deposit> getAll()
    {
        Session session = sessionFactory.getCurrentSession();
        List<Deposit> deposits = session.createQuery("from Deposit").list();
        return deposits;
    }

    public int add(Deposit deposit)
    {
        Session session = sessionFactory.getCurrentSession();
        Serializable id = session.save(deposit);
        return (Integer) id;
    }

    public void update(Deposit deposit)
    {
        Session session = sessionFactory.getCurrentSession();
        session.update(deposit);
    }

    public void delete(int id)
    {
        Session session = sessionFactory.getCurrentSession();
        Deposit deposit = (Deposit) session.get(Deposit.class, id);
        session.delete(deposit);
    }
}
