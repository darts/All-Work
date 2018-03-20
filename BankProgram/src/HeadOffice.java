
abstract public class HeadOffice {
	String bankName;
	String address;
	
	private long accountNumber = 10000000;
	private int sortCode  = 991100;
	
	public long createAccountNumber() {
		return accountNumber++;
	}
	
	public int createSortCode() {
		return sortCode++;
	}
}
