package bankteller;

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

	public void createAccount(String accountNum, String name, double startingBalance) {
		accounts.put(accountNum, new BankAccount(accountNum, name, startingBalance));
	}

	public boolean isEmpty() {
		return accounts.isEmpty();
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

	public double getBalance(String accountNum) {
		return accounts.get(accountNum).getBalance();
	}

	public void makeDeposit(String accountNum, double amount) {
		accounts.get(accountNum).makeDeposit(amount);
		System.out.println(currencyFormatter.format(amount) + " successfully deposited.");
		System.out.println("Press enter to continue.");
		input.nextLine();
	}

	public void makeWithdrawal(String accountNum, double amount) {
		if (!accounts.get(accountNum).makeWithdrawal(amount)) {
			System.out.println("Insufficient funds, cannot withdraw that amount.  Please try again.");
			System.out.println("Press enter to continue.");
			input.nextLine();
		} else {
			System.out.println(currencyFormatter.format(amount) + " successfully withdrawn.");
			System.out.println("Press enter to continue.");
			input.nextLine();
		}
	}

	public void closeAccount(String accountNum) {
		accounts.remove(accountNum);
	}

}
