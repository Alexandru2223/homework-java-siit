package Tema3.bank;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@Setter
@Getter
@ToString
public class BankAccounts {
    private String iban;
    private double balance;
    private List<Integer> attachedCardNumbers = new ArrayList<>(Arrays.asList());

    public void addMoney(long amount){
        this.balance = this.balance + amount;
    }
    public void withdrawMoney(long amount){
        this.balance = this.balance - amount;
    }
    public void attachCard(Integer cardNumber){
         attachedCardNumbers.add(cardNumber);
    }
}
