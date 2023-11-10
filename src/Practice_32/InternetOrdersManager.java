package Practice_32;

import java.io.Serializable;
public class InternetOrdersManager extends QueueNode implements Serializable {
    private QueueNode head;
    private QueueNode tail;
    private int size;

    public QueueNode getHead() {
        return head;
    }

    public void setHead(QueueNode head) {
        this.head = head;
    }

    public QueueNode getTail() {
        return tail;
    }

    public void setTail(QueueNode tail) {
        this.tail = tail;
    }

    public int getSize() {
        return size;
    }


    public boolean add(Order order){
        System.out.println("Заказ добавлен!");
        return true;
    }

    public void remove(){
        System.out.println("Заказ удален!");
    }

    public void order(){
    }
}
