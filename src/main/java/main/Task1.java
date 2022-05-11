package main;

import entity.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import utils.NewHibernateUtil;

import java.util.List;

public class Task1 {
    public static void main(String[] args) {
        SessionFactory sf = NewHibernateUtil.getSessionFactory();
        Session session = sf.openSession();
        Transaction transaction = session.beginTransaction();

        //1. Вывести список всех пользователей и их сообщений
        List<User> users = session.createQuery("FROM User").list();

        for (User user : users) {
            System.out.println(user + "\nMessages: ");
            user.getMessages().forEach(System.out::println);
        }

        session.flush();
        transaction.commit();
        session.close();
        sf.close();
    }
}
