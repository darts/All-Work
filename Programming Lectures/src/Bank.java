
// new class banktester and move main there etc.
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

public class Bank implements BankInterface {
	// static List<BankCustomer> customerList = new ArrayList<BankCustomer>();
	Map<Long, BankCustomer> customerTree = new TreeMap<Long, BankCustomer>();
	long account = 10001;

	public static void main(String[] args) {
	}

	public BankCustomer findCustomer(long customerNumber) {
		// BankCustomer customer = null;
		// boolean customerFound = false;
		/*
		 * for (int index = 0; index < customerList.size() && !customerFound; index++) {
		 * customer = customerList.get(index); if (customer.getAccountNumber() ==
		 * customerNumber) return customer; }
		 */
		return customerTree.get(customerNumber);
		// return null;
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
			System.out.println("€" + customer.getBalance());
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
				transactions transaction = new transactions();
				transaction.setClosingBalance(customer.getBalance());
				transaction.setTransactionAmount(debitAmount);
				DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
				Date date = new Date();
				transaction.setTransactionDate(date);
				customer.addTransaction(transaction);
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
			transactions transaction = new transactions();
			transaction.setClosingBalance(customer.getBalance());
			transaction.setTransactionAmount(creditAmount);
			customer.addTransaction(transaction);
//			transaction.setTransactionDate();
			return true;
		}
		return false;
	}

	public void readCustomersFromFile(int index) {
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
					BankCustomer NewCustomer = new BankCustomer();
					NewCustomer.setAccountNumber(Long.parseLong(customerInfo[0]));
					NewCustomer.setSortCode(Integer.parseInt(customerInfo[1]));
					NewCustomer.setCustomerName(customerInfo[2]);
					NewCustomer.setCustomerAddress(customerInfo[3]);
					NewCustomer.setCustomerEmail(customerInfo[4]);
					try {
						NewCustomer.setCustomerDateOfBirth(formatter.parse(customerInfo[5]));
					} catch (ParseException e) {
						e.printStackTrace();
					}
					NewCustomer.setBalance(new Double(customerInfo[6]));
					customerTree.put(NewCustomer.getAccountNumber(), NewCustomer);

				}

			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
