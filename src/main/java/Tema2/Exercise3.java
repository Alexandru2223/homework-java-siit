package Tema2;

import java.util.*;

public class Exercise3 {
    public static void main(String[] args) {
        System.out.println("Enter a sentence: ");
        Scanner scan = new Scanner(System.in);
        String s = scan.nextLine();
        s = s.replaceAll("\\s+", "");
        char[] array = s.toCharArray();
        System.out.println("The repeating elements are: " + findDuplicate(array));

    }

    private static Set findDuplicate(char[] c) {
        Arrays.sort(c);
        Set<Character> set = new HashSet<>();
        for (int i = 0; i < c.length - 1; i++) {
            if (c[i] == c[i + 1]) {
                set.add(c[i]);
            }
        }

        return set;
    }
}