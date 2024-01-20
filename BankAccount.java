package Codsoft_Project;

import java.util.Scanner;

public class BankAccount {
	private double balance;

	public BankAccount(double intialBalance) {
		this.balance = intialBalance;
	}

	public double getBalance() {
		return balance;
	}

	public void deposit(double amount) {
		if (amount > 0) {
			balance += amount;
			System.out.println("Deposit Successfully.New Balance:" + balance);
		} else {
			System.out.println("Invalid Amount For Deposit");
		}
	}

	public void withdraw(double amount) {
		if (amount > 0 && amount <= balance) {
			balance -= amount;
			System.out.println("Withdrawal Successful.New Balance;" + balance);

		} else {
			System.out.println("Insufficient Funds Or Invalid amount For Withdrawal");
		}
	}
}

class ATM {
	private BankAccount account;
	private Scanner sc;

	public ATM(BankAccount account) {
		this.account = account;
		this.sc = new Scanner(System.in);
	}

	public void showMenu() {
		System.out.println("1. Check Balance");
		System.out.println("2. Deposit");
		System.out.println("3. WithDraw");
		System.out.println("4. Exit");
	}

	public void run() {
		int choice;
		do {
			showMenu();
			System.out.println(" Enter Your Choice");
			choice = sc.nextInt();
			switch (choice) {
			case 1:
				checkBalance();
				break;
			case 2:
				deposit();
				break;
			case 3:
				withDraw();
				break;
			case 4:
				System.out.println("Thank You For Using the ATM");
				break;
			default:
				System.out.println("Inavlid Choice . Please select the Valid option");
			}

		} while (choice != 4);
	}

	private void checkBalance() {
		System.out.println(" Your Current Balance Is" + account.getBalance());
	}

	private void deposit() {
		System.out.println("Enter The Amount To Deposit");
		double amount = sc.nextDouble();
		account.deposit(amount);
	}

	private void withDraw() {
		System.out.println("Enter The amount To WithDraw");
		double amount = sc.nextDouble();
		account.deposit(amount);
	}

	public class ATM_Interface {
		public static void main(String args[]) {
			System.out.println("Welcome To ATM...!");
			Scanner sc = new Scanner(System.in);
			System.out.println("Enter Your Pin");
			int enteredPin = sc.nextInt();

			BankAccount userAccount = new BankAccount(1000.0);
			ATM atm = new ATM(userAccount);
			atm.run();
		}
	}
}
