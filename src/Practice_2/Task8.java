package Practice_2;

public class Task8 {
    public static void main(String[] args) {
        String[] array = {"q", "w", "e", "r", "t", "y"};
        int len = array.length;
        for (int i = 0; i < len / 2; i++) {
            String a = array[i];
            array[i] = array[len - 1 - i];
            array[len - 1 - i] = a;
        }
        for (String el : array) {
            System.out.print(el + " ");
        }
    }
}
