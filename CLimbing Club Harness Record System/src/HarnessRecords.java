import java.util.ArrayList;

public class HarnessRecords {
	ArrayList<Harness> harnessList;

	public HarnessRecords(ArrayList<Harness> harnessList) {
		this.harnessList = harnessList;
	}

	public HarnessRecords() {
	}

	public boolean isEmpty() {
		if (harnessList.size() == 0)
			return false;
		return true;
	}

	public void addHarness(Harness harness) {
		if(harness != null)
			harnessList.add(harness);
	}
	
	public Harness findHarness(String make, int modelNumber) {
		for(Harness harness : harnessList) {
			if(harness.getMake().equals(make) && harness.getModelNumber() == modelNumber)
				return harness;
		}
		return null;
	}

}
