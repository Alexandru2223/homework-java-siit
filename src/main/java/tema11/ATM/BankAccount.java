package tema11.ATM;

import java.math.BigDecimal;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@ToString
@Builder
@Setter
public class BankAccount {
    private String iban;
    private BigDecimal balance;


    public BigDecimal getBalance() {
        return balance.setScale(2,BigDecimal.ROUND_HALF_EVEN);
    }


    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }
}
