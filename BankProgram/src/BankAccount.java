import java.util.ArrayList;

public class BankAccount {
	private final long accountNumber;
	private double balance;
	private ArrayList<Transaction> transactionList;
	
	public BankAccount(long accountNumber) {
		this.accountNumber = accountNumber;
		balance = 0;
		transactionList = new ArrayList<Transaction>();
	}
	
	public long getAccountNumber() {
		return accountNumber;
	}

	public double returnBalance() {
		return balance;
	}

	public ArrayList<Transaction> getTransactionList() {
		return transactionList;
	}

	public boolean creditBalance(double amount) {
		this.balance += amount;
		return true;
	}

	public boolean debitBalance(double amount) {
		if (balance >= amount) {
			balance -= amount;
			return true;
		}
		return false;
	}
}
