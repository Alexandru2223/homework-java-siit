package tema1;

import java.util.Scanner;

public class InfiniteCalculator {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Introduceti numerele: ");
            int a = scanner.nextInt();
            int b = scanner.nextInt();
            System.out.println("Introduceti operatia: ");
            String operation = scanner.next();
            if (operation.equals("+")) {
                System.out.println("a+b= " + (a + b));
            } else if (operation.equals("-")) {
                System.out.println("a-b= " + (a - b));
            } else if (operation.equals("*")) {
                System.out.println("a*b= " + (a * b));
            } else if (operation.equals("/")) {
                System.out.println("a/b= " + (a / b));
            } else {
                System.out.println("Bad operation!!");
            }
        }
    }

}
