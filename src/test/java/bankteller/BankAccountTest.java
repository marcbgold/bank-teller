package bankteller;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.math.BigDecimal;

import org.junit.Before;
import org.junit.Test;

public class BankAccountTest {

	private static final String ACCOUNT_NUM = "111";
	private static final String TYPE = "checking";
	private static final String BALANCE = "1000.00";
	private static final String SMALL_AMOUNT = "100.00";
	private BankAccount underTest;

	@Before
	public void setup() {
		underTest = new BankAccount(ACCOUNT_NUM, TYPE, BALANCE);
	}

	@Test
	public void shouldDepositToAccount() {
		underTest.makeDeposit(SMALL_AMOUNT);

		BigDecimal amount = underTest.getBalance();

		assertThat(amount, is(new BigDecimal("1100.00")));
	}

	@Test
	public void shouldWithdrawFromAccount() {
		underTest.makeWithdrawal(SMALL_AMOUNT);

		BigDecimal amount = underTest.getBalance();

		assertThat(amount, is(new BigDecimal("900.00")));
	}

	@Test
	public void shouldNotOverdrawAccount() {
		assertThat(underTest.makeWithdrawal("2000.00"), is(false));
	}

}
