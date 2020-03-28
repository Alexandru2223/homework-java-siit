package tema2;

import java.util.*;

public class Exercise5 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter the sum: ");
        int sum = scan.nextInt();
        System.out.println("Enter the number of elements in array: ");
        int n = scan.nextInt();
        int array[] = new int[n];
        System.out.println("Enter the elements of array: ");
        for (int i = 0; i < n; i++) {
            array[i] = scan.nextInt();
        }
        int[] array1 = getInts(array);


        //   System.out.println(findNumberOfPairs(sum, array1));
        System.out.println(Arrays.toString(findDuplicates(findNumberOfPairs(sum, array1), sum, array1)));

    }

    private static int[] getInts(int[] array) {
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < array.length; i++) {
            set.add(array[i]);
        }
        int array1[] = new int[set.size()];
        int c = 0;
        Iterator it = set.iterator();
        while (it.hasNext()) {
            // System.out.println(it.next());
            array1[c] = (int) it.next();
            c++;
        }
        return array1;
    }

    private static ArrayList[] findDuplicates(int numberOfPairs, int sum, int[] array) {
        ArrayList[] al = new ArrayList[numberOfPairs];
        for (int i = 0; i < numberOfPairs; i++) {
            al[i] = new ArrayList<Integer>();
        }
        int k = 0;
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length; j++) {
                if (array[i] + array[j] == sum) {
                    al[k].add(array[i]);
                    al[k].add(array[j]);
                    k++;
                }
            }
        }
        return al;
    }

    private static int findNumberOfPairs(int sum, int array[]) {
        int k = 0;
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length; j++) {
                if (array[i] + array[j] == sum) {
                    k++;
                }
            }
        }
        return k;
    }
}

