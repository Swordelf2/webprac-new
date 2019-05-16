package dao;

import entities.Contact;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;
import java.util.List;

@Repository
public class ContactDao {

    @Autowired
    SessionFactory sessionFactory;

    public Contact get(int id)
    {
        Session session = sessionFactory.getCurrentSession();
        Contact contact = (Contact) session.get(Contact.class, id);
        return contact;
    }

    public List<Contact> getAll()
    {
        Session session = sessionFactory.getCurrentSession();
        List<Contact> contacts = session.createQuery("from Contact").list();
        return contacts;
    }

    public int add(Contact contact)
    {
        Session session = sessionFactory.getCurrentSession();
        Serializable id = session.save(contact);
        return (Integer) id;
    }

    public void update(Contact contact)
    {
        Session session = sessionFactory.getCurrentSession();
        session.update(contact);
    }

    public void delete(int id)
    {
        Session session = sessionFactory.getCurrentSession();
        Contact contact = (Contact) session.get(Contact.class, id);
        session.delete(contact);
    }
}
