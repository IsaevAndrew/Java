package Practice_3;

public class Task_Obolochki_1 {
    public static void main(String[] args) {
        Double double0 = Double.valueOf(96.69);

        double double2 = Double.parseDouble("228.75");
        System.out.println(double2);

        double double00 = double0.doubleValue();
        float float0 = double0.floatValue();
        int int0 = double0.intValue();
        long long0 = double0.longValue();
        short short0 = double0.shortValue();
        byte byte0 = double0.byteValue();

        System.out.println("Double: " + double00);
        System.out.println("Float: " + float0);
        System.out.println("Int: " + int0);
        System.out.println("Long: " + long0);
        System.out.println("Short: " + short0);
        System.out.println("Byte: " + byte0);

        System.out.println(double0);

        String d = Double.toString(3.14);
        System.out.println(d);
    }
}
