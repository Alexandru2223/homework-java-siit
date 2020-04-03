package tema5;

import java.math.BigDecimal;
import java.util.Scanner;

public class ATMService {
    public static void main(String[] args) {
        Repository repository = new Repository();
        ATMService atm = new ATMService();
        Scanner scan = new Scanner(System.in);
        while (true) {
            System.out.println("Enter card number: ");
            String cardNumber = scan.next();
            for (Card card : repository.cards) {
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
                                atm.interrogateBalance(card);
                                atm.printBalance(card);
                            } else if (key.equals("2")) {
                                System.out.println("Enter the amount you want to deposit: ");
                                BigDecimal amount = scan.nextBigDecimal();
                                atm.depositMoney(card,amount);
                            } else if(key.equals("3")){
                                System.out.println("Enter the amount you want to withdraw");
                                BigDecimal amount = scan.nextBigDecimal();
                                atm.withdrawMoney(card,amount);
                            } else if(key.equals("4")){
                                System.out.println("Enter the new pin");
                                int pin1 = scan.nextInt();
                                atm.changePin(card,pin1);
                            } else if(key.equals("x")){
                                break;
                            }
                        }
                    }
                }
            }
        }
    }
    
   public BigDecimal interrogateBalance(Card card){
       return card.getBankAccount().getBalance();
   }
    public void depositMoney(Card card, BigDecimal amount){
        card.getBankAccount().setBalance(card.getBankAccount().getBalance().add(amount));
    }
    public void withdrawMoney(Card card, BigDecimal amount){
        if(card.getBankAccount().getBalance().compareTo(amount) == 1) {
            card.getBankAccount().setBalance(card.getBankAccount().getBalance().subtract(amount));
        } else{
            System.out.println("Insufficient funds, try again.");
        }
    }
    public void changePin(Card card, int pin){
        String pin1 = String.valueOf(pin);
        if(pin1.length() == 4) {
            System.out.println("Pin changed");
            card.setPin(pin);
        } else {
            System.out.println("Incorrect pin, try again (must be 4 digits)");
        }
    }
    public void printBalance(Card card){
        System.out.println("Balance: " + card.getBankAccount().getBalance());
    }
}
