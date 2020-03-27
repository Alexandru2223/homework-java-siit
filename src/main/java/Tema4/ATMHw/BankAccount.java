package Tema4.ATMHw;

import java.util.ArrayList;
import java.util.List;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class BankAccount {
    private String iban;
    private List<String> attachedCardNumbers = new ArrayList<String>();
    private double balance;


    public BankAccount(String iban, double balance) {
        this.iban = iban;
        this.balance = balance;
    }

    public void setAttachedCardNumbers(String attachedCardNumbers) {
        this.attachedCardNumbers.add(attachedCardNumbers);
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }
}
