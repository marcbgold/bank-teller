package bankteller;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.math.BigDecimal;

import org.junit.Before;
import org.junit.Test;

public class BankTest {

	static final String ACCOUNT_NUM = "111";
	static final String TYPE = "checking";
	static final String BALANCE = "1000.00";
	static final String SMALL_AMOUNT = "100.00";
	private Bank underTest;

	@Before
	public void setup() {
		underTest = new Bank();
		underTest.createAccount(ACCOUNT_NUM, TYPE, BALANCE);
	}

	@Test
	public void shouldCreateNewAccount() {
		BigDecimal amount = underTest.getBalance(ACCOUNT_NUM);

		assertThat(amount, is(new BigDecimal(BALANCE)));
	}

	@Test
	public void shouldDepositToAccount() {
		underTest.makeDeposit(ACCOUNT_NUM, SMALL_AMOUNT);

		BigDecimal amount = underTest.getBalance(ACCOUNT_NUM);

		assertThat(amount, is(new BigDecimal("1100.00")));
	}

	@Test
	public void shouldWithdrawFromAccount() {
		underTest.makeWithdrawal(ACCOUNT_NUM, SMALL_AMOUNT);

		BigDecimal amount = underTest.getBalance(ACCOUNT_NUM);

		assertThat(amount, is(new BigDecimal("900.00")));

	}

	@Test
	public void shouldCloseAccount() {
		underTest.closeAccount(ACCOUNT_NUM);

		assertThat(underTest.checkIfAccountExists(ACCOUNT_NUM), is(false));
	}

}
