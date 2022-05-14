package main;

public class Main {
    public static void main(String[] args) {
        Tasks.init();

        //1. Вывести список всех пользователей и их сообщений
        Tasks.firstTask();

        //2. Вывести пользователя, который оставил сообщение последним
        Tasks.secondTask();

        //3. Поиск среди сообщений по ключевым словам/фразам
        Tasks.thirdTask("разработка");

        //4. Установить рейтинг топика из расчёта +1 за каждые 3 сообщения в нём
        Tasks.fourthTask();

        //5. Вывести средний рейтинг топиков в каждом разделе
        Tasks.fifthTask();

        Tasks.close();
    }
}
