import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class Branch extends HeadOffice{
	String address;
	String manager;
//	long accountNumber = 10000000;

//	public static final int SORT_CODE = 99122;
	public ArrayList<Customer> customerList;

	public Branch() {
		customerList = new ArrayList<Customer>();
	}

	public Customer getCustomer(long accountNumber) {
		for (Customer customer : customerList) {
			ArrayList<BankAccount> customerAccounts = customer.getCustomerAccounts();
			for (BankAccount account : customerAccounts) {
				if (account.getAccountNumber() == accountNumber)
					return customer;
			}
		}
		return null;
	}
	
	public void createNewCustomer(String name, String address, String email, String dateOfBirth) {
		DateFormat formatter = new SimpleDateFormat("dd-MM-yyy");
		Date birthDate = null;
		try {
			birthDate = formatter.parse(dateOfBirth);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		customerList.add(new Customer(name, address, email, birthDate));
	}
	
	public void createAccount(String accountType, Customer customer) {
		if(accountType == BankDataConstants.CURRENT_ACCOUNT)
			customer.addAccount(new CurrentAccount(createAccountNumber()));
		else if(accountType == BankDataConstants.SAVINGS_ACCOUNT)
			customer.addAccount(new SavingsAccount(createAccountNumber()));
	}
//	public long createAccountNumber() {
//		return accountNumber++;
//	}
	
	public BankAccount getAccount(Customer customer, long accountNumber) {
		if(customer != null && accountNumber > 0) {
			for(BankAccount account : customer.getCustomerAccounts()) {
				if(account.getAccountNumber() == accountNumber)
					return account;
			}
		}
		return null;
	}
	
	public boolean creditAccount(BankAccount account, double amount) {
		if(account != null && amount > 0) {
			return account.creditBalance(amount);
			//return true;
		}
		return false;
	}
	
	public boolean debitAccount(BankAccount account, double amount) {
		if(account != null && amount > 0) {
			return account.debitBalance(amount);
			//return true;
		}
		return false;
	}
}
