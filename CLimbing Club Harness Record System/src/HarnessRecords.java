import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;

public class HarnessRecords {
	private ArrayList<Harness> harnessList;
	private boolean isValidList = true;

	public HarnessRecords() {
		harnessList = null;
	}

	// Read from a file.
	public HarnessRecords(String fileName) {
		harnessList = new ArrayList<Harness>();
		readFromFile(fileName);
	}
	
	public void initArray() {
		harnessList = new ArrayList<Harness>();
	}

	public void readFromFile(String fileName) {
		FileReader reader;
		try {
			reader = new FileReader(fileName);
			BufferedReader buffReader = new BufferedReader(reader);
			int lineCount = Integer.parseInt(buffReader.readLine());
			for(int index = 0; index < lineCount; index++) {
				String harnessData = buffReader.readLine();
				String[] harnessInfo = harnessData.split(",");
				harnessList.add(
						new Harness(harnessInfo[0], Integer.parseInt(harnessInfo[1]), Integer.parseInt(harnessInfo[2]),
								harnessInfo[3], Boolean.parseBoolean(harnessInfo[4]), harnessInfo[5]));
			}
			buffReader.close();
			System.out.print(lineCount + " harnesses have been imported.\n>");
		} catch (FileNotFoundException e) {
			System.out.print("The file could not be found.\n>");
		}catch(Exception e) {
			System.out.print("The file could not be read, please check for formatting errors.\n>");
		}
	}

	public boolean isEmpty() {
		if (harnessList != null && harnessList.size() != 0)
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
