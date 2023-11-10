package Practice_14;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Task6 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите email адрес:");
        String email = scanner.nextLine();
        if (isValidEmail(email)) {
            System.out.println("Email адрес корректный.");
        } else {
            System.out.println("Email адрес некорректный.");
        }
    }

    public static boolean isValidEmail(String email) {
        //String regex = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$";
        String regex = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }
}
