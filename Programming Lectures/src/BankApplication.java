import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Scanner;
//import java.io;

public class BankApplication {

	public static void main(String[] args) {

		Bank bank = new Bank();
		bank.readCustomersFromFile();
		Long[] accountNumbers = bank.getAllCustomerAccountNumbers();
		
		for(Long account: accountNumbers) {
			System.out.println(account);
		}
		
		Scanner userInputScanner = new Scanner(System.in);
		System.out.print("Please enter your name, addess, email and date of birth(dd-mm-yyy) separated by spaces: ");
		
		
		
		
//		BankCustomer bankCustomer = new BankCustomer();
//		bankCustomer.setAccountNumber(223234143);
//		bankCustomer.setSortCode(999888);
//		bankCustomer.setCustomerName("John Smith");
//		bankCustomer.setCustomerEmail("email@mail.com");
//		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
//		try {
//			bankCustomer.setCustomerDateOfBirth(formatter.parse("10/01/1990"));
//		} catch (ParseException e) {
//			e.printStackTrace();
//		}
//		bankCustomer.setCustomerAddress("Trinity College Dublin");
//		// customerList.add(bankCustomer);
//		bank.customerTree.put(new Long(223234143), bankCustomer);
//		bank.findCustomer(new Long(223234143));
	}

}
