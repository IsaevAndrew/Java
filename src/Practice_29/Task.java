package Practice_29;

import java.util.*;

interface Item {
    double getCost();
    String getName();
    String getDescription();
}

final class Drink implements Item {
    private final double cost;
    private final String name;
    private final String description;

    public Drink(double cost, String name, String description) {
        if (cost < 0 || name.isEmpty() || description.isEmpty()) {
            throw new IllegalArgumentException("Неправильные параметры");
        }
        this.cost = cost;
        this.name = name;
        this.description = description;
    }

    @Override
    public double getCost() {
        return cost;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getDescription() {
        return description;
    }
}

final class Dish implements Item {
    private final double cost;
    private final String name;
    private final String description;

    public Dish(double cost, String name, String description) {
        if (cost < 0 || name.isEmpty() || description.isEmpty()) {
            throw new IllegalArgumentException("Неправильные параметры");
        }
        this.cost = cost;
        this.name = name;
        this.description = description;
    }

    @Override
    public double getCost() {
        return cost;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getDescription() {
        return description;
    }
}

class InternetOrder implements Order {
    private ListNode head;
    private int size;

    public InternetOrder() {
        head = new ListNode(null);
        size = 0;
    }

    public InternetOrder(Item[] items) {
        this();
        for (Item item : items) {
            addPosition(item);
        }
    }

    public boolean addPosition(Item item) {
        if (item == null) {
            return false;
        }

        ListNode newNode = new ListNode(item);
        ListNode lastNode = head.getPrev();

        if (lastNode == null) {
            head.setNext(newNode);
            newNode.setPrev(head);
        } else {
            lastNode.setNext(newNode);
            newNode.setPrev(lastNode);
        }

        head.setPrev(newNode);
        newNode.setNext(head);

        size++;
        return true;
    }

    public boolean removePosition(String name) {
        ListNode currentNode = head.getNext();
        while (currentNode != head) {
            Item item = currentNode.getItem();
            if (item != null && item.getName().equals(name)) {
                ListNode prevNode = currentNode.getPrev();
                ListNode nextNode = currentNode.getNext();
                prevNode.setNext(nextNode);
                nextNode.setPrev(prevNode);
                size--;
                return true;
            }
            currentNode = currentNode.getNext();
        }
        return false;
    }

    public Item[] getItems() {
        Item[] items = new Item[size];
        ListNode currentNode = head.getNext();
        for (int i = 0; i < size; i++) {
            items[i] = currentNode.getItem();
            currentNode = currentNode.getNext();
        }
        return items;
    }

    public double getTotalCost() {
        double totalCost = 0;
        ListNode currentNode = head.getNext();
        while (currentNode != head) {
            Item item = currentNode.getItem();
            if (item != null) {
                totalCost += item.getCost();
            }
            currentNode = currentNode.getNext();
        }
        return totalCost;
    }

    public int getTotalDishes(String name) {
        int count = 0;
        ListNode currentNode = head.getNext();
        while (currentNode != head) {
            Item item = currentNode.getItem();
            if (item != null && item.getName().equals(name)) {
                count++;
            }
            currentNode = currentNode.getNext();
        }
        return count;
    }

    public String[] getUniqueItemNames() {
        HashSet<String> uniqueNames = new HashSet<>();
        ListNode currentNode = head.getNext();
        while (currentNode != head) {
            Item item = currentNode.getItem();
            if (item != null) {
                uniqueNames.add(item.getName());
            }
            currentNode = currentNode.getNext();
        }
        return uniqueNames.toArray(new String[0]);
    }

    public Item[] getSortedItemsByCost() {
        Item[] items = getItems();
        Arrays.sort(items, (a, b) -> Double.compare(b.getCost(), a.getCost()));
        return items;
    }

    private class ListNode {
        private Item item;
        private ListNode prev;
        private ListNode next;

        public ListNode(Item item) {
            this.item = item;
        }

        public Item getItem() {
            return item;
        }

        public ListNode getPrev() {
            return prev;
        }

        public void setPrev(ListNode prev) {
            this.prev = prev;
        }

        public ListNode getNext() {
            return next;
        }

        public void setNext(ListNode next) {
            this.next = next;
        }
    }
}

interface Order {
    boolean addPosition(Item item);

    boolean removePosition(String name);

    Item[] getItems();

    double getTotalCost();

    int getTotalDishes(String name);

    String[] getUniqueItemNames();

    Item[] getSortedItemsByCost();
}

class RestaurantOrder extends InternetOrder implements Order {
    private int tableNumber;

    public RestaurantOrder() {
        super();
        this.tableNumber = -1;
    }

    public RestaurantOrder(Item[] items, int tableNumber) {
        super(items);
        this.tableNumber = tableNumber;
    }

    public int getTableNumber() {
        return tableNumber;
    }
}


class OrderManager {
    private final Map<String, Order> ordersByAddress;
    private final Map<Integer, Order> ordersByTable;
    private final List<Order> allOrders;

