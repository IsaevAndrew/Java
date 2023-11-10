package Practice_6;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

// Перечисление для марок компьютера
enum Brand {
    APPLE, XIAOMI, HONOR, ASUS, HP, LENOVO
}

class Processor {
    private String model;
    private int cores;
    private double clockSpeed;

    public Processor(String model, int cores, double clockSpeed) {
        this.model = model;
        this.cores = cores;
        this.clockSpeed = clockSpeed;
    }

    public String getModel() {
        return model;
    }

    public int getCores() {
        return cores;
    }

    public double getClockSpeed() {
        return clockSpeed;
    }

    @Override
    public String toString() {
        return "Processor: " + model + ", Cores: " + cores + ", Clock Speed: " + clockSpeed + " GHz";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Processor processor = (Processor) o;
        return cores == processor.cores &&
                Double.compare(processor.clockSpeed, clockSpeed) == 0 &&
                Objects.equals(model, processor.model);
    }
}

class Memory {
    private int sizeGB;
    private String type;

    public Memory(int sizeGB, String type) {
        this.sizeGB = sizeGB;
        this.type = type;
    }

    public int getSizeGB() {
        return sizeGB;
    }

    public String getType() {
        return type;
    }

    @Override
    public String toString() {
        return "Memory: " + sizeGB + " GB, Type: " + type;
    }
}

class Monitor {
    private String model;
    private int sizeInches;

    public Monitor(String model, int sizeInches) {
        this.model = model;
        this.sizeInches = sizeInches;
    }

    public String getModel() {
        return model;
    }

    public int getSizeInches() {
        return sizeInches;
    }

    @Override
    public String toString() {
        return "Monitor: " + model + ", Size: " + sizeInches + " inches";
    }
}

class Computer {
    private Brand brand;
    private Processor processor;
    private Memory memory;
    private Monitor monitor;

    public Computer(Brand brand, Processor processor, Memory memory, Monitor monitor) {
        this.brand = brand;
        this.processor = processor;
        this.memory = memory;
        this.monitor = monitor;
    }

    public Brand getBrand() {
        return brand;
    }

    public Processor getProcessor() {
        return processor;
    }

    @Override
    public String toString() {
        return "Brand: " + brand + "\n" + processor + "\n" + memory + "\n" + monitor;
    }
}

class Shop {
    private List<Computer> computers = new ArrayList<>();

    public void addComputer(Computer computer) {
        computers.add(computer);
    }

    public void removeComputer(Computer computer) {
        computers.remove(computer);
    }

    public List<Computer> getComputers() {
        return computers;
    }

    public List<Computer> findComputers(Processor searchProcessor) {
        List<Computer> foundComputers = new ArrayList<>();
        for (Computer comp : computers) {
            Processor compProcessor = comp.getProcessor();
            if (compProcessor != null && compProcessor.equals(searchProcessor)) {
                foundComputers.add(comp);
            }
        }
        return foundComputers;
    }
}

