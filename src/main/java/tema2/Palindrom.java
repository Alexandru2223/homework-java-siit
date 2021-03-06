package tema2;

import java.util.Scanner;

public class Palindrom {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Introduceti numarul: ");
        int n = scan.nextInt();
        int number1 = n;
        int number2 = 0;
        if (getPalindrom(n, number1, number2)) {
            System.out.println("Palindrom");
        } else {
            System.out.println("Nu este palindrom");
        }


    }

    private static boolean getPalindrom(int n, int number1, int number2) {
        while (n != 0) {
            number2 = number2 * 10 + n % 10;
            n = n / 10;
        }
        if (number1 == number2) {
            return true;
        } else {
            return false;
        }
    }
}
