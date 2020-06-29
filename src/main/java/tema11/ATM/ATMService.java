package tema11.ATM;


import java.io.IOException;
import java.math.BigDecimal;


public class ATMService {

    static BankAccountRepository rep;

    static {
        try {
            rep = new BankAccountRepository();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws IOException {

        Card c1 = rep.bankAccounts.get(0).getCard();
        Card c2 = rep.bankAccounts.get(1).getCard();
        Card c3 = rep.bankAccounts.get(2).getCard();
        ATMService atmService = new ATMService();
        atmService.depositMoney(c1,new BigDecimal(199022));
     //   atmService.withdrawMoney(c2, new BigDecimal(50000));
        atmService.changePin(c3,1001);
        rep.bankAccounts.forEach(bankAccount -> System.out.println(bankAccount));

    }
    
   public BigDecimal interrogateBalance(Card card){
       return card.getBankAccount().getBalance();
   }
    public void depositMoney(Card card, BigDecimal amount) throws IOException {
        card.getBankAccount().setBalance(card.getBankAccount().getBalance().add(amount));
        rep.rewriteBankAccountsDB(rep.bankAccountDB,rep.bankAccounts);

    }
    public void withdrawMoney(Card card, BigDecimal amount) throws IOException {
        if(card.getBankAccount().getBalance().compareTo(amount) == 1) {
            card.getBankAccount().setBalance(card.getBankAccount().getBalance().subtract(amount));
            rep.rewriteBankAccountsDB(rep.bankAccountDB,rep.bankAccounts);
        } else{
            System.out.println("Insufficient funds, try again.");
        }
    }
    public void changePin(Card card, int pin) throws IOException {
        String pin1 = String.valueOf(pin);
        if(pin1.length() == 4) {
            System.out.println("Pin changed");
            card.setPin(Integer.valueOf(pin1));
            rep.rewriteBankAccountsDB(rep.bankAccountDB,rep.bankAccounts);
        } else {
            System.out.println("Incorrect pin, try again (must be 4 digits)");
        }
    }
    public void printBalance(Card card){
        System.out.println("Balance: " + card.getBankAccount().getBalance());
    }

}