    public OrderManager() {
        ordersByAddress = new HashMap<>();
        ordersByTable = new HashMap<>();
        allOrders = new ArrayList<>();
    }

    public void addOrder(String address, Order order) throws OrderAlreadyAddedException {
        if (ordersByAddress.containsKey(address) || allOrders.contains(order)) {
            throw new OrderAlreadyAddedException("Заказ с этим адресом уже добавлен");
        }

        ordersByAddress.put(address, order);
        allOrders.add(order);

        if (order instanceof RestaurantOrder) {
            RestaurantOrder restaurantOrder = (RestaurantOrder) order;
            if (restaurantOrder.getTableNumber() != -1) {
                ordersByTable.put(restaurantOrder.getTableNumber(), order);
            }
        }
        System.out.println("Добавлен интернет-заказ по адресу: " + address);
    }

    public Order getOrder(String address) {
        return ordersByAddress.get(address);
    }

    public void removeOrder(String address) {
        Order order = ordersByAddress.get(address);
        if (order != null) {
            ordersByAddress.remove(address);
            allOrders.remove(order);
            if (order instanceof RestaurantOrder) {
                RestaurantOrder restaurantOrder = (RestaurantOrder) order;
                if (restaurantOrder.getTableNumber() != -1) {
                    ordersByTable.remove(restaurantOrder.getTableNumber());
                }
            }
        }
    }

    public void addDishToOrder(String address, Item item) throws IllegalTableNumber {
        Order order = ordersByAddress.get(address);
        if (order == null) {
            throw new IllegalTableNumber("Нет заказа с таким адресом");
        }

        if (item instanceof Dish) {
            order.addPosition(item);
        } else {
            System.err.println("Ошибка! Только блюда могут быть добавлены");
        }
    }





    public Order[] getAllOrders() {
        return allOrders.toArray(new Order[0]);
    }

    public double getTotalOrdersCost() {
        double totalCost = 0;
        for (Order order : allOrders) {
            totalCost += order.getTotalCost();
        }
        return totalCost;
    }

    public int getTotalDishesByName(String dishName) {
        int totalDishes = 0;
        for (Order order : allOrders) {
            totalDishes += order.getTotalDishes(dishName);
        }
        return totalDishes;
    }
}

class OrderAlreadyAddedException extends Exception {
    public OrderAlreadyAddedException(String message) {
        super(message);
    }
}

class IllegalTableNumber extends IllegalArgumentException {
    public IllegalTableNumber(String message) {
        super(message);
    }
}

public class Task {
    public static void main(String[] args) {
        Dish dish1 = new Dish(400, "Паста", "Спагетти с томатным соусом");
        Dish dish2 = new Dish(300, "Пицца", "Пицца Маргарита");
        Drink drink1 = new Drink(60, "Лимонад", "Кола");

        InternetOrder internetOrder = new InternetOrder();
        internetOrder.addPosition(dish1);
        internetOrder.addPosition(drink1);

        OrderManager orderManager = new OrderManager();
        try {
            orderManager.addOrder("проспект Вернадского 86", internetOrder);
        } catch (OrderAlreadyAddedException e) {
            System.err.println("Ошибка: " + e.getMessage());
        }

        InternetOrder internetOrder2 = new InternetOrder();
        try {
            orderManager.addOrder("улица Северной правды 31", internetOrder2);
        } catch (OrderAlreadyAddedException e) {
            System.err.println("Ошибка: " + e.getMessage());
        }

        Dish dish2Object = new Dish(dish2.getCost(), dish2.getName(), dish2.getDescription());
        try {
            orderManager.addDishToOrder("улица Северной правды 31", dish2Object);
        } catch (IllegalTableNumber e) {
            System.err.println("Ошибка: " + e.getMessage());
        }

        Item drink2 = new Drink(100, "Лимонад", "Лимонад");
        Item dish3 = new Dish(200, "Бургер", "Говяжий бургер");

        InternetOrder internetOrder3 = new InternetOrder();
        try {
            orderManager.addOrder("улица Пушкина 7", internetOrder3);
        } catch (OrderAlreadyAddedException e) {
            System.err.println("Ошибка: " + e.getMessage());
        }
        try {
            internetOrder3.addPosition(drink2);
            orderManager.addDishToOrder("улица Пушкина 7", dish3);
        } catch (IllegalTableNumber e) {
            System.err.println("Ошибка: " + e.getMessage());
        }

        Order[] allOrders = orderManager.getAllOrders();
        System.out.println("Все заказы:");
        for (Order order : allOrders) {
            System.out.println("Общая стоимость заказа: " + order.getTotalCost());
            System.out.println("Количество блюд 'Лимонад' в заказе: " + order.getTotalDishes("Лимонад"));
            System.out.println("Уникальные наименования товаров в заказе: " + Arrays.toString(order.getUniqueItemNames()));
            System.out.println();
        }

        System.out.println("Общая стоимость всех заказов: " + orderManager.getTotalOrdersCost());
        System.out.println("Общее количество блюд 'Лимонад' во всех заказах: " + orderManager.getTotalDishesByName("Лимонад"));
    }
}
