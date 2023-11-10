package Practice_11;

import java.util.Date;

public class Task1 {
    public static void main(String[] args) {
        String developer = "Исаев Андрей";
        Date ReceivedDate = new Date(1230901200000L);
        Date DueDate = new Date();
        System.out.println("Фамилия разработчика: " + developer);
        System.out.println("Дата и время получения задания: " + ReceivedDate);
        System.out.println("Дата и время сдачи задания: " + DueDate);
    }
}
