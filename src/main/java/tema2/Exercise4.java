package tema2;

import java.util.Arrays;
import java.util.Scanner;

public class Exercise4 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int[][] a = new int[n][n];
        int[][] b = new int[n][n];
        System.out.println("a: ");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                a[i][j] = scan.nextInt();
            }
        }
        System.out.println("b: ");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                b[i][j] = scan.nextInt();
            }
        }
        //   System.out.println(a.length);
        System.out.println(Arrays.deepToString(makeMupltiplication(a, b)));
    }

    private static int[][] makeMupltiplication(int[][] x, int[][] y) {
        int[][] c = {
                {0, 0, 0},
                {0, 0, 0},
                {0, 0, 0}
        };
        for (int i = 0; i < x.length; ++i)
            for (int j = 0; j < y.length; ++j)
                for (int k = 0; k < x.length; ++k) {
                    c[i][j] += x[i][k] * y[k][j];
                }
        return c;

    }
}
