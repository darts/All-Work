import java.io.*;

abstract public class HeadOffice {
	String bankName;
	String address;

	private long accountNumber = 10000000;
	private int sortCode = 991100;

	public long createAccountNumber() {
		try {
			BufferedReader buffReader = new BufferedReader(new FileReader("accountNumber.txt"));
			boolean endOfFileFound = false;
			while (!endOfFileFound) {
				String aNumString = buffReader.readLine();
				if (aNumString == null) {
					endOfFileFound = true;
				} else {
					accountNumber = Long.parseLong(aNumString);
				}
			}
		} catch (Exception e) {

		}
		if(accountNumber > 0)
			return ++accountNumber;
		return accountNumber;
	}

	public int createSortCode() {
		return sortCode++;
	}

	public HeadOffice() {
		try {
			BufferedWriter buffWriter = new BufferedWriter(new FileWriter("accountNumber.txt"));
			buffWriter.write(String.valueOf(this.accountNumber));
			buffWriter = new BufferedWriter(new FileWriter("sortCode.txt"));
			buffWriter.write(String.valueOf(this.sortCode));
			buffWriter.close();
		} catch (Exception e) {

		}
	}
}
