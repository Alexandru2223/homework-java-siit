package Tema1;

import java.util.Scanner;

public class SmallestNumber {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter the number of elements: ");
        int n = scan.nextInt();
        int a[] = new int[n];
        System.out.println("Enter the elements of array: ");
        for (int i = 0; i < n; i++) {
            a[i] = scan.nextInt();
        }
        int min = a[0];
        for (int i = 0; i < n; i++) {
            if (min > a[i])
                min = a[i];
        }
        System.out.println("smallest element = " + min);
    }
}
