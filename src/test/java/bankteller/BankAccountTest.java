package bankteller;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class BankAccountTest {

	@Test
	public void shouldDepositToAccount() {
		BankAccount underTest = new BankAccount("111", "checking", 1000);
		underTest.makeDeposit(100);

		double amount = underTest.getBalance();

		assertEquals(1100, amount, 0.001);
	}

	@Test
	public void shouldWithdrawFromAccount() {
		BankAccount underTest = new BankAccount("111", "checking", 1000);
		underTest.makeWithdrawal(100);

		double amount = underTest.getBalance();

		assertEquals(900, amount, 0.001);
	}

	@Test
	public void shouldNotOverdrawAccount() {
		BankAccount underTest = new BankAccount("111", "checking", 1000);

		assertEquals(false, underTest.makeWithdrawal(2000));
	}

}
