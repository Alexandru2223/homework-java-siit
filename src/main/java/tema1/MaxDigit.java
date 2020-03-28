package tema1;

import java.util.Scanner;

public class MaxDigit {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter the number: ");
        int n = scan.nextInt();
        int i = 0;
        String s = Integer.toString(n);
        int a[] = new int[s.length()];
        while (n != 0) {
            a[i] = n % 10;
            n = n / 10;
            i++;
        }
        int max = a[0];
        for (int j = 0; j < a.length; j++) {
            if (max < a[j])
                max = a[j];
        }
        System.out.println("max digit = " + max);
    }
}
