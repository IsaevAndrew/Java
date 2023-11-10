package Practice_32;

public class OrderAlreadyAddedException extends Exception {
    public OrderAlreadyAddedException() {
        super("Заказ уже добавлен!");
    }
}
