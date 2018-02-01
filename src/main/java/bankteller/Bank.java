package bankteller;

import java.math.BigDecimal;
import java.text.NumberFormat;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Scanner;

public class Bank {

	Scanner input = new Scanner(System.in);
	Locale locale = new Locale("en", "US");
	NumberFormat currencyFormatter = NumberFormat.getCurrencyInstance(locale);

	private Map<String, BankAccount> accounts = new HashMap<String, BankAccount>();

	public void createAccount(String accountNum, String name, String startingBalance) {
		accounts.put(accountNum, new BankAccount(accountNum, name, startingBalance));
	}

	public boolean isEmpty() {
		return accounts.isEmpty();
	}

	public int getNumberOfOpenAccounts() {
		return accounts.size();
	}

	public void displayAccountInfo(String accountNum) {
		System.out.println("Current account info");
		System.out.println("-----");
		System.out.println("Account #" + accounts.get(accountNum).getAccountNum());
		System.out.println("Type: " + accounts.get(accountNum).getType());
		System.out.println("Balance: " + currencyFormatter.format(accounts.get(accountNum).getBalance()));
	}

	public void displayAllAccountNames() {
		System.out.println("Current accounts:");
		System.out.println();
		for (BankAccount i : accounts.values()) {
			System.out.println(i);
		}
	}

	public boolean checkIfAccountExists(String accountNum) {
		return accounts.containsKey(accountNum);
	}

	public BigDecimal getBalance(String accountNum) {
		return accounts.get(accountNum).getBalance();
	}

	public void makeDeposit(String accountNum, String amount) {
		accounts.get(accountNum).makeDeposit(amount);
	}

	public boolean makeWithdrawal(String accountNum, String amount) {
		if (!accounts.get(accountNum).makeWithdrawal(amount)) {
			return false;
		} else {
			return true;
		}
	}

	public void closeAccount(String accountNum) {
		accounts.remove(accountNum);
	}

}
