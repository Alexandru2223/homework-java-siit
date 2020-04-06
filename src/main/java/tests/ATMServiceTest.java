package tests;

import org.assertj.core.data.Offset;
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
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class ATMServiceTest {

    private ATMService atmService;

    @Mock
    private ATMService test;

    @Test
    public void given_card_when_change_pin_then_pin_is_returned() {
        Repository rep = mock(Repository.class);
        BankAccount b1 = new BankAccount("24443443344553", new BigDecimal(10000));
        Card card = new Card("Alex", "123456", "08/24", 2411, b1);
        int pin = 5555;
        atmService.changePin(card, pin);
        when(rep.returnPin(card)).thenReturn(5555);
        assertThat(rep.returnPin(card)).isEqualTo(pin);
    }

    @Test
    public void given_card_when_deposit_money_then_balance_is_returned() {
        BankAccount b1 = new BankAccount("24443443344553", new BigDecimal(10000));
        Card card = new Card("Alex", "123456", "08/24", 2411, b1);
        BigDecimal money = new BigDecimal(405.50);
        BigDecimal balance = new BigDecimal(10405.5);
        atmService.depositMoney(card, money);
        when(test.interrogateBalance(card)).thenReturn(card.getBankAccount().getBalance());
        assertThat(test.interrogateBalance(card)).isCloseTo(balance, Offset.strictOffset(BigDecimal.valueOf(0.00001)));
    }

    @Test
    public void given_card_when_interogate_balance_then_balance_is_returned() {
        //given
        BankAccount b1 = new BankAccount("24443443344553", new BigDecimal(10001));
        Card card = new Card("Alex", "123456", "08/24", 2411, b1);
        ATMService test = mock(ATMService.class);
        BigDecimal balance = new BigDecimal(10001);

        //When
        when(test.interrogateBalance(card)).thenReturn(card.getBankAccount().getBalance());

        //Then
        assertThat(test.interrogateBalance(card)).isCloseTo(balance, Offset.strictOffset(BigDecimal.valueOf(0.00001)));
    }

    @Test
    public void given_card_when_withdraw_money_then_balance_is_returned() {
        BankAccount b1 = new BankAccount("24443443344553", new BigDecimal(10000));
        Card card = new Card("Alex", "123456", "08/24", 2411, b1);
        BigDecimal money = new BigDecimal(405.50);
        BigDecimal balance = new BigDecimal(9594.5);
        atmService.withdrawMoney(card, money);
        when(test.interrogateBalance(card)).thenReturn(card.getBankAccount().getBalance());
        assertThat(test.interrogateBalance(card)).isCloseTo(balance, Offset.strictOffset(BigDecimal.valueOf(0.00001)));
    }

    @Before
    public void setup() {
        atmService = new ATMService();
    }
}

