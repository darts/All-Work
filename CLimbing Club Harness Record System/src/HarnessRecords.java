import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class HarnessRecords {
	ArrayList<Harness> harnessList;
	boolean isValidList = true;

	public HarnessRecords(ArrayList<Harness> harnessList) {
		this.harnessList = harnessList;
	}

	// Read from a file.
	public HarnessRecords(String fileName, int numOfHarnesses) {
		try {
			System.out.println(fileName);
			BufferedReader reader = new BufferedReader(new FileReader(fileName));

			for (int index = 0; index < numOfHarnesses; index++) {
				String harnessData = reader.readLine();
				if (harnessData == null) {
				} else {
					String[] harnessInfo = harnessData.split(",");
					harnessList.add(new Harness(harnessInfo[0], Integer.parseInt(harnessInfo[1]),
							Integer.parseInt(harnessInfo[2]), harnessInfo[3], Boolean.parseBoolean(harnessInfo[4]),
							harnessInfo[5]));
				}
			}
			reader.close();
		} catch (FileNotFoundException e) {
			System.out.println("Sorry but this file could not be found.");
			isValidList = false;
		} catch (IOException e) {
			System.out.println("IOException");
		}
	}

	public boolean isEmpty() {
		if (harnessList.size() == 0)
			return false;
		return true;
	}

	public void addHarness(Harness harness) {
		if (harness != null)
			harnessList.add(harness);
	}

	public Harness findHarness(String make, int modelNumber) {
		for (Harness harness : harnessList) {
			if (harness.getMake().equals(make) && harness.getModelNumber() == modelNumber)
				return harness;
		}
		return null;
	}

	public Harness checkHarness(String make, int modelNumber, String instructorName) {
		Harness harness = findHarness(make, modelNumber);
		if (harness != null && instructorName != null) {
			if (harness.checkHarness(instructorName))
				return harness;
		}
		return null;
	}

	public Harness loanHarness(String memberName) {
		if (memberName != null) {
			for (Harness harness : harnessList) {
				if (harness.loanHarness(memberName))
					return harness;
			}
		}
		return null;
	}

	public Harness returnHarness(String make, int modelNumber) {
		Harness harness = findHarness(make, modelNumber);
		if (harness != null) {
			harness.returnHarness();
			return harness;
		}
		return null;
	}

	public Harness removeHarness(String make, int modelNumber) {
		Harness harness = findHarness(make, modelNumber);
		if (harness != null) {
			harnessList.remove(harness);
			return harness;
		}
		return null;
	}

	public ArrayList<Harness> getHarnessList() {
		return harnessList;
	}

	public boolean isValid() {
		return isValidList;
	}
}
