package Practice_3;

import java.util.Arrays;
import java.util.Random;

public class Task1 {
    public static void main(String[] args) {
        int size = 10;
        double[] array1 = new double[size];
        for (int i = 0; i < size; i++) {
            array1[i] = Math.random() * 100;
        }
        System.out.println("Массив, созданный с использованием Math.random():");
        System.out.println(Arrays.toString(array1));
        Arrays.sort(array1);
        System.out.println("Отсортированный массив:");
        System.out.println(Arrays.toString(array1));
        Random random = new Random();
        double[] array2 = new double[size];
        for (int i = 0; i < size; i++) {
            array2[i] = random.nextDouble() * 100;
        }
        System.out.println("\nМассив, созданный с использованием класса Random:");
        System.out.println(Arrays.toString(array2));
        Arrays.sort(array2);
        System.out.println("Отсортированный массив:");
        System.out.println(Arrays.toString(array2));
    }
}
