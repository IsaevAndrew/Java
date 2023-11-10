package Practice_11;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

public class Task2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss");
        System.out.print("Введите дату и время (в формате 'dd.MM.yyyy HH:mm:ss'): ");
        String userInput = scanner.nextLine();
        Calendar userCalendar = Calendar.getInstance();
        Calendar currentCalendar = Calendar.getInstance();
        Date currentDate = currentCalendar.getTime();
        System.out.println("Текущая дата и время: " + dateFormat.format(currentDate));
        try {
            Date userDate = dateFormat.parse(userInput);
            userCalendar.setTime(userDate);
            if (userCalendar.before(currentCalendar)) {
                System.out.println("Введенная дата и время меньше текущей.");
            } else if (userCalendar.after(currentCalendar)) {
                System.out.println("Введенная дата и время больше текущей.");
            } else {
                System.out.println("Введенная дата и время совпадают с текущей.");
            }
        } catch (Exception e) {
            System.err.println("Ошибка при разборе даты. Убедитесь, что вы ввели правильный формат.");
        }
    }
}
