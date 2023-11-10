package Practice_11;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class Task5 {
    public static void main(String[] args) {
        List<Integer> arrayList = new ArrayList<>();
        List<Integer> linkedList = new LinkedList<>();
        Random random = new Random();

        int n = 100000;

        for (int i = 0; i < n; i++) {
            int randomValue = random.nextInt(1000000);
            arrayList.add(randomValue);
            linkedList.add(randomValue);
        }

        long startTime = System.nanoTime();
        arrayList.add(0, 9999999);
        long endTime = System.nanoTime();
        long arrayListInsertTime = endTime - startTime;

        startTime = System.nanoTime();
        linkedList.add(0, 9999999);
        endTime = System.nanoTime();
        long linkedListInsertTime = endTime - startTime;
        int middleIndex = n / 2;
        startTime = System.nanoTime();
        arrayList.remove(middleIndex);
        endTime = System.nanoTime();
        long arrayListRemoveTime = endTime - startTime;

        startTime = System.nanoTime();
        linkedList.remove(middleIndex);
        endTime = System.nanoTime();
        long linkedListRemoveTime = endTime - startTime;
        middleIndex = n / 2;
        int valueToAdd = 9999999;
        startTime = System.nanoTime();
        arrayList.add(middleIndex, valueToAdd);
        endTime = System.nanoTime();
        long arrayListAddTime = endTime - startTime;

        startTime = System.nanoTime();
        linkedList.add(middleIndex, valueToAdd);
        endTime = System.nanoTime();
        long linkedListAddTime = endTime - startTime;
        int searchValue = 9999999;
        startTime = System.nanoTime();
        arrayList.contains(searchValue);
        endTime = System.nanoTime();
        long arrayListSearchTime = endTime - startTime;

        startTime = System.nanoTime();
        linkedList.contains(searchValue);
        endTime = System.nanoTime();
        long linkedListSearchTime = endTime - startTime;
        System.out.println("Время выполнения операции вставки в начало (нс) - ArrayList: " + arrayListInsertTime);
        System.out.println("Время выполнения операции вставки в начало (нс) - LinkedList: " + linkedListInsertTime);
        System.out.println("Время выполнения операции удаления из середины (нс) - ArrayList: " + arrayListRemoveTime);
        System.out.println("Время выполнения операции удаления из середины (нс) - LinkedList: " + linkedListRemoveTime);
        System.out.println("Время выполнения операции добавления в середину (нс) - ArrayList: " + arrayListAddTime);
        System.out.println("Время выполнения операции добавления в середину (нс) - LinkedList: " + linkedListAddTime);
        System.out.println("Время выполнения операции поиска по образцу (нс) - ArrayList: " + arrayListSearchTime);
        System.out.println("Время выполнения операции поиска по образцу (нс) - LinkedList: " + linkedListSearchTime);
    }
}
