package tema2;

import java.util.Arrays;
import java.util.Scanner;

public class Exercise2 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter the number of fibonacci sequence: ");
        int n = scan.nextInt();
        System.out.println(Arrays.toString(fib(n)));
    }

    private static int[] fib(int x) {
        int[] a = new int[x];
        for (int i = 0; i < x; i++) {
            if (i < 2) {
                a[i] = i;
            } else {
                a[i] = a[i-1] + a[i - 2];
            }
        }
        return a;
    }
}
