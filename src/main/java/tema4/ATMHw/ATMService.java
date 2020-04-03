package tema4.ATMHw;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ATMService {
    public final static List<Card> cards = new ArrayList<>();

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        BankAccount b1 = new BankAccount("24443334443334", new BigDecimal(543.4));
        addCard(new Card("Alex", "123456", "08/24", 2411, b1));
        addCard(new Card("Alex", "123455", "08/24", 1554, b1));
        BankAccount b2 = new BankAccount("1999044434442332", new BigDecimal(10000));
        addCard(new Card("Andreea", "123323", "10/25", 2312, b2));
        BankAccount b3 = new BankAccount("2003994310013094", new BigDecimal(77466.44));
        addCard(new Card("Daniel", "100001", "12/21", 1234, b3));
        addCard(new Card("Daniel", "100011", "12/21", 1235, b3));
        addCard(new Card("Daniel", "100111", "12/21", 1236, b3));
        while (true) {
            System.out.println("Enter card number: ");
            String cardNumber = scan.next();
            for (Card card : cards) {
                if (card.getCardNumber().equals(cardNumber)) {
                    System.out.println("Enter PIN: ");
                    int pin = scan.nextInt();
                    if (pin == card.getPin()) {
                        boolean key1 = true;
                        while (key1) {
                            System.out.println("Press 1 to see balance");
                            System.out.println("Press 2 to deposit money");
                            System.out.println("Press 3 to withdraw money");
                            System.out.println("Press 4 to change pin");
                            System.out.println("Press x to cancel");
                            String key = scan.next();
                            if (key.equals("1")) {
                                card.interogateBalance();
                            } else if (key.equals("2")) {
                                System.out.println("Enter the amount you want to deposit: ");
                                BigDecimal amount = scan.nextBigDecimal();
                                card.depositMoney(amount);
                            } else if(key.equals("3")){
                                System.out.println("Enter the amount you want to withdraw");
                                BigDecimal amount = scan.nextBigDecimal();
                                card.withdrawMoney(amount);
                            } else if(key.equals("4")){
                                System.out.println("Enter the new pin");
                                int pin1 = scan.nextInt();
                                card.changePin(pin1);
                            } else if(key.equals("x")){
                                break;
                            }
                        }
                    }
                }
            }
        }

    }
    public static void addCard(Card card) {
       cards.add(card);
    }
}
