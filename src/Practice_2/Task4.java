package Practice_2;

import java.util.ArrayList;
import java.util.Scanner;

class Computer {
    private String brand;
    private String model;
    private double price;

    public Computer(String brand, String model, double price) {
        this.brand = brand;
        this.model = model;
        this.price = price;
    }

    public String getBrand() {
        return brand;
    }

    public String getModel() {
        return model;
    }

    @Override
    public String toString() {
        return brand + " " + model + " (Цена: " + price + " рублей)";
    }
}

class Shop {
    private ArrayList<Computer> computers;

    public Shop() {
        computers = new ArrayList<>();
    }

    public void addComputer(Computer computer) {
        computers.add(computer);
        System.out.println("Компьютер успешно добавлен в магазин.");
    }

    public void removeComputer(Computer computer) {
        for (Computer comp: computers){
            if (comp.getBrand().equals(computer.getBrand()) & comp.getModel().equals(computer.getModel())){
                computers.remove(comp);
                System.out.println("Компьютер успешно удален из магазина.");
                return;
            }
        }
        System.out.println("Компьютер не найден в магазине.");
    }

    public void searchComputer(String brand, String model) {
        for (Computer computer : computers) {
            if (computer.getBrand().equalsIgnoreCase(brand) && computer.getModel().equalsIgnoreCase(model)) {
                System.out.println("Найден компьютер: " + computer);
                return;
            }
        }
        System.out.println("Компьютер не найден в магазине.");
    }

    public void displayComputers() {
        System.out.println("Компьютеры в магазине:");
        for (Computer computer : computers) {
            System.out.println(computer);
        }
    }
}

public class Task4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Shop shop = new Shop();
        while (true) {
            System.out.println("\nМеню:");
            System.out.println("1. Добавить компьютер");
            System.out.println("2. Удалить компьютер");
            System.out.println("3. Поиск компьютера");
            System.out.println("4. Отобразить все компьютеры");
            System.out.println("5. Выход");
            System.out.print("Выберите действие: ");
            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    System.out.print("Введите бренд компьютера: ");
                    String brand = scanner.next();
                    System.out.print("Введите модель компьютера: ");
                    String model = scanner.next();
                    System.out.print("Введите цену компьютера: ");
                    double price = scanner.nextDouble();
                    Computer computer = new Computer(brand, model, price);
                    shop.addComputer(computer);
                    break;
                case 2:
                    System.out.print("Введите бренд компьютера для удаления: ");
                    String brandToRemove = scanner.next();
                    System.out.print("Введите модель компьютера для удаления: ");
                    String modelToRemove = scanner.next();
                    Computer computerToRemove = new Computer(brandToRemove, modelToRemove, 0);
                    shop.removeComputer(computerToRemove);
                    break;
                case 3:
                    System.out.print("Введите бренд компьютера для поиска: ");
                    String brandToSearch = scanner.next();
                    System.out.print("Введите модель компьютера для поиска: ");
                    String modelToSearch = scanner.next();
                    shop.searchComputer(brandToSearch, modelToSearch);
                    break;
                case 4:
                    shop.displayComputers();
                    break;
                case 5:
                    System.out.println("Выход из программы.");
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Неверный выбор, попробуйте еще раз.");
                    break;
            }
        }
    }
}
