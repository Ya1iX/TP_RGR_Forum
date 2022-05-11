package main;

import entity.Message;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import utils.NewHibernateUtil;

import java.util.List;
import java.util.Scanner;

public class Task3 {
    public static void main(String[] args) {
        SessionFactory sf = NewHibernateUtil.getSessionFactory();
        Session session = sf.openSession();
        Transaction transaction = session.beginTransaction();

        //3. Поиск среди сообщений по ключевым словам/фразам
        System.out.print("Введите интересующее вас слово/фразу: ");
        Scanner scanner = new Scanner(System.in);
        String phrase = scanner.next();
        scanner.close();

        List<Message> messages = session.createQuery("FROM Message WHERE Text LIKE :phrase").setParameter("phrase", "%" + phrase + "%").list();
        System.out.println("Сообщения, содержащие \"" + phrase + "\":");
        messages.forEach(System.out::println);

        session.flush();
        transaction.commit();
        session.close();
        sf.close();
    }
}
