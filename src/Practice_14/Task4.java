package Practice_14;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Task4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите строку:");
        String inputText = scanner.nextLine();
        Pattern pattern = Pattern.compile("\\+");
        Matcher matcher = pattern.matcher(inputText);

        if (matcher.find()) {
            System.out.println("В строке есть символ '+'");
        } else {
            System.out.println("В строке нет символа '+'");
        }
    }
}
