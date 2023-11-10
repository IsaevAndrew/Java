package Practice_4;

class Phone {
    private String number;
    private String model;
    private double weight;

    public Phone(String number, String model, double weight) {
        this(number, model);
        this.weight = weight;
    }

    public Phone(String number, String model) {
        this.number = number;
        this.model = model;
    }

    public Phone() {
        this("", "");
    }

    public void receiveCall(String callerName) {
        System.out.println("Звонит " + callerName);
    }

    public void receiveCall(String callerName, String callerNumber) {
        System.out.println("Звонит " + callerName + " (номер: " + callerNumber + ")");
    }

    public void sendMessage(String... phoneNumbers) {
        System.out.println("Отправлено сообщение на следующие номера:");
        for (String number : phoneNumbers) {
            System.out.println(number);
        }
        System.out.println();
    }

    @Override
    public String toString() {
        return "Номер телефона: " + number + ", модель: " + model + ", вес: " + weight;
    }

    public String getNumber() {
        return number;
    }
}

public class Task2 {
    public static void main(String[] args) {
        Phone phone1 = new Phone("88005553535", "iPhone 13", 0.225);
        Phone phone2 = new Phone("86666666666", "Xiaomi Redmi Note 6 Pro");
        Phone phone3 = new Phone();


        System.out.println(phone1);
        System.out.println(phone2);
        System.out.println(phone3);

        phone1.receiveCall("Олег");
        phone2.receiveCall("Миша");
        phone3.receiveCall("Гена");

        phone1.getNumber();
        phone2.getNumber();
        phone3.getNumber();

        phone1.receiveCall("Саша", "89876543210");
        phone1.sendMessage("84942789545", "88888888888", "89996664243");


    }
}

