package bankteller;

import java.math.BigDecimal;

public class BankAccount {

	private String accountNum;
	private String type;
	private BigDecimal balance;

	public BankAccount(String accountNum, String type, String startingBalance) {
		this.accountNum = accountNum;
		this.type = type;
		balance = new BigDecimal(startingBalance);
	}

	public BankAccount(String accountNum, String type, double startingBalance) {
		this(accountNum, type, ("" + startingBalance));
	}

	public String getAccountNum() {
		return accountNum;
	}

	public String getType() {
		return type;
	}

	public BigDecimal getBalance() {
		return balance;
	}

	public void makeDeposit(String amount) {
		balance = balance.add(new BigDecimal(amount));
	}

	public boolean makeWithdrawal(String amount) {
		if (new BigDecimal(amount).compareTo(balance) == 1) {
			return false;
		}
		balance = balance.subtract(new BigDecimal(amount));
		return true;
	}

	@Override
	public String toString() {
		return ("#" + accountNum + ": " + type);
	}

}
