package Practice_14;

import java.util.Calendar;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Task5 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите дату в формате dd/mm/yyyy:");
        String inputDate = scanner.nextLine();
        if (isValidDate(inputDate)) {
            System.out.println("Данная строка является датой в правильном формате.");
        } else {
            System.out.println("Данная строка не является датой в правильном формате.");
        }

        //Pattern pattern = Pattern.compile("^(0[1-9]|[12][0-9]|3[01])/(0[1-9]|1[0-2])/(19\\d\\d|99\\d\\d)$");
        //Matcher matcher = pattern.matcher(inputDate);

        //if (matcher.matches()) {
            //if (isValidDate(inputDate)) {
                //System.out.println("Данная строка является датой в правильном формате.");
            //} else {
                //System.out.println("Данная строка не является датой в правильном формате.");
            //}
        //} else {
            //System.out.println("Данная строка не является датой в правильном формате.");
        //}
    }

    private static boolean isValidDate(String dateStr) {
        String[] dateParts = dateStr.split("/");
        int day = Integer.parseInt(dateParts[0]);
        int month = Integer.parseInt(dateParts[1]);
        int year = Integer.parseInt(dateParts[2]);
        if (year < 1900 || year > 9999) {
            return false;
        }
        Calendar calendar = Calendar.getInstance();
        calendar.setLenient(false);
        try {
            calendar.set(year, month - 1, day);
            calendar.getTime();
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