public class Task10 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Shop shop = new Shop();

        while (true) {
            System.out.println("1. Добавить компьютер");
            System.out.println("2. Удалить компьютер");
            System.out.println("3. Найти компьютер по параметрам процессора");
            System.out.println("4. Выйти");
            System.out.print("Выберите действие: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Введите марку компьютера (APPLE, XIAOMI, HONOR, ASUS, HP, LENOVO): ");
                    Brand brand = Brand.valueOf(scanner.nextLine().toUpperCase());

                    System.out.print("Введите модель процессора: ");
                    String processorModel = scanner.nextLine();

                    System.out.print("Введите количество ядер процессора: ");
                    int processorCores = scanner.nextInt();
                    scanner.nextLine();

                    System.out.print("Введите тактовую частоту процессора (GHz): ");
                    double processorClockSpeed = scanner.nextDouble();
                    scanner.nextLine();

                    System.out.print("Введите объем памяти (GB): ");
                    int memorySizeGB = scanner.nextInt();
                    scanner.nextLine();

                    System.out.print("Введите тип памяти: ");
                    String memoryType = scanner.nextLine();

                    System.out.print("Введите модель монитора: ");
                    String monitorModel = scanner.nextLine();

                    System.out.print("Введите размер монитора (дюймы): ");
                    int monitorSizeInches = scanner.nextInt();
                    scanner.nextLine();

                    Processor processor = new Processor(processorModel, processorCores, processorClockSpeed);
                    Memory memory = new Memory(memorySizeGB, memoryType);
                    Monitor monitor = new Monitor(monitorModel, monitorSizeInches);
                    Computer computer = new Computer(brand, processor, memory, monitor);

                    shop.addComputer(computer);
                    System.out.println("Компьютер добавлен в магазин.");
                    break;

                case 2:
                    System.out.print("Введите марку компьютера для удаления(APPLE, XIAOMI, HONOR, ASUS, HP, LENOVO1): ");
                    Brand deleteComputerBrand = Brand.valueOf(scanner.nextLine().toUpperCase());

                    System.out.print("Введите модель процессора: ");
                    String deleteProcessorModel = scanner.nextLine();

                    System.out.print("Введите количество ядер процессора: ");
                    int deleteProcessorCores = scanner.nextInt();
                    scanner.nextLine();

                    System.out.print("Введите тактовую частоту процессора (GHz): ");
                    double deleteProcessorClockSpeed = scanner.nextDouble();
                    scanner.nextLine();

                    Processor deleteProcessor = new Processor(deleteProcessorModel, deleteProcessorCores, deleteProcessorClockSpeed);
                    List<Computer> matchingComputers = new ArrayList<>();

                    for (Computer comp : shop.getComputers()) {
                        if (comp.getBrand() == deleteComputerBrand) {
                            Processor compProcessor = comp.getProcessor();
                            if (compProcessor != null && compProcessor.equals(deleteProcessor)) {
                                matchingComputers.add(comp);
                            }
                        }
                    }

                    if (matchingComputers.isEmpty()) {
                        System.out.println("Компьютеры с заданными параметрами процессора не найдены.");
                    } else if (matchingComputers.size() == 1) {
                        shop.removeComputer(matchingComputers.get(0));
                        System.out.println("Компьютер удален из магазина.");
                    } else {
                        System.out.println("Найдено несколько компьютеров с заданными параметрами процессора:");
                        for (int i = 0; i < matchingComputers.size(); i++) {
                            System.out.println((i + 1) + ". " + matchingComputers.get(i));
                            System.out.println();
                        }
                        System.out.print("Выберите номер компьютера для удаления: ");
                        int choiceToDelete = scanner.nextInt();
                        if (choiceToDelete >= 1 && choiceToDelete <= matchingComputers.size()) {
                            Computer computerToDelete = matchingComputers.get(choiceToDelete - 1);
                            shop.removeComputer(computerToDelete);
                            System.out.println("Компьютер удален из магазина.");
                        } else {
                            System.out.println("Некорректный выбор.");
                        }
                    }
                    break;

                case 3:
                    System.out.print("Введите модель процессора для поиска компьютера: ");
                    String searchProcessorModel = scanner.nextLine();
                    System.out.print("Введите количество ядер процессора: ");
                    int searchProcessorCores = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Введите тактовую частоту процессора (GHz): ");
                    double searchProcessorClockSpeed = scanner.nextDouble();
                    scanner.nextLine();

                    Processor searchProcessor = new Processor(searchProcessorModel, searchProcessorCores, searchProcessorClockSpeed);

                    List<Computer> foundComputers = shop.findComputers(searchProcessor);

                    if (foundComputers.isEmpty()) {
                        System.out.println("Компьютеры с заданными параметрами процессора не найдены.");
                    } else {
                        System.out.println("Найдено несколько компьютеров с заданными параметрами процессора:");
                        for (int i = 0; i < foundComputers.size(); i++) {
                            System.out.println((i + 1) + ". " + foundComputers.get(i));
                        }
                    }
                    break;

                case 4:
                    System.out.println("Выход из программы.");
                    System.exit(0);
                    break;

                default:
                    System.out.println("Некорректный ввод. Попробуйте снова.");
            }
        }
    }
}
