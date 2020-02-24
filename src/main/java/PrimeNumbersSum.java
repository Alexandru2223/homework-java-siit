public class PrimeNumbersSum {
    public static void main(String args[]) {
        int n = 10;
        int k = 0;
        int sum = 0;
        for (int i = 1; i < n; i++) {
            boolean prime = true;
            for (int j = 2; j <= (i + 1) / 2; j++)
                if (i % j == 0) {
                    prime = false;
                    break;
                }
            if (prime) {
                // System.out.println(i);
                k++;
                sum = sum + i;
            }
            if (k < 100)
                n++;
        }
        System.out.println("sum = " + sum);
    }
}
