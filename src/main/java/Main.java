import DAO.MarkaDAO;
import DAO.hibarnate.HibernateUtil;
import DAO.hibarnate.MarkaDAOHibarnateImpl;
import DAO.jdbc.MarkaDAOjdbcImpl;
import entity.MarkaCoffi;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Администратор on 11.07.2017.
 */
public class Main {
    public static void main(String[] args) {

        MarkaDAO markaDAO = new MarkaDAOjdbcImpl();
        List<MarkaCoffi> list = markaDAO.getAll();
        for (MarkaCoffi markaCoffi : list) {
            System.out.println(markaCoffi);
        }
        markaDAO.delete(5);
        System.out.println(" -------- ------- ------------- ");
        list = markaDAO.getAll();
        for (MarkaCoffi markaCoffi : list) {
            System.out.println(markaCoffi);
        }
    }
}
