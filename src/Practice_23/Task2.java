package Practice_23;


class EmptyQueueException extends RuntimeException {
    public EmptyQueueException(String message) {
        super(message);
    }
}

interface Queue<T> {
    void enqueue(T element);
    T dequeue() throws EmptyQueueException;

    T peek() throws EmptyQueueException;

    boolean isEmpty();

    int size();

    void clear();
}

class LinkedQueue<T> implements Queue<T> {
    private Node<T> front;
    private Node<T> rear;
    private int size;

    private static class Node<T> {
        T data;
        Node<T> next;

        Node(T data) {
            this.data = data;
            this.next = null;
        }
    }

    public LinkedQueue() {
        front = null;
        rear = null;
        size = 0;
    }

    @Override
    public void enqueue(T element) {
        Node<T> newNode = new Node<>(element);
        if (isEmpty()) {
            front = newNode;
            rear = newNode;
        } else {
            rear.next = newNode;
            rear = newNode;
        }
        size++;
    }

    @Override
    public T dequeue() throws EmptyQueueException {
        if (isEmpty()) {
            throw new EmptyQueueException("Queue is empty");
        }
        T data = front.data;
        front = front.next;
        size--;
        return data;
    }

    @Override
    public T peek() throws EmptyQueueException {
        if (isEmpty()) {
            throw new EmptyQueueException("Queue is empty");
        }
        return front.data;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void clear() {
        front = null;
        rear = null;
        size = 0;
    }
}

abstract class AbstractQueue<T> implements Queue<T> {
    protected int size;

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void clear() {
        while (!isEmpty()) {
            dequeue();
        }
    }
}


public class Task2 {
    public static void main(String[] args) {
        Queue<Integer> queue = new LinkedQueue<>();

        for (int i = 1; i <= 5; i++) {
            queue.enqueue(i);
        }

        System.out.println("Размер очереди: " + queue.size());

        System.out.println("Очередь пуста? " + queue.isEmpty());

        try {
            while (!queue.isEmpty()) {
                System.out.println("Извлечено: " + queue.dequeue());
            }
        } catch (EmptyQueueException e) {
            System.out.println("Очередь пуста.");
        }

        System.out.println("Очередь пуста? " + queue.isEmpty());

        try {
            System.out.println("Подглядываем: " + queue.peek());
        } catch (EmptyQueueException e) {
            System.out.println("Очередь пуста.");
        }
    }
}
