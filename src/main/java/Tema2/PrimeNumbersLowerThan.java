package Tema2;

import java.util.Scanner;
import java.util.Vector;

public class PrimeNumbersLowerThan {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter the number: ");
        int n = scan.nextInt();
        System.out.println(getPrimeNumber(n));
    }

    private static Vector getPrimeNumber(int n) {
        Vector a = new Vector();
        for (int i = 2; i <= n; i++) {
            boolean prime = true;
            for (int j = 2; j <= i / 2; j++) {
                if (i % j == 0) {
                    prime = false;
                    break;
                }
            }
            if (prime) {
                a.add(i);
            }
        }
        return a;
    }
}
