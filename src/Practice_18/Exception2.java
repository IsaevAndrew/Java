package Practice_18;

import java.util.Scanner;

public class Exception2 {
    public static void main(String[] args) {
//        Scanner myScanner = new Scanner( System.in);
//        System.out.print( "Enter an integer ");
//        String intString = myScanner.next();
//        int i = Integer.parseInt(intString);
//        System.out.println( 2/i );
        Scanner myScanner = new Scanner(System.in);
        System.out.print("Enter an integer: ");
        String intString = myScanner.next();

        try {
            int i = Integer.parseInt(intString);
            System.out.println(2 / i);
        } catch (NumberFormatException e) {
            System.out.println("NumberFormatException: " + e.getMessage());
        } catch (ArithmeticException e) {
            System.out.println("ArithmeticException: " + e.getMessage());
        }
    }
}

