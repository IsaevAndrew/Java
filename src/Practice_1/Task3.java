package Practice_1;

import java.util.Scanner;

public class Task3 {
    public static void main(String[] args) {
        int number, sum=0, size;
        Scanner scanner = new Scanner(System.in);
        size = scanner.nextInt();
        for(int i=0; i<size;i++){
            number = scanner.nextInt();
            sum+=number;
        }
        System.out.println(sum);
        System.out.println((float)sum/size);
    }
}
