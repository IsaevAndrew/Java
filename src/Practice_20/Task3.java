package Practice_20;

import java.io.Serializable;

class Animal {
}

public class Task3<T extends Comparable<T>, V extends Animal & Serializable, K> {
    private T firstItem;
    private V secondItem;
    private K thirdItem;

    public Task3(T firstItem, V secondItem, K thirdItem) {
        this.firstItem = firstItem;
        this.secondItem = secondItem;
        this.thirdItem = thirdItem;
    }

    public T getFirstItem() {
        return firstItem;
    }

    public V getSecondItem() {
        return secondItem;
    }

    public K getThirdItem() {
        return thirdItem;
    }

    public void printClassNames() {
        System.out.println("firstItem: " + firstItem.getClass().getName());
        System.out.println("secondItem: " + secondItem.getClass().getName());
        System.out.println("thirdItem: " + thirdItem.getClass().getName());
    }

    public static void main(String[] args) {
        String stringItem = "Hello";
        Dog dogItem = new Dog();
        Integer integerItem = 42;

        Task3<String, Dog, Integer> example = new Task3<>(stringItem, dogItem, integerItem);
        example.printClassNames();
    }
}

class Dog extends Animal implements Serializable {
}
