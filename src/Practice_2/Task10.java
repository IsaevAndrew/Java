package Practice_2;

import java.util.Scanner;

public class Task10 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите текст:");
        System.out.println("Вы ввели " + scanner.nextLine().split("\\s+").length + " слов.");
    }
}
