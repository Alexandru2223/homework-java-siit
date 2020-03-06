package Tema2;

public class ArraySquare {
    public static void main(String[] args) {
        int[][] array = {
                {4, 4, 3},
                {5, 7, 4},
                {7, 8, 9}
        };
        System.out.println(isSquare(array));
    }

    public static boolean isSquare(int[][] array) {
        int k = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i].length == array.length) {
                k++;
            }
        }
        if (k == array.length) {
            return true;
        } else {
            return false;
        }
    }


}
