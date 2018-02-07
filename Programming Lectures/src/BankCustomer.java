import java.util.ArrayList;
import java.util.Date;

public class BankCustomer {
	private long accountNumber;
	private int sortCode;
	private String customerName;
	private String customerAddress;
	private String customerEmail;
	private Date customerDateOfBirth;
	private double balance;
	private ArrayList<transactions> customerTransactions;

	public BankCustomer(long accountNumber, int sortCode, String customerName, String customerAddress,
			String customerEmail, Date customerDateOfBirth, double balance) {
		this.accountNumber = accountNumber;
		this.sortCode = sortCode;
		this.customerName = customerName;
		this.customerAddress = customerAddress;
		this.customerEmail = customerEmail;
		this.customerDateOfBirth = customerDateOfBirth;
		this.balance = balance;
		customerTransactions = new ArrayList<transactions>();
	}

	public BankCustomer() {
	}

	public ArrayList<transactions> getCustomerTransactions() {
		return customerTransactions;
	}

	public void addTransaction(transactions transaction) {
		customerTransactions.add(transaction);
	}

	public void setCustomerTransactions(ArrayList<transactions> customerTransactions) {
		this.customerTransactions = customerTransactions;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public long getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(long accountNumber) {
		this.accountNumber = accountNumber;
	}

	public int getSortCode() {
		return sortCode;
	}

	public void setSortCode(int sortCode) {
		this.sortCode = sortCode;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getCustomerAddress() {
		return customerAddress;
	}

	public void setCustomerAddress(String customerAddress) {
		this.customerAddress = customerAddress;
	}

	public String getCustomerEmail() {
		return customerEmail;
	}

	public void setCustomerEmail(String customerEmail) {
		this.customerEmail = customerEmail;
	}

	public Date getCustomerDateOfBirth() {
		return customerDateOfBirth;
	}

	public void setCustomerDateOfBirth(Date customerDateOfBirth) {
		this.customerDateOfBirth = customerDateOfBirth;
	}

	@Override
	public String toString() {
		return "BankCustomer [accountNumber=" + accountNumber + ", sortCode=" + sortCode + ", customerName="
				+ customerName + ", customerAddress=" + customerAddress + ", customerEmail=" + customerEmail
				+ ", customerDateOfBirth=" + customerDateOfBirth + ", balance=" + balance + "]";
	}

}
