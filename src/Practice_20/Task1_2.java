package Practice_20;

public class Task1_2<T, V, K> {
    private T firstItem;
    private V secondItem;
    private K thirdItem;

    public Task1_2(T firstItem, V secondItem, K thirdItem) {
        this.firstItem = firstItem;
        this.secondItem = secondItem;
        this.thirdItem = thirdItem;
    }

    public T getFirstItem() {
        return firstItem;
    }

    public V getSecondItem() {
        return secondItem;
    }

    public K getThirdItem() {
        return thirdItem;
    }

    public void printClassNames() {
        System.out.println("firstItem: " + firstItem.getClass().getName());
        System.out.println("secondItem: " + secondItem.getClass().getName());
        System.out.println("thirdItem: " + thirdItem.getClass().getName());
    }

    public static void main(String[] args) {
        Task1_2<String, Integer, Double> example = new Task1_2<>("Hello", 42, 3.14);
        example.printClassNames();
    }
}
