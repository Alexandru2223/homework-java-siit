package Tema3.bank;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class Test {

    public static void main(String[] args) {
        User u = new User();
        Card c1 = new Card("24/11", "Alex", 123456);
        Card c2 = new Card("10/04", "Alex", 123455);
        u.addCard(c1);
        u.addCard(c2);
      //  BankAccounts b = new BankAccounts();
         BankAccounts b = new BankAccounts("322242",5433.3, List.of(2323,323));
        u.addBankAccount(b);
        for (Card card : User.cards) {
            System.out.println("card.toString() = " + card.toString());
        }
        for (BankAccounts bankAccount : User.bankAccounts) {
            System.out.println("bankAccount.toString() = " + bankAccount.toString());
        }
        //   System.out.println("User.bankAccounts.get(0).getAttachedCardNumbers().get(1) = " + User.bankAccounts.get(0).getAttachedCardNumbers());

        b.addMoney(443);
        b.withdrawMoney(122232);
        b.attachCard(232322);
        System.out.println("b.getAttachedCardNumbers() = " + b.getAttachedCardNumbers());
        System.out.println(User.bankAccounts);
        
    }
public static List<Integer>  add(List<Integer> integers){
    return integers;
}



}
