package Practice_25;

import java.util.regex.Pattern;
import java.util.regex.Matcher;
import java.util.Scanner;

public class Task4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите выражение для проверки на баланс скобок: ");
        String input = scanner.nextLine();

        Pattern openParenthesisPattern = Pattern.compile("\\(");
        Pattern closeParenthesisPattern = Pattern.compile("\\)");

        Matcher openParenthesisMatcher = openParenthesisPattern.matcher(input);
        Matcher closeParenthesisMatcher = closeParenthesisPattern.matcher(input);

        int openParenthesisCount = 0;
        int closeParenthesisCount = 0;

        while (openParenthesisMatcher.find()) {
            openParenthesisCount++;
        }

        while (closeParenthesisMatcher.find()) {
            closeParenthesisCount++;
        }

        if (openParenthesisCount == closeParenthesisCount) {
            System.out.println("Скобки сбалансированы. Формат верный.");
        } else {
            System.out.println("Скобки несбалансированы. Формат неверный.");
        }
    }
}
