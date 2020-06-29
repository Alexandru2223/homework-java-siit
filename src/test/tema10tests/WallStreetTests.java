package tema10tests;

import org.junit.Test;

import java.util.List;
import java.util.Set;

import tema10.wallstreet.Trader;
import tema10.wallstreet.Transaction;
import tema10.wallstreet.WallStreetService;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;
public class WallStreetTests {

    @Test
    public void given_year_then_return_sorted_transaction_from_that_year(){
        int input = 2011;
        Trader brian = new Trader("Brian", "Cambridge");
        Trader raoul = new Trader("Raoul", "Cambridge");

        List<Transaction> transactions = List.of( new Transaction(brian, 2011, 300),new Transaction(raoul, 2011, 400));
        List<Transaction> result = WallStreetService.findSortedTransactionsFromYear(input);
        assertThat(result,equalTo(transactions));
    }

    @Test
    public void computes_min_value_to_all_transactions(){
        int min = 300;
        int result = WallStreetService.minValueOfAllTransactions();
        assertThat(result,equalTo(min));
    }
    @Test
    public void computes_max_value_to_all_transactions(){
        int min = 1000;
        int result = WallStreetService.maxValueOfAllTransactions();
        assertThat(result,equalTo(min));

    }

    @Test
    public void find_all_cities_of_traders(){
        Set<String> cities  = Set.of("Cambridge", "Milan");
        Set<String> uniqueCitiesOfTraders = WallStreetService.findUniqueCitiesOfTraders();
        assertThat(uniqueCitiesOfTraders,is(equalTo(cities)));

    }
    @Test
    public void check_If_Trader_Based_In_Milan_Then_Return_True(){
        boolean trader = WallStreetService.checkIfTradersBasedInMilan();
        assertTrue(trader);
    }

}
