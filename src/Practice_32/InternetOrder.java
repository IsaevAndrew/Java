package Practice_32;

import java.io.Serializable;
public class InternetOrder implements Order, Serializable {
    public boolean add(Item item) {
        Node node = new Node(item);
        if (head == null) {
            head = node;
            head.next = head;
            head.prev = head;
        } else {
            node.next = head.next;
            head.next = node;
            head.next.prev = node;
            node.prev = head;
            head = node;
        }
        size++;
        return true;
    }

    public boolean remove(String itemName) {
        Node current = head;
        for (int i = 0; i < size; i++) {
            if (current.item.getName().equals(itemName)) {
                current.prev.next = current.next;
                current.next.prev = current.prev;
                size--;
                return true;
            }
            current = current.next;
        }
        return false;
    }

    public int removeAll(String itemName) {
        int cnt = 0;

        while (remove(itemName)) {
            cnt += 1;
        }
        return cnt;
    }

    public int getOrderSize() {
        return size;
    }



    @Override
    public Item[] getItems() {
        Item[] items = new Item[size];
        Node current = head;
        for (int i = 0; i < size; i++) {
            items[i] = current.item;
            current = current.next;
        }
        return items;
    }

    @Override
    public double getTotalCost() {
        double res = 0;
        for (Item item: getItems()) {
            res += item.getCost();
        }
        return res;
    }


    @Override
    public Item[] getSortedItemsByPrice() {
        return new Item[0];
    }

    @Override
    public int getQuantity(String itemName) {
        int cnt = 0;
        for (Item item: getItems()) {
            if (item.getName().equals(itemName)) {
                cnt += 1;
            }
        }
        return cnt;
    }

    @Override
    public String[] getItemNames() {
        String[] names = new String[size];
        int idx = 0;
        for (Item item: getItems()) {
            names[idx] = item.getName();
            idx++;
        }
        return names;
    }

    public Item[] getSortedItems() {
        Item[] items = getItems();

        for (int i = 0; i < items.length; i++) {
            for (int j = i + 1; j < items.length; j++) {
                if (items[i].getCost() > items[j].getCost()) {
                    Item tmp = items[i];
                    items[i] = items[j];
                    items[j] = tmp;
                }
            }
        }
        return items;
    }

    class Node implements Serializable {
        Item item;
        Node next;
        Node prev;

        public Node(Item item) {
            this.item = item;
            next = null;
            prev = null;
        }
    }

    private Node head;
    private int size;

    public InternetOrder() {
        head = null;
        size = 0;
    }


    void print() {
        Node current = head;

        for (int i = 0; i < size; i++) {
            System.out.println(current.item.getDescription() + " " + current.item.getName() + " " + current.item.getCost() + " рублей");
            current = current.next;
        }
    }

    public InternetOrder(Item[] items) {
        this();

        for (int i = 0; i < items.length; i++) {
            add(items[i]);
        }
    }
}
