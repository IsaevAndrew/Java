package Practice_20;

import java.util.Scanner;

public class MinMax<T extends Comparable<T>> {
    private T[] array;

    public MinMax(T[] array) {
        this.array = array;
    }

    public T findMin() {
        if (array.length == 0) {
            throw new IllegalArgumentException("Массив пуст");
        }

        T min = array[0];
        for (T item : array) {
            if (item.compareTo(min) < 0) {
                min = item;
            }
        }
        return min;
    }

    public T findMax() {
        if (array.length == 0) {
            throw new IllegalArgumentException("Массив пуст");
        }

        T max = array[0];
        for (T item : array) {
            if (item.compareTo(max) > 0) {
                max = item;
            }
        }
        return max;
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите элементы, разделенные пробелами: ");
        String[] input = scanner.nextLine().split("\\s+");
        Double[] doubleArray = new Double[input.length];
        for (int i = 0; i < input.length; i++) {
            doubleArray[i] = Double.parseDouble(input[i]);
        }

        MinMax<Double> doubleMinMax = new MinMax<>(doubleArray);

        System.out.println("Минимальное значение в doubleArray: " + doubleMinMax.findMin());
        System.out.println("Максимальное значение в doubleArray: " + doubleMinMax.findMax());
    }
}
