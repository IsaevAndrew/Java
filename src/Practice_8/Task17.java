package Practice_8;

import java.util.Scanner;

public class Task17 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите последовательность натуральных чисел (0 для завершения):");
        System.out.println("Наибольшее значение числа в последовательности: " + findMax(scanner));
    }
    public static int findMax(Scanner scanner) {
        int num = scanner.nextInt();
        if (num == 0) {
            return 0;
        }
        int maxInRest = findMax(scanner);
        return Math.max(num, maxInRest);
    }
}

