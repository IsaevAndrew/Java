package Practice_4;

abstract class Transport {
    private String name;
    private int maxSpeed;
    private double costPerKilometer;
    private double timePerKilometer;

    public Transport(String name, int maxSpeed, double costPerKilometer, double timePerKilometer) {
        this.name = name;
        this.maxSpeed = maxSpeed;
        this.costPerKilometer = costPerKilometer;
        this.timePerKilometer = timePerKilometer;
    }

    public String getName() {
        return name;
    }

    public int getMaxSpeed() {
        return maxSpeed;
    }

    public double getCostPerKilometer() {
        return costPerKilometer;
    }

    public double getTimePerKilometer() {
        return timePerKilometer;
    }

    public abstract double calculatePassengerTransportCost(int passengers, double distance);

    public abstract double calculateCargoTransportCost(double cargoWeight, double distance);

    public abstract double calculatePassengerTransportTime(int passengers, double distance);

    public abstract double calculateCargoTransportTime(double cargoWeight, double distance);
}

class Car extends Transport {
    public Car(String name, int maxSpeed, double costPerKilometer, double timePerKilometer) {
        super(name, maxSpeed, costPerKilometer, timePerKilometer);
    }

    @Override
    public double calculatePassengerTransportCost(int passengers, double distance) {
        return getCostPerKilometer() * distance;
    }

    @Override
    public double calculateCargoTransportCost(double cargoWeight, double distance) {
        return getCostPerKilometer() * distance * (cargoWeight / 1000);
    }

    @Override
    public double calculatePassengerTransportTime(int passengers, double distance) {
        return getTimePerKilometer() * distance;
    }

    @Override
    public double calculateCargoTransportTime(double cargoWeight, double distance) {
        return getTimePerKilometer() * distance;
    }
}

class Airplane extends Transport {
    public Airplane(String name, int maxSpeed, double costPerKilometer, double timePerKilometer) {
        super(name, maxSpeed, costPerKilometer, timePerKilometer);
    }

    @Override
    public double calculatePassengerTransportCost(int passengers, double distance) {
        return getCostPerKilometer() * distance;
    }

    @Override
    public double calculateCargoTransportCost(double cargoWeight, double distance) {
        return getCostPerKilometer() * distance * (cargoWeight / 1000);
    }

    @Override
    public double calculatePassengerTransportTime(int passengers, double distance) {
        return getTimePerKilometer() * distance;
    }

    @Override
    public double calculateCargoTransportTime(double cargoWeight, double distance) {
        return getTimePerKilometer() * distance;
    }
}

class Train extends Transport {
    public Train(String name, int maxSpeed, double costPerKilometer, double timePerKilometer) {
        super(name, maxSpeed, costPerKilometer, timePerKilometer);
    }

    @Override
    public double calculatePassengerTransportCost(int passengers, double distance) {
        return getCostPerKilometer() * distance;
    }

    @Override
    public double calculateCargoTransportCost(double cargoWeight, double distance) {
        return getCostPerKilometer() * distance * (cargoWeight / 1000);
    }

    @Override
    public double calculatePassengerTransportTime(int passengers, double distance) {
        return getTimePerKilometer() * distance;
    }

    @Override
    public double calculateCargoTransportTime(double cargoWeight, double distance) {
        return getTimePerKilometer() * distance;
    }
}

class Ship extends Transport {
    public Ship(String name, int maxSpeed, double costPerKilometer, double timePerKilometer) {
        super(name, maxSpeed, costPerKilometer, timePerKilometer);
    }

    @Override
    public double calculatePassengerTransportCost(int passengers, double distance) {
        return getCostPerKilometer() * distance;
    }

    @Override
    public double calculateCargoTransportCost(double cargoWeight, double distance) {
        return getCostPerKilometer() * distance * (cargoWeight / 1000);
    }

    @Override
    public double calculatePassengerTransportTime(int passengers, double distance) {
        return getTimePerKilometer() * distance;
    }

    @Override
    public double calculateCargoTransportTime(double cargoWeight, double distance) {
        return getTimePerKilometer() * distance;
    }
}


public class Task10 {
    public static void main(String[] args) {
        Car car = new Car("Легковой автомобиль", 160, 5.0, 0.1);
        Airplane airplane = new Airplane("Пассажирский самолет", 360, 10.0, 0.05);
        Train train = new Train("Поезд", 120, 3.0, 0.15);
        Ship ship = new Ship("Корабль", 40, 2.0, 0.2);

        int passengers = 300;
        double cargoWeight = 50000.0;
        double distance = 1000.0;

        System.out.println("Легковой автомобиль:");
        System.out.println("Стоимость пассажирской перевозки: " + car.calculatePassengerTransportCost(passengers, distance));
        System.out.println("Стоимость грузовой перевозки: " + car.calculateCargoTransportCost(cargoWeight, distance));
        System.out.println("Время пассажирской перевозки: " + car.calculatePassengerTransportTime(passengers, distance));
        System.out.println("Время грузовой перевозки: " + car.calculateCargoTransportTime(cargoWeight, distance));

        System.out.println("\nПассажирский самолет:");
        System.out.println("Стоимость пассажирской перевозки: " + airplane.calculatePassengerTransportCost(passengers, distance));
        System.out.println("Стоимость грузовой перевозки: " + airplane.calculateCargoTransportCost(cargoWeight, distance));
        System.out.println("Время пассажирской перевозки: " + airplane.calculatePassengerTransportTime(passengers, distance));
        System.out.println("Время грузовой перевозки: " + airplane.calculateCargoTransportTime(cargoWeight, distance));

        System.out.println("\nПоезд:");
        System.out.println("Стоимость пассажирской перевозки: " + train.calculatePassengerTransportCost(passengers, distance));
        System.out.println("Стоимость грузовой перевозки: " + train.calculateCargoTransportCost(cargoWeight, distance));
        System.out.println("Время пассажирской перевозки: " + train.calculatePassengerTransportTime(passengers, distance));
        System.out.println("Время грузовой перевозки: " + train.calculateCargoTransportTime(cargoWeight, distance));

        System.out.println("\nКорабль:");
        System.out.println("Стоимость пассажирской перевозки: " + ship.calculatePassengerTransportCost(passengers, distance));
        System.out.println("Стоимость грузовой перевозки: " + ship.calculateCargoTransportCost(cargoWeight, distance));
        System.out.println("Время пассажирской перевозки: " + ship.calculatePassengerTransportTime(passengers, distance));
        System.out.println("Время грузовой перевозки: " + ship.calculateCargoTransportTime(cargoWeight, distance));
    }
}
