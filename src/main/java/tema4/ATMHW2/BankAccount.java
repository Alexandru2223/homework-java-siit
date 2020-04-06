package tema4.ATMHW2;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class BankAccount {
    private String iban;
    private List<String> attachedCardNumbers = new ArrayList<String>();
    private BigDecimal balance;

    public BankAccount(String iban, BigDecimal balance) {
        this.iban = iban;
        this.balance = balance;
    }

    public BigDecimal getBalance() {
        return balance.setScale(2,BigDecimal.ROUND_HALF_EVEN);
    }

    public void setAttachedCardNumbers(String attachedCardNumbers) {
        this.attachedCardNumbers.add(attachedCardNumbers);
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }
}
