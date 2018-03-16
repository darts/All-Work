
public class SavingsAccount extends BankAccount{
	
	public SavingsAccount(long accountNumber){
		super(accountNumber);
	}

	public double calculateCharges() {
		return 0.000;
	}
	
	public double calculateInterest() {
		return 0.000;
	}
}
