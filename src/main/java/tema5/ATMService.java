package tema5;

import java.math.BigDecimal;
import java.util.Scanner;

public class ATMService {

    private Repository rep;
    
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
