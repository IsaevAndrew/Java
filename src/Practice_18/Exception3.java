package Practice_18;

import java.util.Scanner;

public class Exception3 {
    public static void main(String[] args) {
        Scanner myScanner = new Scanner(System.in);
        System.out.print("Enter an integer: ");
        String intString = myScanner.next();

        try {
            int i = Integer.parseInt(intString);
            System.out.println(2 / i);
        } catch (Exception e) {
            System.out.println("Exception caught: " + e.getMessage());
        }
//        catch (NumberFormatException e) {
//            System.out.println("NumberFormatException: " + e.getMessage());
//        } catch (ArithmeticException e) {
//            System.out.println("ArithmeticException: " + e.getMessage());
//        }
    }
}
