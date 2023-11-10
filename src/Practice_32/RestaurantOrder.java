package Practice_32;

import java.io.Serializable;

public final class RestaurantOrder implements Order, Serializable {
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
}
