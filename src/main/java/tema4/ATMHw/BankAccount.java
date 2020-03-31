package tema4.ATMHw;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString // (call super == true ) - avem acces si la lucrurile din superclasa
public class BankAccount {
    private String iban;
    private List<String> attachedCardNumbers = new ArrayList<String>();
    private BigDecimal balance;


    public BankAccount(String iban, BigDecimal balance) {
        this.iban = iban;
        this.balance = balance;
    }

    public void setAttachedCardNumbers(String attachedCardNumbers) {
        this.attachedCardNumbers.add(attachedCardNumbers);
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }
}
