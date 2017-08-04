package DAO.hibarnate;

import DAO.MarkaDAO;
import entity.MarkaCoffi;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.List;

public class MarkaDAOHibarnateImpl implements MarkaDAO {

    public List<MarkaCoffi> getAll() {
        Session session = getSession();
        List<MarkaCoffi> list = session.createCriteria(MarkaCoffi.class).list();
        session.getTransaction().commit();
        session.close();
        return list;
    }

    public MarkaCoffi get(Integer id) {
        Session session = getSession();
        MarkaCoffi markaCoffi = (MarkaCoffi) session.get(MarkaCoffi.class, id);
        session.getTransaction().commit();
        session.close();
        return markaCoffi;
    }

    public Boolean delete(Integer id) {
        Session session = getSession();
        session.delete(get(id));
        session.getTransaction().commit();
        session.close();
        return true;
    }

    public Boolean update(MarkaCoffi markaCoffi) {
        Session session = getSession();
        session.update(markaCoffi);
        session.getTransaction().commit();
        session.close();
        return true;
    }

    public Boolean create(MarkaCoffi markaCoffi) {
        Session session = getSession();
        session.save(markaCoffi);
        session.getTransaction().commit();
        session.close();
        return true;
    }

    public Session getSession() {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        return session;
    }

}
