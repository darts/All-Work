import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.TreeMap;
import java.util.Map;
import java.util.Set;

public class Bank implements BankInterface {
	Map<Long, BankCustomer> customerTree;
	long account;
	public static final int SORT_CODE = 991222;
	public static final int OPENING_BALANCE = 0;
	public Bank() {
		customerTree = new TreeMap<Long, BankCustomer>();
		account = 10001;
	}

	public static void main(String[] args) {
	}

	public BankCustomer findCustomer(long customerNumber) {
		return customerTree.get(customerNumber);
	}

	@Override
	public long createAccountNumber() {
		return account++;
	}

	@Override
	public BankCustomer findCustomer(String name, Date dateOfBirth, String address) {
		BankCustomer customer = null;
		boolean customerFound = false;
		for (int index = 0; index < customerTree.size() && !customerFound; index++) {
			customer = customerTree.get(new Long(index));
			if (customer.getCustomerName() == name && customer.getCustomerDateOfBirth() == dateOfBirth
					&& customer.getCustomerAddress() == address)
				customerFound = true;
		}
		return customer;
	}

	@Override
	public void printBalance(long accountNumber) {
		BankCustomer customer = findCustomer(accountNumber);
		if (customer != null)
			System.out.println("�" + customer.getBalance());
		else
			System.out.println("Account Number does not exist");
	}

	// Returns true if account has been debited successfully.
	public boolean debitAccount(long accountNumber, double debitAmount) {
		BankCustomer customer = findCustomer(accountNumber);
		if (customer != null) {
			double balance = customer.getBalance();
			if (balance >= debitAmount) {
				customer.setBalance(balance - debitAmount);
				DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
				customer.addTransaction(new transactions(new Date(), "Debit", debitAmount, customer.getBalance()));
				return true;
			}
		}
		return false;
	}

	@Override
	public boolean creditAccount(long accountNumber, double creditAmount) {
		BankCustomer customer = findCustomer(accountNumber);
		if (customer != null) {
			customer.setBalance(customer.getBalance() + creditAmount);
			DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
			customer.addTransaction(new transactions(new Date(), "Credit", creditAmount, customer.getBalance()));
			return true;
		}
		return false;
	}

	public void readCustomersFromFile() {
		FileReader reader;
		try {
			reader = new FileReader("customers.txt");
			BufferedReader buffReader = new BufferedReader(reader);
			boolean endFound = false;
			while (!endFound) {
				String custData = buffReader.readLine();
				if (custData == null) {
					endFound = true;
				} else {
					DateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
					String[] customerInfo = custData.split(",");
					Date dateOfBirth = null;
					try {
						dateOfBirth = (formatter.parse(customerInfo[5]));
					} catch (ParseException e) {
						e.printStackTrace();
					}
					BankCustomer NewCustomer = new BankCustomer(Long.parseLong(customerInfo[0]),
							Integer.parseInt(customerInfo[1]), customerInfo[2], customerInfo[3], customerInfo[4],
							dateOfBirth, new Double(customerInfo[6]));
					customerTree.put(NewCustomer.getAccountNumber(), NewCustomer);
				}
			}
			buffReader.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void printStatement(long accountNumber) {
		BankCustomer customer = findCustomer(accountNumber);
		ArrayList<transactions> transactionList = customer.getCustomerTransactions();
		for (int counter = 0; counter < transactionList.size(); counter++) {
			System.out.println(transactionList.get(counter).toString());
		}
	}

	public Long[] getAllCustomerAccountNumbers() {
		Long[] customerAccountNumbers = new Long[customerTree.keySet().size()];
		customerAccountNumbers = customerTree.keySet().toArray(customerAccountNumbers);
		return customerAccountNumbers;
	}
	
	public void createCustomer(String name, String address, String email, String dateOfBirth) {
		long accountNumber = createAccountNumber();
		DateFormat formatter = new SimpleDateFormat("dd-MM-yyy");
		Date birthDate = null;
		try {
			birthDate = formatter.parse(dateOfBirth);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		BankCustomer customer = new BankCustomer(accountNumber, SORT_CODE, name, address, email, birthDate, OPENING_BALANCE);
		customerTree.put(customer.getAccountNumber(), customer);
	}
		
//	public ArrayList<long> getCustomerAccountNumbers() {
//		ArrayList<Long> customerAccountNumbers = new ArrayList<Long>();
//		Set <Long> accountNumbers = customerTree.keySet();
//		for(int count = 0; count < accountNumbers.size(); count++) {
//			
//		}
//	}
}
