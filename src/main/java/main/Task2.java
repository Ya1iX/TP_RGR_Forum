package main;

import entity.Message;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import utils.NewHibernateUtil;

import java.util.List;

public class Task2 {
    public static void main(String[] args) {
        SessionFactory sf = NewHibernateUtil.getSessionFactory();
        Session session = sf.openSession();
        Transaction transaction = session.beginTransaction();

        //2. Вывести пользователя, который оставил сообщение последним
        List<Message> messages = session.createQuery("FROM Message ORDER BY Id DESC").setMaxResults(1).list();

        System.out.println(messages.size() != 1 ? "Oops, something went wrong..." : messages.get(0).getUser());

        session.flush();
        transaction.commit();
        session.close();
        sf.close();
    }
}
