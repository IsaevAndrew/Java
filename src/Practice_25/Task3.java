package Practice_25;

import java.util.regex.Pattern;
import java.util.regex.Matcher;
import java.util.Scanner;

public class Task3 {
    public static boolean isIPAddress(String input) {
        String ipAddressPattern = "^((25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\.){3}(25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)$";
        Pattern pattern = Pattern.compile(ipAddressPattern);
        Matcher matcher = pattern.matcher(input);
        return matcher.matches();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите строку для проверки на IP-адрес: ");
        String input = scanner.nextLine();
        if (isIPAddress(input)) {
            System.out.println(input + " является действительным IP-адресом.");
        } else {
            System.out.println(input + " не является действительным IP-адресом.");
        }
        scanner.close();
    }
}
