package bankteller;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class BankTest {

	@Test
	public void shouldCreateNewAccount() {
		Bank underTest = new Bank();
		underTest.createAccount("111", "checking", 1000);

		double amount = underTest.getBalance("111");

		assertEquals(1000, amount, 0.001);
	}

	@Test
	public void shouldDepositToAccount() {
		Bank underTest = new Bank();
		underTest.createAccount("111", "checking", 1000);
		underTest.makeDeposit("111", 100);

		double amount = underTest.getBalance("111");

		assertEquals(1100, amount, 0.001);
	}

	@Test
	public void shouldWithdrawFromAccount() {
		Bank underTest = new Bank();
		underTest.createAccount("111", "checking", 1000);
		underTest.makeWithdrawal("111", 100);

		double amount = underTest.getBalance("111");

		assertEquals(900, amount, 0.001);
	}

	@Test
	public void shouldCloseAccount() {
		Bank underTest = new Bank();
		underTest.createAccount("111", "checking", 1000);
		underTest.closeAccount("111");

		assertEquals(false, underTest.checkIfAccountExists("111"));
	}

}
