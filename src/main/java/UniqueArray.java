import java.util.HashSet;
import java.util.Scanner;
import java.util.*;

public class UniqueArray {
    public static void main(String args[]) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter the number of elements: ");
        int n = scan.nextInt();
        int a[] = new int[n];
        System.out.println("Enter the elements of array: ");
        for (int i = 0; i < n; i++) {
            a[i] = scan.nextInt();
        }
        Set<Integer> unique = new HashSet<Integer>();
        for (int i = 0; i < a.length; i++) {
            unique.add(a[i]);
        }
        System.out.println("unique elements array: " + unique);
        System.out.println("Size of array: ");
        System.out.println(unique.size());


    }
}
