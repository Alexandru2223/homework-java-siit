package tests;
import org.assertj.core.data.Offset;
import org.assertj.core.data.Percentage;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.math.BigDecimal;

import tema5.ATMService;
import tema5.BankAccount;
import tema5.Card;
import tema5.Repository;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;

@RunWith(MockitoJUnitRunner.class)
public class ATMServiceTest {

    @Mock
    private Repository repository;

    private ATMService sut;

    @Test //pt fiecare metoda @Test se creaza o instanta noua de ATMServiceTest
    public void given_card_when_interogate_balance_then_balance_is_returned() {
        //given
        BankAccount b1 = new BankAccount("24443334443334", new BigDecimal(10000));
        Card card = new Card("Alex", "123456", "08/24", 2411, b1);
        BigDecimal balance = new BigDecimal(10000);

        //nu se pot combina Matchers(any, anyString, anyINt) cu valori reale
        //in cazul unor parametri multipli, ori matchers ori valori concrete
//        given(bankDataBase.getBankAccountByCardNumber(anyString())).willReturn(account);
      //  given(bankDataBase.getBankAccountByCardNumber(card.getNumber())).willReturn(account);
      //  given(account.getBalance()).willReturn(balance);
        given(card.getBankAccount().getBalance()).willReturn(balance);

        //When
        BigDecimal returnedBalance = sut.interrogateBalance(card);


        //Then
        assertThat(returnedBalance).isCloseTo(balance, Percentage.withPercentage(0.0000001));
    }

 /*   @Before
    public void setup() {
        sut = new ATMService(repository);
    }*/
}

