package Practice_2;

import java.util.ArrayList;

class Dog {
    private String name;
    private int age;

    public Dog(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int calculateHumanAge() {
        return age * 7;
    }

    @Override
    public String toString() {
        return "Собака по имени " + name + ", возраст " + age + " лет (человеческий возраст: " + calculateHumanAge() + " лет)";
    }
}

class Dogs {
    private ArrayList<Dog> dogs;

    public Dogs() {
        dogs = new ArrayList<>();
    }

    public void addDog(Dog dog) {
        dogs.add(dog);
        System.out.println("Собака успешно добавлена в питомник.");
    }

    public void displayDogs() {
        if (dogs.isEmpty()) {
            System.out.println("Питомник пуст.");
        } else {
            System.out.println("Собаки в питомнике:");
            for (Dog dog : dogs) {
                System.out.println(dog);
            }
        }
    }
}

public class Task5 {
    public static void main(String[] args) {
        Dogs lst = new Dogs();
        lst.addDog(new Dog("Мухтар", 12));
        lst.addDog(new Dog("Одди", 4));
        lst.addDog(new Dog("Стрелка", 1));
        lst.displayDogs();
    }
}

