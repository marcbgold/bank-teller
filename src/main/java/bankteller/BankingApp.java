package bankteller;

import java.text.NumberFormat;
import java.util.Locale;
import java.util.Scanner;

public class BankingApp {

	public static void main(String[] args) {

		Scanner input = new Scanner(System.in);
		Locale locale = new Locale("en", "US");
		NumberFormat currencyFormatter = NumberFormat.getCurrencyInstance(locale);

		String choice = "";
		String accountNumInput1 = "";
		String accountNumInput2 = "";
		String typeInput = "";
		double balanceInput;
		double amountInput;

		Bank bank = new Bank();

		do {
			System.out.println();
			System.out.println("StupidBank Main Menu");
			System.out.println();
			if (bank.isEmpty()) {
				System.out.println("You do not currently have any open accounts.");
			} else {
				bank.displayAllAccountNames();
			}
			System.out.println();
			System.out.println("What would you like to do?");
			System.out.println();
			System.out.println("1. Withdraw funds");
			System.out.println("2. Deposit funds");
			System.out.println("3. Transfer funds between accounts");
			System.out.println("4. Check balance");
			System.out.println("5. Open new account");
			System.out.println("6. Close existing account");
			System.out.println("7. Exit");
			choice = input.nextLine().trim();
			System.out.println();

			switch (choice) {
			case "1":
				if (bank.isEmpty()) {
					System.out.println("You do not currently have any open accounts.");
					System.out.println("Press enter to continue.");
					input.nextLine();
					continue;
				}

				System.out.println("Please enter an account number:");
				accountNumInput1 = input.nextLine().trim();
				System.out.println();

				if (!bank.checkIfAccountExists(accountNumInput1)) {
					System.out.println("No account with that number exists.  Please try again.");
					System.out.println("Press enter to continue.");
					input.nextLine();
					continue;
				}

				bank.displayAccountInfo(accountNumInput1);
				System.out.println("Please enter the amount you would like to withdraw.");
				System.out.println("The amount must be a multiple of $20.");
				amountInput = input.nextDouble();
				input.nextLine();
				System.out.println();

				if (amountInput % 20 != 0 || amountInput <= 0) {
					System.out.println("Invalid amount.  Please try again.");
					System.out.println("Press enter to continue.");
					input.nextLine();
					continue;
				}

				if (!bank.makeWithdrawal(accountNumInput1, Double.toString(amountInput))) {
					System.out.println("Insufficient funds, cannot withdraw that amount. Please try again.");
					System.out.println("Press enter to continue.");
					input.nextLine();
				} else {
					System.out.println(currencyFormatter.format(amountInput) + " successfully withdrawn.");
					System.out.println("Press enter to continue.");
					input.nextLine();
				}
				break;
			case "2":
				if (bank.isEmpty()) {
					System.out.println("You do not currently have any open accounts.");
					System.out.println("Press enter to continue.");
					input.nextLine();
					continue;
				}

				System.out.println("Please enter an account number:");
				accountNumInput1 = input.nextLine().trim();
				System.out.println();

				if (!bank.checkIfAccountExists(accountNumInput1)) {
					System.out.println("No account with that number exists.  Please try again.");
					System.out.println("Press enter to continue.");
					input.nextLine();
					continue;
				}

				bank.displayAccountInfo(accountNumInput1);
				System.out.println("Please enter the amount you would like to deposit.");
				amountInput = input.nextDouble();
				input.nextLine();
				System.out.println();

				if (amountInput <= 0) {
					System.out.println("Invalid amount.  Please try again.");
					System.out.println("Press enter to continue.");
					input.nextLine();
					continue;
				}

				bank.makeDeposit(accountNumInput1, Double.toString(amountInput));
				System.out.println(currencyFormatter.format(amountInput) + " successfully deposited.");
				System.out.println("Press enter to continue.");
				input.nextLine();
				break;
			case "3":
				if (bank.getNumberOfOpenAccounts() < 2) {
					System.out.println("You do not currently have at least two open accounts.");
					System.out.println("Press enter to continue.");
					input.nextLine();
					continue;
				}

				System.out.println("Please enter the account number of the account from which you would like to transfer money:");
				accountNumInput1 = input.nextLine().trim();
				System.out.println();

				if (!bank.checkIfAccountExists(accountNumInput1)) {
					System.out.println("No account with that number exists.  Please try again.");
					System.out.println("Press enter to continue.");
					input.nextLine();
					continue;
				}

				System.out.println("Please enter the account number of the account into which you would like to transfer money:");
				accountNumInput2 = input.nextLine().trim();
				System.out.println();

				if (!bank.checkIfAccountExists(accountNumInput2)) {
					System.out.println("No account with that number exists.  Please try again.");
					System.out.println("Press enter to continue.");
					input.nextLine();
					continue;
				}

				bank.displayAccountInfo(accountNumInput1);
				bank.displayAccountInfo(accountNumInput2);
				System.out.println();
				System.out.println("Please enter the amount you would like to transfer.");
				amountInput = input.nextDouble();
				input.nextLine();
				System.out.println();

				if (amountInput <= 0) {
					System.out.println("Invalid amount.  Please try again.");
					System.out.println("Press enter to continue.");
					input.nextLine();
					continue;
				}

				if (!bank.makeWithdrawal(accountNumInput1, Double.toString(amountInput))) {
					System.out.println("Insufficient funds, cannot withdraw that amount. Please try again.");
					System.out.println("Press enter to continue.");
					input.nextLine();
				} else {
					bank.makeDeposit(accountNumInput2, Double.toString(amountInput));
					System.out.print(currencyFormatter.format(amountInput) + " successfully transferred from account #" + accountNumInput1);
					System.out.println(" to account #" + accountNumInput2 + ".");
					System.out.println("Press enter to continue.");
					input.nextLine();
				}
				break;
			case "4":
				if (bank.isEmpty()) {
					System.out.println("You do not currently have any open accounts.");
					System.out.println("Press enter to continue.");
					input.nextLine();
					continue;
				}

				System.out.println("Please enter an account number:");
				accountNumInput1 = input.nextLine().trim();
				System.out.println();

				if (!bank.checkIfAccountExists(accountNumInput1)) {
					System.out.println("No account with that number exists.  Please try again.");
					System.out.println("Press enter to continue.");
					input.nextLine();
					continue;
				}

				bank.displayAccountInfo(accountNumInput1);
				System.out.println();
				System.out.println("Press enter to continue.");
				input.nextLine();
				break;
			case "5":
				System.out.println("Please enter an account number for the new account:");
				accountNumInput1 = input.nextLine().trim();
				System.out.println();

				if (accountNumInput1.equals("")) {
					System.out.println("Invalid account number.  Please try again.");
					System.out.println("Press enter to continue.");
					input.nextLine();
					continue;
				} else if (bank.checkIfAccountExists(accountNumInput1)) {
					System.out.println("You already have an account with that number.  Please choose a different number.");
					System.out.println("Press enter to continue.");
					input.nextLine();
					continue;
				}

				System.out.println();
				System.out.println("Please enter 1 for checking or 2 for savings:");
				choice = input.nextLine();
				System.out.println();

				if (choice.equals("1")) {
					typeInput = "Checking";
				} else if (choice.equals("2")) {
					typeInput = "Savings";
				} else {
					System.out.println("Invalid entry.  Please try again.");
					System.out.println("Press enter to continue.");
					input.nextLine();
					continue;
				}

				System.out.println();
				System.out.println("Please enter the starting balance of the account:");
				balanceInput = input.nextDouble();
				choice = input.nextLine();
				System.out.println();

				if (balanceInput <= 0) {
					System.out.println("Invalid balance amount.  Please try again.");
					System.out.println("Press enter to continue.");
					input.nextLine();
					continue;
				}

				bank.createAccount(accountNumInput1, typeInput, Double.toString(balanceInput));
				break;
			case "6":
				if (bank.isEmpty()) {
					System.out.println("You do not currently have any open accounts.");
					System.out.println("Press enter to continue.");
					input.nextLine();
					continue;
				}

				System.out.println("Please enter the account number of the account you wish to close:");
				accountNumInput1 = input.nextLine().trim();
				System.out.println();

				if (!bank.checkIfAccountExists(accountNumInput1)) {
					System.out.println("No account with that number exists.  Please try again.");
					System.out.println("Press enter to continue.");
					input.nextLine();
					continue;
				}

				System.out.println("Are you sure you wish to close this account? (y/n)");
				choice = input.nextLine();

				if (choice.toLowerCase().equals("y")) {
					bank.closeAccount(accountNumInput1);
					System.out.println();
					System.out.println("Account #" + accountNumInput1 + " has been successfully closed.");
					System.out.println("Press enter to continue.");
					input.nextLine();
				} else if (choice.toLowerCase().equals("n")) {
					continue;
				} else {
					System.out.println("Invalid entry.  Please try again.");
					System.out.println("Press enter to continue.");
					input.nextLine();
					continue;
				}
				break;
			case "7":
				break;
			default:
				continue;
			}

		} while (!choice.equals("7"));

		System.out.println("Thank you for banking with StupidBank.  Goodbye.");

		input.close();

	}

}
