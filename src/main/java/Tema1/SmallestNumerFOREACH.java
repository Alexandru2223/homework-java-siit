package Tema1;

import java.util.Scanner;

public class SmallestNumerFOREACH {
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
        for (int num : a) {
            if (min > num) {
                min = num;
            }
        }
        System.out.println("smallest element = " + min);
    }
}
