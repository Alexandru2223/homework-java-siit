package tema4.ATMHW2;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;


public class Repository {
    public final static List<Card> cards = new ArrayList<>();
    public Repository(){
        BankAccount b1 = new BankAccount("24443334443334", new BigDecimal(543.4));
        cards.add(new Card("Alex", "123456", "08/24", 2411, b1));
        cards.add(new Card("Alex", "123455", "08/24", 1554, b1));
        BankAccount b2 = new BankAccount("1999044434442332", new BigDecimal(10000));
        cards.add(new Card("Andreea", "123323", "10/25", 2312, b2));
        BankAccount b3 = new BankAccount("2003994310013094", new BigDecimal(77466.44));
        cards.add(new Card("Daniel", "100001", "12/21", 1234, b3));
        cards.add(new Card("Daniel", "100011", "12/21", 1235, b3));
        cards.add(new Card("Daniel", "100111", "12/21", 1236, b3));
    }
}
