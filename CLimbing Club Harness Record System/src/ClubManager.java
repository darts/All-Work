import java.util.ArrayList;
import java.util.Scanner;

final class ClubManager {
	public static final String ADD_COMMAND = "add";
	public static final String REMOVE_COMMAND = "remove";
	public static final String RECORD_CHECK_COMMAND = "record";
	public static final String LOAN_COMMAND = "loan";
	public static final String RETURN_COMMAND = "return";
	public static final String IMPORT_COMMAND = "import";
	public static final String EXIT_COMMAND = "exit";
	public static final String HELP_COMMAND = "help";
	public static final String CANCEL_COMMAND = "?cancel";

	private boolean finished;
	private HarnessRecords record;

	public ClubManager() {
		finished = false;
		record = new HarnessRecords(new ArrayList<Harness>());
	}

	public static void main(String[] args) {
		ClubManager manager = new ClubManager();
		manager.runInterface();
	}

	public void runInterface() {
		printCommands();
		Scanner userInputScanner = new Scanner(System.in);
		while (!finished) {
			System.out.print(">");
			if (userInputScanner.hasNext()) {
				String userInput = userInputScanner.next();
				evalInput(userInput);
				if (userInputScanner.hasNext())
					userInputScanner.nextLine();
			}
		}
	}

	public void printCommands() {
		System.out.println("'" + ADD_COMMAND + "' - Add a new harness \n'" + REMOVE_COMMAND + "' - Remove a harness \n'"
				+ RECORD_CHECK_COMMAND + "' - An Instructor has checked a harness \n'" + LOAN_COMMAND
				+ "' - Loan a harness to a member \n'" + RETURN_COMMAND + "' - A user has returned a harness\n'"
				+ IMPORT_COMMAND + "' - Import a list of records from a file \n'" + EXIT_COMMAND
				+ "' - Exit the program \n'" + HELP_COMMAND + "' - To show this list");
	}

	public void evalInput(String userInput) {
		switch (userInput) {
		case ADD_COMMAND:
			addHarness();
			break;
		case REMOVE_COMMAND:
			removeHarness();
			break;
		case RECORD_CHECK_COMMAND:
			checkHarness();
			break;
		case LOAN_COMMAND:
			// interpretInput(STRING_LOAN);
			break;
		case RETURN_COMMAND:
			returnHarness();
			break;
		case IMPORT_COMMAND:
			importFromFile();
			break;
		case EXIT_COMMAND:
			System.out.println("Goodbye...");
			finished = true;
			break;
		case HELP_COMMAND:
			printCommands();
			break;
		default:
			System.out.println("Sorry this command was not recognised, please type 'help' for a list of commands.");
		}
	}

	public void addHarness() {
		String[] passValues = getStringIntString();
		record.addHarness(new Harness(passValues[0], Integer.parseInt(passValues[1]), passValues[2]));
		System.out
				.println("The harness: \nMake - " + passValues[0] + "\nModel - " + passValues[1] + "\nHas been added.");
	}

	public String[] getStringIntString() {
		boolean inputValid = false;
		String[] retString = new String[3];
		System.out.println("Please enter the harness information in the format: Make Modelnumber Instructor\n>");
		while (!inputValid) {
			Scanner inputScanner = new Scanner(System.in);
			if (inputScanner.hasNext()) {
				retString[0] = inputScanner.next();
				if (inputScanner.hasNextInt()) {
					retString[1] = Integer.toString(inputScanner.nextInt());
					if (inputScanner.hasNext()) {
						retString[2] = inputScanner.next();
						inputValid = true;
					} else {
						inputScanner.nextLine();
						printFormatErr();
					}
				} else {
					inputScanner.nextLine();
					printFormatErr();
				}
			} else {
				inputScanner.nextLine();
				printFormatErr();
			}
		}
		return retString;
	}

	public void checkHarness() {
		boolean chkConfirmed = false;
		while (!chkConfirmed) {
			String[] passValues = getStringIntString();
			Harness harness = record.checkHarness(passValues[0], Integer.parseInt(passValues[1]), passValues[2]);
			if (harness != null) {
				chkConfirmed = true;
				System.out.println("The harness: \nMake - " + harness.getMake() + "\nModel - "
						+ harness.getModelNumber() + "\nHas been checked by : " + harness.getLastCheckedBy());
			} else {
				System.out.println("The specified harness could not be found.");
			}
		}
	}

	public String[] getStringInt() {
		boolean inputValid = false;
		String[] retString = new String[2];
		System.out.println("Please enter the harness information in the format: Make Modelnumber");
		while (!inputValid) {
			Scanner inputScanner = new Scanner(System.in);
			if (inputScanner.hasNext()) {
				retString[0] = inputScanner.next();
				if (inputScanner.hasNextInt()) {
					retString[1] = Integer.toString(inputScanner.nextInt());
					inputValid = true;
				} else {
					inputScanner.nextLine();
					printFormatErr();
				}
			} else {
				inputScanner.nextLine();
				printFormatErr();
			}
		}
		return retString;
	}

	public void returnHarness() {
		boolean rtnConfirmed = false;
		while (!rtnConfirmed) {
			String[] passValues = getStringInt();
			Harness harness = record.returnHarness(passValues[0], Integer.parseInt(passValues[1]));
			if (harness != null) {
				rtnConfirmed = true;
				System.out.println("The harness: \nMake - " + harness.getMake() + "\nModel - "
						+ harness.getModelNumber() + "\nHas been returned");
			} else {
				System.out.print("The specified harness could not be found.\n>");
			}
		}
	}

	public void removeHarness() {
		boolean rmConfirmed = false;
		while (!rmConfirmed) {
			String[] passValues = getStringInt();
			Harness harness = record.removeHarness(passValues[0], Integer.parseInt(passValues[1]));
			if (harness != null) {
				rmConfirmed = true;
				System.out.println("The harness: \nMake - " + harness.getMake() + "\nModel - "
						+ harness.getModelNumber() + "\nHas been removed");
			} else {
				System.out.print("The specified harness could not be found.\n>");
			}
		}
	}

	public void importFromFile() {
		boolean impValid = false;
		System.out.print("Please enter the filepath:");
		HarnessRecords newRec = null;
		while (!impValid) {
			System.out.print("\n>");
			Scanner inputScanner = new Scanner(System.in);
			if (inputScanner.hasNext()) {
				newRec = new HarnessRecords(inputScanner.nextLine());
				if (newRec.isValid() && newRec != null)
					impValid = true;
			}
		}
		for (Harness harness : newRec.getHarnessList()) {
			record.addHarness(harness);
		}
	}
	
	public void printFormatErr() {
		System.out.print("Please ensure you entered the required information in the correct format.\n>");
	}
}
