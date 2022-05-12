package main;

import entity.Section;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import utils.NewHibernateUtil;

import java.util.List;

public class Task5 {
    public static void main(String[] args) {
        SessionFactory sf = NewHibernateUtil.getSessionFactory();
        Session session = sf.openSession();
        Transaction transaction = session.beginTransaction();

        //5. Вывести средний рейтинг топиков в каждом разделе
        List<Section> sections = session.createQuery("FROM Section").list();

        for (Section section : sections) {
            System.out.println("Раздел " + section.getName() + ":");
            System.out.println(session.createQuery("SELECT AVG(rating) FROM Topic WHERE section_id = :section")
                    .setParameter("section", section.getId())
                    .list()
                    .get(0));
        }

        session.flush();
        transaction.commit();
        session.close();
        sf.close();
    }
}
