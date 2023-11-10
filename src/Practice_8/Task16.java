package Practice_8;
import java.util.Scanner;


public class Task16 {
    public static void main(String[] args) {
        System.out.println("Введите последовательность натуральных чисел (0 для завершения):");
        CountMax(0, 0);
    }

    public static void CountMax(int max, int count) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        if (n > 0) {
            if (n > max) {
                CountMax(n, 1);
            }
            else if (n == max) {
                CountMax(max, ++count);
            }
            else {
                CountMax(max, count);
            }
        } else {
            System.out.println("Количество элементов, равных максимуму: " + count);
        }
    }
}

