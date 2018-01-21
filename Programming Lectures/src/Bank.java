import java.text.ParseException;
import java.text.SimpleDateFormat;

public class Bank {
	
	public static void main(String[] args) {
		BankCustmer[] customerArray = new BankCustmer[100];
		BankCustmer bankCustomer = new BankCustmer();
		bankCustomer.setAccountNumber(223234143);
		bankCustomer.setSortCode(999888);
		bankCustomer.setCustomerName("John Smith");
		bankCustomer.setCustomerEmail("email@mail.com");
		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
		try {
			bankCustomer.setCustomerDateOfBirth(formatter.parse("10/01/1990"));
		}catch(ParseException e) {
			e.printStackTrace();
		}
		bankCustomer.setCustomerAddress("Trinity College Dublin");
		customerArray[0] = bankCustomer;
	
	}
	
	public String find(long customerNumber) {
		boolean customerFound = false;
		String returnString = "This Account Number does not exist.";
		for(int index = 0; index < customerArray.length && !customerFound; index++) {
			if(customerArray[index].getAccountNumber == customerNumber) {
				customerFound = true;
				returnString = customerArray[index].toString();
			}
		}
		return returnString;
	}

}
