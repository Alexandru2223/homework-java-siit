package Tema3.bank;

import java.util.ArrayList;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.ToString;

@ToString
@AllArgsConstructor
public class User {
    public final static List<BankAccounts> bankAccounts = new ArrayList<>();
    public final static List<Card> cards = new ArrayList<>();


    public void addCard(Card card) {
        cards.add(card);
    }

    public void addBankAccount(BankAccounts bankAccount) {
        bankAccounts.add(bankAccount);
    }

}
