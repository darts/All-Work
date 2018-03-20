/* SELF ASSESSMENT

Harness Class: Member variables (8 marks) 8
All my data members are declared, private and the ones that don't change are marked as private. I also have a constant for the maximum number of uses of a harness.
Comment:All data members are declared with the ones that don't change marked as final. A constant is used for the maximum number of uses of a harness.

Harness Class: Harness constructor 1 & constructor 2 (6 marks) 6
I initialise all the variables using the parameters given and set the other members to reasonable default values.
Comment:All variables are initialised using the parameters or set to reasonable default values (0, false etc.).

Harness Class: checkHarness method (5 marks) 5
My method takes an instructor's name as a parameter, and if the harness is not on loan sets the instructor member variable to the given parameter value 
(assuming the instructor's name is not null/empty). It also resets the number of times the harness was used.
Comment:The method takes an instructors name, ensures it is not null and then sets that to the instructor name variable assuming it is not on loan. It then resets the number of
times used.

Harness Class: isHarnessOnLoan method (2 marks) 2
My method has no parameters and returns the value of the loan status variable.
Comment:This returns a boolean value of true if the harness is on loan and false otherwise.

Harness Class: canHarnessBeLoaned method (4 marks) 4
My method has no parameters and returns true if the harness is not on loan and if the number of times it was used is less than the maximum allowed number of times.
Comment:This method checks if a harness is not on loan and if it has been used less than the maximum allowed and returns true if both are true.

Harness Class: loanHarness method (6 marks) 6
My method has a member name as a parameter and it checks if harness can be loaned by using the canHarnessBeLoaned method. If true, it sets the club member value to the 
parameter value, sets the on loan status to true and increments the number of times used variable.
Comment:The method is passed a member name, checks it is not null and that canHarnessBeLoaned returns true. If this is the case it updates all the required variables.
 
Harness Class: returnHarness method (5 marks) 5
My method has no parameters, checks if the harness is on loan, and if so, changes its on-loan status to false, and resets the club member value.
Comment: This function checks if a harness is on loan and if it is changes its onLoan boolean to false and resets the club member value to null.

Harness Class: toString method (3 marks) 3
My method returns a String representation of all the member variables.
Comment:The method returns all of the variables in the object in string form.

HarnessRecords Class: member variables (3 marks) 3
I declare the member variable as a private collection of Harnesses
Comment: All variables are private. Collection of harnesses is private.

HarnessRecords Class: HarnessRecords constructor 1 & 2 (9 marks) 9
In the first constructor, I set the member variable to null [1 mark]. In the second constructor, I use the Java I/O to read data from a text file I created
 containing sets of Harness characteristics. I use these set of characteristics to create Harness objects and add them to the collection.
Comment:In the first constructor the collection is set to null. In the second constructor, a passed file is read and harness objects are created from it.

HarnessRecords Class: isEmpty method (1 marks) 1
I return true if the collection is null/empty and, false otherwise.
Comment:The method returns true only if the collection is empty or null.

HarnessRecords Class: addHarness method (5 marks) 5
My method takes a Harness object as a parameter and adds the harness to the collection.
Comment: The method adds the passed Harness to the collection.

HarnessRecords Class: findHarness method (6 marks) 6
My method takes a make and model number as parameters. It checks if a harness with such properties exists and if it does it returns harness object, otherwise returns null.
Comment:The method returns the harness matching the passed parameters and null if it cannot be found.

HarnessRecords Class: checkHarness method (6 marks) 6
must take instructor name, make and model number as parameters and return a Harness. If a harness with the make and model number exists by using the findHarness method 
and is not on loan, the Harness method checkHarness is called with the instructor name as a parameter and the updated Harness object is returned. If the harness is not
available returns null.
Comment: The method updates and returns the harness if the parameters passed are reasonable and the harness is not on loan and returns null otherwise.

HarnessRecords Class: loanHarness method (7 marks) 7
My method takes a club member name as a parameter and looks for an available harness by calling the method canHarnessBeLoaned be loaned. 
If an available harness is found it is loaned by using the Harness method loanHarness with the club member as a parameter, returning the harness. 
If there's no available harness null is returned.
Comment: The method returns the harness that has been loaned to a member and null if none could be loaned.

HarnessRecords Class: returnHarness method (7 marks) 7
My method takes a make and model number as parameters. It checks if a harness with those properties exists by using the findHarness method. 
If the found harness is not null, it returns the harness object by using Harness method returnHarness, otherwise returns null.
Comment:The method returns a harness if it is valid, and otherwise null.

HarnessRecords Class: removeHarness method (8 marks) 8 
My method takes a make and model number as parameters and check the collection for a harness with those properties and removes it. 
It returns the harness object if it is found, otherwise returns null.
Comment:This method removes the harness if it can be found, otherwise null is returned.

GUI (Java main line) (5 marks) 5
My test class has a menu which implements at least the five points specified using the HarnessRecords class methods.
Comment:More than the 5 points specified are implemented.

*/

