package Practice_32;

import java.util.HashMap;
import java.io.Serializable;

public class OrderManager extends Customer implements Order, Serializable {
    private HashMap<String, Order> orderMap;

    public OrderManager() {
        this.orderMap = new HashMap<>();
    }

    public void addOrder(String address, Order order) {
        orderMap.put(address, order);
    }

    public Order getOrder(String address) {
        return orderMap.get(address);
    }

    public void removeOrder(String address) {
        orderMap.remove(address);
    }

    public void addItemToOrder(String address, Item item) {
        Order order = orderMap.get(address);
        if (order != null) {
            order.add(item);
        }
    }

    public Order[] getAllOrders() {
        return orderMap.values().toArray(new Order[0]);
    }

    public double getTotalCostOfOrders() {
        double totalCost = 0.0;
        for (Order order : orderMap.values()) {
            totalCost += order.getTotalCost();
        }
        return totalCost;
    }

    public int getTotalQuantityOfItem(String itemName) {
        int totalQuantity = 0;
        for (Order order : orderMap.values()) {
            totalQuantity += order.getQuantity(itemName);
        }
        return totalQuantity;
    }


    @Override
    public boolean add(Item item) {
        return false;
    }

    @Override
    public boolean remove(String itemName) {
        return false;
    }

    @Override
    public int removeAll(String itemName) {
        return 0;
    }

    @Override
    public int getOrderSize() {
        return 0;
    }

    @Override
    public Item[] getItems() {
        return new Item[0];
    }

    @Override
    public double getTotalCost() {
        return 0;
    }

    @Override
    public int getQuantity(String itemName) {
        return 0;
    }

    @Override
    public String[] getItemNames() {
        return new String[0];
    }

    @Override
    public Item[] getSortedItemsByPrice() {
        return new Item[0];
    }

    @Override
    public boolean add(MenuItem item) {
        return Order.super.add(item);
    }

    @Override
    public String[] itemNames() {
        return Order.super.itemNames();
    }

    @Override
    public int itemQuantity(String itemName) {
        return Order.super.itemQuantity(itemName);
    }

    @Override
    public int itemQuantity(MenuItem itemName) {
        return Order.super.itemQuantity(itemName);
    }

    @Override
    public void sortedItemsByCostDesc() {
        Order.super.sortedItemsByCostDesc();
    }

    @Override
    public int costTotal() {
        return Order.super.costTotal();
    }

    @Override
    public Customer getCustomer() {
        return Order.super.getCustomer();
    }

    @Override
    public void setCustomer() {
        Order.super.setCustomer();
    }
}
