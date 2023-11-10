package Practice_3;

import java.util.Random;
import java.util.Scanner;

public class Task4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        int n = -1;
        System.out.print("Введите размер массива (число больше 0): ");
        while (n<=0){
            n = scanner.nextInt();
            if (n<=0){
                System.out.println("Некорректный ввод. Введите число больше 0.");
            }
        }
        int[] array = new int[n];

        System.out.println("Массив из случайных  чисел:");
        for (int i = 0; i < n; i++) {
            array[i] = random.nextInt(n + 1);
            System.out.print(array[i] + " ");
        }

        System.out.println("\nМассив из четных элементов:");
        for (int i = 0; i < n; i++) {
            if (array[i] % 2 == 0) {
                System.out.print(array[i] + " ");
            }
        }
    }
}
