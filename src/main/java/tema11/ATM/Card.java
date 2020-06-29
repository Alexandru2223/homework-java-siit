package tema11.ATM;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
@Builder
public class Card {
    BankAccount bankAccount;
    private String cardNumber;
    private String expDate;
    private int pin;
}
