package Practice_32;

import java.util.ArrayList;
import java.util.Scanner;

import java.io.*;

public class Main {

    static void printMenu() {
        System.out.println("Выберите что будем делать: ");
        System.out.println("1. Создать заказ");
        System.out.println("2. Вывести список заказов");
        System.out.println("0. Для выхода");
    }

    static void printOrders(ArrayList<InternetOrder> list) {
        for (int i = 0; i < list.size(); i++) {
            System.out.println("===ЗАКАЗ " + (i + 1) + "===");
            list.get(i).print();
        }
    }

    public static void main(String[] args) {
        ArrayList<InternetOrder> internetOrders = new ArrayList<>();
        Scanner sc = new Scanner(System.in);

        while (true) {
            printMenu();
            int num = sc.nextInt();

            if (num == 1) {
                InternetOrder order = new InternetOrder();

                while (true) {
                    System.out.print("Введите название товара (для завершения введите '0'): ");
                    String name = sc.next();

                    if (name.equalsIgnoreCase("0")) {
                        break;
                    }

                    System.out.print("Введите цену товара: ");
                    double price = sc.nextDouble();
                    System.out.print("Введите описание товара: ");
                    String description = sc.next();
                    order.add(new Dish(price, name, description));
                }

                internetOrders.add(order);
            }

            else if (num == 2) {
                System.out.println("Список заказов:");
                printOrders(internetOrders);
            }

            else if (num == 0) {
                break;
            }
        }

        try {
            ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream("data.ser"));
            outputStream.writeObject(internetOrders);
            outputStream.close();
            System.out.println("Заказы сохранены в файл.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
