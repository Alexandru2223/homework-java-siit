package Tema2;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class UniqueArray {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter the number of elements: ");
        int n = scan.nextInt();
        int a[] = new int[n];
        System.out.println("Enter the elements of array: ");
        for (int i = 0; i < n; i++) {
            a[i] = scan.nextInt();
        }
        Set<Integer> unique = getIntegers(a);
        System.out.println("unique elements array: " + unique);
        System.out.println("Size of array: ");
        System.out.println(unique.size());


    }

    private static Set<Integer> getIntegers(int[] a) {
        Set<Integer> unique = new HashSet<Integer>();
        for (int i = 0; i < a.length; i++) {
            unique.add(a[i]);
        }
        return unique;
    }
}
