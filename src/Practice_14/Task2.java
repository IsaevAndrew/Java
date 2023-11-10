package Practice_14;

import java.util.Scanner;

public class Task2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите строку для проверки: ");
        String input = scanner.nextLine();
        scanner.close();
        String regex = "abcdefghijklmnopqrstuv18340";
        if (input.matches(regex)) {
            System.out.println("Строка соответствует образцу.");
        } else {
            System.out.println("Строка не соответствует образцу.");
        }
    }
}
