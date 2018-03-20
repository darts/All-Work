public class Harness {
	private static final int DEFAULT_USES = 0;
	private static final int MAX_USES = 25;
	private final String make;
	private final int modelNumber;
	private int numOfTimesUsed;
	private String lastCheckedBy;
	private boolean onLoan;
	private String loanMember;
	
	public Harness(String make, int modelNumber, int numOfTimesUsed, String lastCheckedBy, boolean onLoan,
			String loanMember) {
		this.make = make;
		this.modelNumber = modelNumber;
		this.numOfTimesUsed = numOfTimesUsed;
		this.lastCheckedBy = lastCheckedBy;
		this.onLoan = onLoan;
		this.loanMember = loanMember;
	}

	public Harness(String make, int modelNumber, String lastCheckedBy) {
		this.make = make;
		this.modelNumber = modelNumber;
		this.lastCheckedBy = lastCheckedBy;
		numOfTimesUsed = DEFAULT_USES;
		onLoan = false;
		loanMember = null;
	}
	
	public boolean checkHarness(String instructorName) {
		if(!onLoan && instructorName != null) {
			numOfTimesUsed = DEFAULT_USES;
			lastCheckedBy = instructorName;
			return true;
		}
		return false;
	}
	
	public boolean isHarnessOnLoan() {
		return onLoan;
	}
	
	public boolean canHarnessBeLoaned() {
		if(numOfTimesUsed < MAX_USES && !onLoan && loanMember == null) 
			return true;
		return false;
	}
	
	public boolean loanHarness(String member) {
		if(member != null && canHarnessBeLoaned()) {
			onLoan = true;
			loanMember = member;
			numOfTimesUsed++;
			return true;
		}
		return false;
	}
	
	public void returnHarness() {
		onLoan = false;
		loanMember = null;
	}
	
	@Override
	public String toString() {
		return "Make = " + make + "\nModel Number = " + modelNumber + "\nNumber Of Times Used = " + numOfTimesUsed
				+ "\nLast Checked By = " + lastCheckedBy + "\nIs On Loan = " + onLoan + "\nLoan Member = " + loanMember;
	}
	
	
	
	
	public int getNumOfTimesUsed() {
		return numOfTimesUsed;
	}

	public void setNumOfTimesUsed(int numOfTimesUsed) {
		this.numOfTimesUsed = numOfTimesUsed;
	}

	public String getLastCheckedBy() {
		return lastCheckedBy;
	}

	public void setLastCheckedBy(String lastCheckedBy) {
		this.lastCheckedBy = lastCheckedBy;
	}

	

	public void setOnLoan(boolean onLoan) {
		this.onLoan = onLoan;
	}

	public String getLoanMember() {
		return loanMember;
	}

	public void setLoanMember(String loanMember) {
		this.loanMember = loanMember;
	}

	public String getMake() {
		return make;
	}

	public int getModelNumber() {
		return modelNumber;
	}
	
	
	
	
	
	
	
	
	
}
