package Practice_8;
import java.util.Scanner;

public class Task15 {
    public static void printDigitsReverse(int n) {
        if (n == 0) {
            return;
        }
        System.out.print(n % 10 + " ");
        printDigitsReverse(n / 10);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите натуральное число: ");
        int n = scanner.nextInt();

        if (n < 0) {
            System.out.println("Число должно быть натуральным.");
        } else {
            System.out.println("Цифры числа " + n + " справа налево:");
            printDigitsReverse(n);
        }
    }
}
