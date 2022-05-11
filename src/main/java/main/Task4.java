package main;

import entity.Topic;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import utils.NewHibernateUtil;

import java.util.List;

public class Task4 {
    public static void main(String[] args) {
        SessionFactory sf = NewHibernateUtil.getSessionFactory();
        Session session = sf.openSession();
        Transaction transaction = session.beginTransaction();

        //4. Установить рейтинг топика из расчёта +1 за каждые 3 сообщения в нём
        List<Topic> topics = session.createQuery("FROM Topic").list();

        for (Topic topic : topics) {
            if (topic.getMessages().size() >= 3) {
                topic.setRating(topic.getMessages().size() / 3);
                session.update(topic);
            }
        }



        session.flush();
        transaction.commit();
        session.close();
        sf.close();
    }
}
