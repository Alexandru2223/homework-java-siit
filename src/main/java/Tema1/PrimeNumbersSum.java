package Tema1;

public class PrimeNumbersSum {
    public static void main(String[] args) {
        int n = 10;
        int k = 0;
        int s = 0;
        for (int i = 2; i <= n; i++) {
            boolean prime = true;
            for (int j = 2; j <= i / 2; j++) {
                if (i % j == 0) {
                    prime = false;
                    break;
                }
            }
            if (prime) {
                //  System.out.println(i);
                s = s + i;
                k++;
            }
            if (k > 100) {
                break;
            } else {
                n++;
            }
        }
        System.out.println(s);
    }
}
