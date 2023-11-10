package Practice_23;

import java.util.NoSuchElementException;

class ArrayQueueModule {
    private static Object[] elements = new Object[10];
    private static int size = 0;
    private static int front = 0;

    // Предусловие: элемент не null
    // Постусловие: элемент добавлен в очередь
    public static void enqueue(Object element) {
        ensureCapacity(size + 1);
        int rear = (front + size) % elements.length;
        elements[rear] = element;
        size++;
    }

    // Предусловие: очередь не пуста
    // Постусловие: удаляет и возвращает первый элемент в очереди
    public static Object dequeue() {
        if (isEmpty()) {
            throw new NoSuchElementException("Queue is empty");
        }
        Object element = elements[front];
        elements[front] = null;
        front = (front + 1) % elements.length;
        size--;
        return element;
    }

    // Предусловие: очередь не пуста
    // Постусловие: возвращает первый элемент в очереди
    public static Object element() {
        if (isEmpty()) {
            throw new NoSuchElementException("Queue is empty");
        }
        return elements[front];
    }

    // Предусловие: нет
    // Постусловие: возвращает размер очереди
    public static int size() {
        return size;
    }

    // Предусловие: нет
    // Постусловие: возвращает true, если очередь пуста, иначе - false
    public static boolean isEmpty() {
        return size == 0;
    }

    // Предусловие: нет
    // Постусловие: очищает очередь
    public static void clear() {
        elements = new Object[10];
        size = 0;
        front = 0;
    }

    // Обеспечение достаточной емкости массива
    private static void ensureCapacity(int capacity) {
        if (capacity > elements.length) {
            int newCapacity = Math.max(capacity, 2 * elements.length);
            Object[] newElements = new Object[newCapacity];
            for (int i = 0; i < size; i++) {
                newElements[i] = elements[(front + i) % elements.length];
            }
            elements = newElements;
            front = 0;
        }
    }
}


class ArrayQueueADT {
    private Object[] elements = new Object[10];
    private int size = 0;
    private int front = 0;

    // Создание новой очереди
    public static ArrayQueueADT create() {
        return new ArrayQueueADT();
    }

    // Предусловие: элемент не null
    // Постусловие: элемент добавлен в очередь
    public void enqueue(Object element) {
        ensureCapacity(size + 1);
        int rear = (front + size) % elements.length;
        elements[rear] = element;
        size++;
    }

    // Предусловие: очередь не пуста
    // Постусловие: удаляет и возвращает первый элемент в очереди
    public Object dequeue() {
        if (isEmpty()) {
            throw new NoSuchElementException("Queue is empty");
        }
        Object element = elements[front];
        elements[front] = null;
        front = (front + 1) % elements.length;
        size--;
        return element;
    }

    // Предусловие: очередь не пуста
    // Постусловие: возвращает первый элемент в очереди
    public Object element() {
        if (isEmpty()) {
            throw new NoSuchElementException("Queue is empty");
        }
        return elements[front];
    }

    // Предусловие: нет
    // Постусловие: возвращает размер очереди
    public int size() {
        return size;
    }

    // Предусловие: нет
    // Постусловие: возвращает true, если очередь пуста, иначе - false
    public boolean isEmpty() {
        return size == 0;
    }

    // Предусловие: нет
    // Постусловие: очищает очередь
    public void clear() {
        elements = new Object[10];
        size = 0;
        front = 0;
    }

    // Обеспечение достаточной емкости массива
    private void ensureCapacity(int capacity) {
        if (capacity > elements.length) {
            int newCapacity = Math.max(capacity, 2 * elements.length);
            Object[] newElements = new Object[newCapacity];
            for (int i = 0; i < size; i++) {
                newElements[i] = elements[(front + i) % elements.length];
            }
            elements = newElements;
            front = 0;
        }
    }
}

class ArrayQueue {
    private Object[] elements = new Object[10];
    private int size = 0;
    private int front = 0;

    // Предусловие: элемент не null
    // Постусловие: элемент добавлен в очередь
    public void enqueue(Object element) {
        ensureCapacity(size + 1);
        int rear = (front + size) % elements.length;
        elements[rear] = element;
        size++;
    }

    // Предусловие: очередь не пуста
    // Постусловие: удаляет и возвращает первый элемент в очереди
    public Object dequeue() {
        if (isEmpty()) {
            throw new NoSuchElementException("Queue is empty");
        }
        Object element = elements[front];
        elements[front] = null;
        front = (front + 1) % elements.length;
        size--;
        return element;
    }
    public Object element() {
        if (isEmpty()) {
            throw new NoSuchElementException("Queue is empty");
        }
        return elements[front];
    }

    // Предусловие: нет
    // Постусловие: возвращает размер очереди
    public int size() {
        return size;
    }

    // Предусловие: нет
    // Постусловие: возвращает true, если очередь пуста, иначе - false
    public boolean isEmpty() {
        return size == 0;
    }

    // Предусловие: нет
    // Постусловие: очищает очередь
    public void clear() {
        elements = new Object[10];
        size = 0;
        front = 0;
    }

    // Обеспечение достаточной емкости массива
    private void ensureCapacity(int capacity) {
        if (capacity > elements.length) {
            int newCapacity = Math.max(capacity, 2 * elements.length);
            Object[] newElements = new Object[newCapacity];
            for (int i = 0; i < size; i++) {
                newElements[i] = elements[(front + i) % elements.length];
            }
            elements = newElements;
            front = 0;
        }
    }
}

public class Task1 {
    public static void main(String[] args) {
        ArrayQueueModule queue1 = new ArrayQueueModule();
        ArrayQueueADT queue2 = new ArrayQueueADT();
        ArrayQueue queue3 = new ArrayQueue();

        for (int i = 1; i <= 5; i++) {
            queue1.enqueue(i);
            queue2.enqueue(i * 10);
            queue3.enqueue(i * 100);
        }

        while (!queue1.isEmpty()) {
            System.out.print(queue1.dequeue() + " ");
        }
        System.out.println();

        while (!queue2.isEmpty()) {
            System.out.print(queue2.dequeue() + " ");
        }
        System.out.println();

        queue3.clear();
        while (!queue3.isEmpty()) {
            System.out.print(queue3.dequeue() + " ");
        }
        System.out.println();
    }
}
