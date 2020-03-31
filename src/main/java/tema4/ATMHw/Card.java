package tema4.ATMHw;

import java.math.BigDecimal;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Card  {
    private String ownerName;
    private String cardNumber;
    private String expDate;
    private int pin;
    private BankAccount bankAccount;

    public Card(String ownerName, String number, String expDate, int pin, BankAccount bankAccount){
        this.ownerName = ownerName;
        this.cardNumber = number;
        this.expDate = expDate;
        this.pin = pin;
        this.bankAccount = bankAccount;
        bankAccount.setAttachedCardNumbers(this.cardNumber);
    }
   /* public void setNumber(String number) {
        this.number = number;
        bankAccount.setAttachedCardNumbers(number);
    }*/

    public void depositMoney(BigDecimal amount){
        System.out.println("Succesfully deposit " + amount);
        bankAccount.setBalance(amount.add(bankAccount.getBalance()));
    }
    public void withdrawMoney(BigDecimal amount){

        if(bankAccount.getBalance().subtract(amount).compareTo(new BigDecimal(0)) == -1){
            System.out.println("Insufcient funds, try again");
        } else {
            System.out.println("Succesfully withdraw " + amount);
            bankAccount.setBalance(bankAccount.getBalance().subtract(amount));
        }
    }
    public void interogateBalance(){
        System.out.println("Balance: " + bankAccount.getBalance().setScale(2,BigDecimal.ROUND_HALF_EVEN));
    }
    public void changePin(int pin){
        System.out.println("Pin succesfully changed");
        setPin(pin);
    }


}
