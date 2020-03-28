package tema4.ATMHw;

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

    public void depositMoney(double amount){
        System.out.println("Succesfully deposit " + amount);
        bankAccount.setBalance(bankAccount.getBalance()+amount);
    }
    public void withdrawMoney(double amount){

        if(bankAccount.getBalance()-amount < 0){
            System.out.println("Insufcient funds, try again");
        } else {
            System.out.println("Succesfully withdraw " + amount);
            bankAccount.setBalance(bankAccount.getBalance() - amount);
        }
    }
    public void interogateBalance(){
        System.out.println("Balance: " + bankAccount.getBalance());
    }
    public void changePin(int pin){
        System.out.println("Pin succesfully changed");
        setPin(pin);
    }


}
