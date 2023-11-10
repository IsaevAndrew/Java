package Practice_1;

import java.util.Locale;

public class Task6 {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        for (int i = 1; i <= 10; i++) {
            double num = 1.0 / i;
            System.out.printf("%.4f%n", num);
        }
    }
}
