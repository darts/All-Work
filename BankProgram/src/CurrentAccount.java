
public class CurrentAccount extends BankAccount{
	
	public CurrentAccount(long accountNumber) {
		super(accountNumber);
		
	}
	
	public double calculateCharges() {
		return 0.000;
	}
	
	public double calculateInterest() {
		return 0.000;
	}
}
