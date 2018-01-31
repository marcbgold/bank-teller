package bankteller;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Bank {

	Scanner input = new Scanner(System.in);

	private Map<String, BankAccount> accounts = new HashMap<String, BankAccount>();

	public void createAccount(String accountNum, String name, double startingBalance) {
		accounts.put(accountNum, new BankAccount(accountNum, name, startingBalance));
	}

	public boolean checkIfAccountExists(String accountNum) {
		return accounts.containsKey(accountNum);
	}

	public Collection<BankAccount> showAllAccounts() {
		return accounts.values();
	}

	public double getBalance(String accountNum) {
		return accounts.get(accountNum).getBalance();
	}

	public void makeDeposit(String accountNum, double amount) {
		accounts.get(accountNum).makeDeposit(amount);
	}

	public void makeWithdrawal(String accountNum, double amount) {
		if (!accounts.get(accountNum).makeWithdrawal(amount)) {
			System.out.println("Insufficient funds, cannot withdraw that amount.");
		}
	}

	public void closeAccount(String accountNum) {
		accounts.remove(accountNum);
	}

}
