package Practice_32;

import java.io.Serializable;

public class TableOrdersManager implements Serializable {
    private Order orders;

    public Order getOrders() {
        return orders;
    }

    public void setOrders(Order orders) {
        this.orders = orders;
    }

    public void add(Order order, int tableNumber) {

    }

    public void addItem(MenuItem item, int tableNumber) {

    }

    public int freeTableNumber() {
        return 0;
    }

    public int[] freeTableNumbers() {
        int x[] = {0, 0, 0};
        return x;
    }

    public void getOrder(int tableNumber) {
        System.out.println("Ваш заказ");
    }

    public void remove(int tableNumber) {
        System.out.println("Стол " + tableNumber + " убран");
    }

    public void remove(Order order) {
        System.out.println("Заказ: " + order + " убран");
    }

    public void removeAll(Order order) {
        System.out.println("Все заказы: " + order + " убраны");
    }
}
