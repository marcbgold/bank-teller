package bankteller;

public class BankAccount {

	private String accountNum;
	private String type;
	private double balance;

	public BankAccount(String accountNum, String type, double startingBalance) {
		this.accountNum = accountNum;
		this.type = type;
		balance = startingBalance;
	}

	public String getAccountNum() {
		return accountNum;
	}

	public String getType() {
		return type;
	}

	public double getBalance() {
		return balance;
	}

	public void makeDeposit(double amount) {
		balance += amount;
	}

	public boolean makeWithdrawal(double amount) {
		if (amount > balance) {
			return false;
		}
		balance -= amount;
		return true;
	}

	@Override
	public String toString() {
		return (accountNum + ": " + type);
	}

}
