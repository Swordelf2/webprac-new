package dao;

import entities.Contact;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;
import java.util.List;

@EnableTransactionManagement
@Transactional
public class ContactDao {

    @Autowired
    SessionFactory sessionFactory;

    @Transactional
    public Contact get(int id)
    {
        Session session = sessionFactory.openSession();
        Contact contact = (Contact) session.get(Contact.class, id);
        session.close();
        return contact;
    }

    @Transactional
    public List<Contact> getAll()
    {
        Session session = sessionFactory.openSession();
        List<Contact> contacts = session.createQuery("from Contact").list();
        session.close();
        return contacts;
    }

    @Transactional
    public int add(Contact contact)
    {
        Session session = sessionFactory.openSession();
        Serializable id = session.save(contact);
        session.flush();
        session.close();
        return (Integer) id;
    }

    @Transactional
    public void update(Contact contact)
    {
        Session session = sessionFactory.openSession();
        session.update(contact);
        session.flush();
        session.close();
    }

    @Transactional
    public void delete(int id)
    {
        Session session = sessionFactory.openSession();
        Contact contact = (Contact) session.get(Contact.class, id);
        session.delete(contact);
        session.flush();
        session.close();
    }
}
