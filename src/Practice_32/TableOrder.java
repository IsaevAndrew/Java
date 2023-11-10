package Practice_32;

import java.io.Serializable;

public class TableOrder implements Serializable {
    private int size;
    private MenuItem items;

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public MenuItem getItems() {
        return items;
    }

    public void setItems(MenuItem items) {
        this.items = items;
    }
}
