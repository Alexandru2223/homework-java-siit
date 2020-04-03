package tema5;

import java.math.BigDecimal;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class Card {
    private String ownerName;
    private String cardNumber;
    private String expDate;
    private int pin;
    private BankAccount bankAccount;

    public Card(String ownerName, String number, String expDate, int pin, tema5.BankAccount bankAccount){
        this.ownerName = ownerName;
        this.cardNumber = number;
        this.expDate = expDate;
        this.pin = pin;
        this.bankAccount = bankAccount;
        bankAccount.setAttachedCardNumbers(this.cardNumber);
    }
}
