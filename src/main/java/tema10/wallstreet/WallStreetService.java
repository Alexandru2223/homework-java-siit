package tema10.wallstreet;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toList;

public class WallStreetService {

    static Trader raoul = new Trader("Raoul", "Cambridge");

    static Trader mario = new Trader("Mario", "Milan");

    static Trader alan = new Trader("Alan", "Cambridge");

    static Trader brian = new Trader("Brian", "Cambridge");

    static List<Transaction> transactions = Arrays.asList(
            new Transaction(brian, 2011, 300),
            new Transaction(raoul, 2012, 1000),
            new Transaction(raoul, 2011, 400),
            new Transaction(mario, 2012, 710),
            new Transaction(mario, 2012, 700),
            new Transaction(alan, 2012, 950)
    );

    public static void main(String... args) {
   //     findSortedTransactionsFromYear(2012).forEach(System.out::println);
      //  findAllTradersFromCambridge().forEach(transaction -> System.out.println(transaction));
        //System.out.println(getNameOfAllTraders());
    //    System.out.println(checkIfTradersBasedInMilan());
       // printAllTransactionValuesFromCambridge().forEach(transaction -> System.out.println(transaction));
       // System.out.println(maxValueOfAllTransactions());
   //     System.out.println(minValueOfAllTransactions());

    }
    /*
    1. Find all transactions in the year 2011 and sort them by value (small to high).
    2. What are all the unique cities where the traders work?
    3. Find all traders from Cambridge and sort them by name.
    4. Return a string of all traders’ names sorted alphabetically.
    5. Are any traders based in Milan?
    6. Print all transactions’ values from the traders living in Cambridge.
    7. What’s the highest value of all the transactions?
    8. Find the transaction with the smallest value.
     */

    public static List<Transaction> findSortedTransactionsFromYear(int year) {
        return transactions.stream()
                           .filter(transaction -> transaction.getYear() == year)
//                           .sorted((t1, t2) -> t1.getValue() - t2.getValue())
                           .sorted(Comparator.comparingInt(Transaction::getValue))
//                           .collect(Collectors.toCollection(ArrayList::new));
                           .collect(toList());
    }
   public static Integer minValueOfAllTransactions(){
        return transactions.stream()
                           .map(transaction -> transaction.getValue()).min(Comparator.naturalOrder())
                           .get();
    }
   public static Integer maxValueOfAllTransactions(){
        return transactions.stream()
                           .map(transaction -> transaction.getValue()).max(Comparator.naturalOrder())
                           .get();
    }
   public static boolean checkIfTradersBasedInMilan(){
        return transactions.stream()
                .anyMatch(transaction -> transaction.getTrader().getCity().equals("Milan"));
    }

   public static List<Integer> printAllTransactionValuesFromCambridge(){
        return transactions.stream()
                .filter(transaction -> transaction.getTrader().getCity().equals("Cambridge"))
                .map(transaction -> transaction.getValue())
                .collect(Collectors.toList());
    }
   public static String getNameOfAllTraders(){
        return transactions.stream()
                .map(x -> x.getTrader().getName())
                           .distinct()
                .collect(Collectors.joining(", "));
    }

   public static List<Transaction> findAllTradersFromCambridge(){
        return transactions.stream()
                .filter(city -> city.getTrader().getCity().equals("Cambridge"))
                .sorted(Comparator.comparing(x-> x.getTrader().getName()))
                .collect(Collectors.toList());
    }

   public static Set<String> findUniqueCitiesOfTraders() {
        return transactions.stream() //Transaction
//                           .map(transaction -> transaction.getTrader().getCity())

//                          .map(transaction -> transaction.getTrader())
                           .map(Transaction::getTrader) //String::isEmpty

//                           .map(trader -> trader.getCity()) //String==city apply(Trader t)
                           .map(Trader::getCity) //String==city apply(Trader t)

                           .collect(Collectors.toSet());
    }
}