import java.util.Scanner;

final class ClubManager {
	public static final String ADD_COMMAND = "add";
	public static final String REMOVE_COMMAND = "remove";
	public static final String RECORD_CHECK_COMMAND = "record";
	public static final String LOAN_COMMAND = "loan";
	public static final String RETURN_COMMAND = "return";
	public static final String IMPORT_COMMAND = "import";
	public static final String EXIT_COMMAND = "exit";
//	public static final String SHOW_DATA = "display";
	public static final String HELP_COMMAND = "help";

	private boolean finished;
	private HarnessRecords record;

	public ClubManager() {
		finished = false;
		record = new HarnessRecords();
		record.initArray();
	}

	public static void main(String[] args) {
		ClubManager manager = new ClubManager();
		manager.runInterface();
	}

	public void runInterface() {
		printCommands();
		Scanner userInputScanner = new Scanner(System.in);
		while (!finished) {
			if (userInputScanner.hasNext()) {
				String userInput = userInputScanner.next();
				evalInput(userInput);
				if (userInputScanner.hasNext())
					userInputScanner.nextLine();
			}
		}
		userInputScanner.close();
	}

	public void printCommands() {
		System.out.print("'" + ADD_COMMAND + "' - Add a new harness \n'" + REMOVE_COMMAND + "' - Remove a harness \n'"
				+ RECORD_CHECK_COMMAND + "' - An Instructor has checked a harness \n'" + LOAN_COMMAND
				+ "' - Loan a harness to a member \n'" + RETURN_COMMAND + "' - A user has returned a harness\n'"
				+ IMPORT_COMMAND + "' - Import a list of records from a file \n'"+ EXIT_COMMAND + "' -"
				+ " Exit the program \n'" + HELP_COMMAND + "' - To show this list\n>");
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
			loanHarness();
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
//		case SHOW_DATA:
//			displayData();
//			break;
		default:
			System.out.print("Sorry this command was not recognised, please type 'help' for a list of commands.\n>");
		}
	}

//	public void displayData() {
//		String[] retString = getStringInt();
//		Harness harness = record.findHarness(retString[0], Integer.parseInt(retString[1]));
//		if(harness != null) {
//			System.out.print(harness.toString() + "\n>");
//		}else {
//			System.out.print("This harness could not be found.");
//		}
//	}
	
	public void addHarness() {
		String[] passValues = getStringIntString();
		record.addHarness(new Harness(passValues[0], Integer.parseInt(passValues[1]), passValues[2]));
		System.out
				.print("The harness: \nMake - " + passValues[0] + "\nModel Number - " + passValues[1] + "\nHas been added.\n>");
	}

	public String[] getStringIntString() {
		boolean inputValid = false;
		String[] retString = new String[3];
		System.out.print("Please enter the harness information in the format: Make Modelnumber Instructor\n>");
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
			inputScanner.close();
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
		System.out.println("Please enter the harness information in the format: Make Modelnumber\n>");
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
			inputScanner.close();
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
						+ harness.getModelNumber() + "\nHas been removed.\n>");
			} else {
				System.out.print("The specified harness could not be found.\n>");
			}
		}
	}

	public void importFromFile() {//Getstring int
		boolean impValid = false;
		System.out.print("Please enter the filepath of the record list: ");
		while (!impValid) {
			System.out.print("\n>");
			Scanner inputScanner = new Scanner(System.in);
			if (inputScanner.hasNext()) {
				record.readFromFile(inputScanner.nextLine());
				impValid = true;
			}
			inputScanner.close();
		}
	}
	
	public void printFormatErr() {
		System.out.print("Please ensure you entered the required information in the correct format.\n>");
	}
	
	public void loanHarness() {
		boolean lnValid = false;
		Harness harness = null;
		System.out.print("Please enter the name of the member who would like to borrow a harness: ");
		while(!lnValid) {
			System.out.print("\n>");
			Scanner inputScanner = new Scanner(System.in);
			if(inputScanner.hasNext()) {
				harness = record.loanHarness(inputScanner.nextLine());
				lnValid = true;
			}
			inputScanner.close();
		}
		if(harness != null) {
			System.out.println("The harness: \nMake - " + harness.getMake() + "\nModel - "
					+ harness.getModelNumber() + "\nHas been loaned to : " + harness.getLoanMember());
		}else {
			System.out.println("There are no harnesses available for loan.");
		}
	}
}
