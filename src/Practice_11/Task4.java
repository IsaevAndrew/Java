package Practice_11;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Scanner;

public class Task4 {

    private static Calendar createCalendar() {
        System.out.println("Введите год, месяц, число");
        Scanner sc = new Scanner(System.in);
        Calendar calendar = new GregorianCalendar();
        calendar.set(Calendar.YEAR, sc.nextInt());
        calendar.set(Calendar.MONTH, sc.nextInt());
        calendar.set(Calendar.DAY_OF_MONTH, sc.nextInt() - 1);
        System.out.println("Введите часы и минуты");
        calendar.set(Calendar.HOUR_OF_DAY, sc.nextInt());
        calendar.set(Calendar.MINUTE, sc.nextInt());
        return calendar;
    }
    public static void main(String[] args) {
        Calendar calendar = createCalendar();
        Date date = new Date(calendar.getTimeInMillis());
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy HH:mm");
        System.out.println("Введенная дата и время: " + dateFormat.format(date));
    }
}
