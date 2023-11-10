package Practice_26;

import java.util.PriorityQueue;

public class Task4 {
    public static void main(String[] args) {
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
        priorityQueue.add(10);
        priorityQueue.add(5);
        priorityQueue.add(15);
        priorityQueue.add(3);
        priorityQueue.add(20);
        priorityQueue.add(7);
        priorityQueue.add(25);
        priorityQueue.add(1);
        priorityQueue.add(30);
        priorityQueue.add(12);

        int elementsToExtract = 3;
        System.out.println("Извлечение " + elementsToExtract + " элементов из очереди с приоритетом:");

        for (int i = 0; i < elementsToExtract; i++) {
            int element = priorityQueue.poll();
            System.out.println("Извлечен элемент: " + element);
        }
    }
}

