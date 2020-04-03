package tema4.Strings;


import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Vector;

public class StringManipulation {

    public static boolean checkAnagrams(String s1, String s2) {
        if (s1 == null || s2 == null || s1 == "" || s2 == "")
            return false;
        char[] s = s1.toCharArray();
        char[] s0 = s2.toCharArray();
        Arrays.sort(s);
        Arrays.sort(s0);
        if (Arrays.equals(s, s0)) {
            return true;
        } else {
            return false;
        }
    }

    public static String checkDigits(String s) {
        if (s == "" || s == null) {
            return "String is empty / null";
        }
        char[] c = s.toCharArray();
        int cont = 0;
        for (int i = 0; i < c.length; i++) {
            if (c[i] == '0' || c[i] == '1' || c[i] == '2' || c[i] == '3' || c[i] == '4' || c[i] == '5' || c[i] == '6' || c[i] == '7' || c[i] == '8' ||
                    c[i] == '9') {
                cont++;
            }
        }
        System.out.println(cont);
        if (cont == c.length) {
            return "String contains only digits";
        } else {
            return "String contains characters";
        }

    }

    public static void checkPalindrom(String s) {
        char[] s1 = s.toCharArray();
        String reverse = "";
        for (int i = 0; i < s1.length; i++) {
            reverse = s1[i] + reverse;
        }
        if (reverse.equals(s)) {
            System.out.println("Palindrom");
        } else {
            System.out.println("Nu este palindrom");
        }
    }

    public static int convertToInt(String s) {
        if (s == "" || s == null) {
            return 0;
        } else {
            return Integer.valueOf(s.replaceAll("\\s+", ""));
        }
    }

    public static int countOccurence(String s, char c) {
        if (s == null || s.isEmpty()) {
            return 0;
        }
        char[] c1 = s.toCharArray();
        int k = 0;
        for (int i = 0; i < c1.length; i++) {
            if (c1[i] == c) {
                k++;
            }
        }
        return k;
    }

    public static Vector countVowelsAndConsonants(String s) {
        Vector v = new Vector();
        if (s == null) {
            v.add(0);
            v.add(0);
            return v;
        }
        char[] c = s.toCharArray();

        int vowels = 0;
        int consonants = 0;
        for (int i = 0; i < c.length; i++) {
            if (c[i] == 'a' || c[i] == 'e' || c[i] == 'i' || c[i] == 'o') {
                vowels++;
            } else if (c[i] != '0' && c[i] != '1' && c[i] != '2' && c[i] != '3' && c[i] != '4' && c[i] != '5' && c[i] != '6' && c[i] != '7' && c[i] != '8' &&
                    c[i] != '9') {
                consonants++;
            }
        }
        v.add(vowels);
        v.add(consonants);
        return v;
    }

    public static Vector findLongestSubstring(String s) {
        String[] s1 = s.split("\\s");
        Arrays.sort(s1, Comparator.comparingInt(String::length).reversed());
        Vector v = new Vector();
        int cont = 0;
        for (int i = 0; i < s1.length; i++) {
            char[] c = s1[i].toCharArray();
            for (int j = 0; j < c.length; j++) {
                for (int k = j + 1; k < c.length; k++) {
                    if (c[j] == c[k]) {
                        cont++;
                        break;

                    }
                }
            }
            if (cont == 0) {
                v.add(s1[i]);
                cont = 0;
            }
        }

        return v;
    }

    public static String inverseWords(String s) {
        if(s == null){
            return null;
        }
        String[] s1 = s.split("\\s");
        String reverse = "";
        for (int i = 0; i < s1.length; i++) {
            if (i == s1.length - 1)
                reverse = s1[i] + reverse;
            else
                reverse = " " + s1[i] + reverse;
        }
        return reverse;
    }

    public static Vector printDuplicates(String s) {
        char[] s1 = s.toCharArray();
        Vector v = new Vector();
        for (int i = 0; i < s1.length - 1; i++) {
            for (int j = i + 1; j < s1.length; j++) {
                if (s1[i] == s1[j]) {
                    v.add(s1[j]);
                    break;
                }
            }
        }
        return v;
    }

    public static Vector printFirstNonRepeatedChar(String s) {
        char[] c = s.toCharArray();
        int[] v = new int[c.length];
        Vector v1 = new Vector();
        for (int i = 0; i < c.length; i++) {
            for (int j = 0; j < c.length; j++) {
                if (c[i] == c[j]) {
                    v[i] = v[i] + 1;
                }
            }
        }
        for (int i = 0; i < v.length; i++) {
            if (v[i] == 1) {
                v1.add(c[i]);
                break;
            }
        }
        return v1;

    }

    public static String printMostFrequentString(String s) {
        if(s == null){
            return null;
        }
        String[] s1 = s.split("\\s");
        int[] v = new int[s1.length];
        Vector v1 = new Vector();
        for (int i = 0; i < s1.length; i++) {
            for (int j = i + 1; j < s1.length; j++) {
                if (s1[i].equals(s1[j])) {
                    v[i]++;
                }
            }
        }
        for (int i = 0; i < v.length; i++) {
            v1.add(v[i]);
        }
        String frequent = "";
        Object object = Collections.max(v1);
        for (int i = 0; i < s1.length; i++) {
            if (v[i] == (int) object) {
                frequent += s1[i];
            }
        }

        return frequent;
    }

    public static String removeChar(String s, char c) {
        char[] s1 = s.toCharArray();
        String s2 = "";
        for (int i = 0; i < s1.length; i++) {
            if (s1[i] != c) {
                s2 += s1[i];
            }
        }
        return s2;
    }

    public static String reverseString(String s) {
        if (s == null) {
            return null;
        }
        char[] s1 = s.toCharArray();
        char[] s2 = new char[s1.length];
        int j = 0;
        for (int i = s1.length - 1; i >= 0; i--) {
            s2[j] = s1[i];
            j++;
        }
        return new String(s2);
    }


}