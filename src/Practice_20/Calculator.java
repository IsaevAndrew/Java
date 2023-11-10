package Practice_20;

import java.util.Scanner;

public class Calculator {
    public static <T extends Number> double sum(T num1, T num2) {
        return num1.doubleValue() + num2.doubleValue();
    }

    public static <T extends Number> double multiply(T num1, T num2) {
        return num1.doubleValue() * num2.doubleValue();
    }

    public static <T extends Number> double divide(T num1, T num2) {
        try {
            double result = num1.doubleValue() / num2.doubleValue();
            if (Double.isInfinite(result) || Double.isNaN(result)) {
                throw new ArithmeticException("Недопустимая операция деления");
            }
            return result;
        } catch (ArithmeticException e) {
            return Double.NaN;
        }
    }

    public static <T extends Number> double subtract(T num1, T num2) {
        return num1.doubleValue() - num2.doubleValue();
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите первое число: ");
        double num1 = scanner.nextDouble();
        System.out.print("Введите второе число: ");
        double num2 = scanner.nextDouble();

        System.out.println("Сумма: " + sum(num1, num2));
        System.out.println("Умножение: " + multiply(num1, num2));
        System.out.println("Деление: " + divide(num1, num2));
        System.out.println("Вычитание: " + subtract(num1, num2));
    }
}
