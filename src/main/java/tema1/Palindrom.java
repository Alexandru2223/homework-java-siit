package tema1;

import java.util.Scanner;

public class Palindrom {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int number1 = n;
        int number2 = 0;
        while (n != 0) {
            number2 = number2 * 10 + n % 10;
            n = n / 10;
        }
        if (number1 == number2) {
            System.out.println("Tema1.Palindrom");
        } else {
            System.out.println("Nu este palindrom");
        }


    }
}
