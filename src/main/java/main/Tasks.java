package main;

import entity.Message;
import entity.Section;
import entity.Topic;
import entity.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import utils.NewHibernateUtil;

import java.util.List;
import java.util.Scanner;

public class Tasks {
    private static SessionFactory sessionFactory;
    private static Session session;
    private static Transaction transaction;

    //1. Вывести список всех пользователей и их сообщений
    public static void firstTask() {
        List<User> users = session.createQuery("FROM User").list();

        for (User user : users) {
            System.out.println(user + "\nMessages: ");
            user.getMessages().forEach(System.out::println);
        }
    }

    //2. Вывести пользователя, который оставил сообщение последним
    public static void secondTask() {
        List<Message> messages = session.createQuery("FROM Message ORDER BY Id DESC").setMaxResults(1).list();

        System.out.println(messages.size() != 1 ? "Oops, something went wrong..." : messages.get(0).getUser());
    }

    //3. Поиск среди сообщений по ключевым словам/фразам
    public static void thirdTask(String phrase) {
        List<Message> messages = session.createQuery("FROM Message WHERE Text LIKE :phrase").setParameter("phrase", "%" + phrase + "%").list();
        System.out.println("Сообщения, содержащие \"" + phrase + "\":");
        messages.forEach(System.out::println);
    }

    //4. Установить рейтинг топика из расчёта +1 за каждые 3 сообщения в нём
    public static void fourthTask() {
        List<Topic> topics = session.createQuery("FROM Topic").list();

        for (Topic topic : topics) {
            if (topic.getMessages().size() >= 3) {
                topic.setRating(topic.getMessages().size() / 3);
                session.update(topic);
            }
        }
    }

    //5. Вывести средний рейтинг топиков в каждом разделе
    public static void fifthTask() {
        List<Section> sections = session.createQuery("FROM Section").list();

        for (Section section : sections) {
            System.out.println("Раздел " + section.getName() + ":");
            System.out.println(session.createQuery("SELECT AVG(rating) FROM Topic WHERE section_id = :section")
                    .setParameter("section", section.getId())
                    .list()
                    .get(0));
        }
    }

    public static void init() {
        sessionFactory = NewHibernateUtil.getSessionFactory();
        session = sessionFactory.openSession();
        transaction = session.beginTransaction();
    }

    public static void close() {
        session.flush();
        transaction.commit();
        session.close();
        sessionFactory.close();
    }
}
