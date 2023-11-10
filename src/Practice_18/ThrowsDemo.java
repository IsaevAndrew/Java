package Practice_18;

public class ThrowsDemo {
    public void getDetails(String key) {
        if (key == null) {
            throw new NullPointerException("null key in getDetails");
        }
    }

    public void printMessage(String key) {
        try {
            getDetails(key);
        } catch (NullPointerException e) {
            System.out.println("Error: " + e.getMessage());
        }

    }

    public static void main(String[] args) {
        ThrowsDemo demo = new ThrowsDemo();
        demo.printMessage("valid_key");
        demo.printMessage(null);
    }
}
