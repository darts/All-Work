/* SELF ASSESSMENT
 1. Did I use easy-to-understand meaningful variable names formatted properly (in lowerCamelCase)?
        Mark out of 5:  5 - All variables are easy-to-understand and meaningful in their respective contexts.
 2. Did I indent the code appropriately?
        Mark out of 5: 5 - Code is indented automatically by the eclipse IDE. 
 3. Did I write the initialiseHighScores function correctly (parameters, return type and function body) and invoke it correctly?
       Mark out of 15: 15 - The function is written correctly, it is passed an array, does not return and functions correctly. It is also invoked
        					correctly in the main line and then later if the user calls it.
 4. Did I write the printHighScores function correctly (parameters, return type and function body) and invoke it correctly?
       Mark out of 15: 15 - The function is written correctly, it is passed an array, does not return anything and correctly 
       						prints the list of high scores. After each new score is entered or when the user calls it. Prints a 
       						friendly error message to the user if they try to print an empty list.
 5. Did I write the higherThan function correctly (parameters, return type and function body) and invoke it correctly?
       Mark out of 15: 15 - The function is written correctly, it is passed an array and an integer and return a boolean. It is invoked
       						every time another score is added. 
 6. Did I write the insertScore function correctly (parameters, return type and function body) and invoke it correctly?
       Mark out of 20: 20 - The function is written correctly, it is passed an array and a number to add to the array and inserts it in the correct
       						position in the array. It does not return anything.
 7. Did I write the main function body correctly (first asking for the number of scores to be maintained and then repeatedly asking for scores)?
       Mark out of 20: 20 - Yes. All error handling is done in the main body. The user first enters the number of scores to be maintained and 
       						then enters scores repeatedly or enters one of the displayed commands.
 8. How well did I complete this self-assessment?
        Mark out of 5: 5 - I graded my code and justified the grade.
 Total Mark out of 100 (Add all the previous marks): 100
*/

import java.util.Scanner;

public class HighScores {
	public static void main(String[] args) {
		boolean hasEnteredNumberToKeep = false;
		boolean finished = false;
		int[] listOfHighScores = {};
		while (!finished) {
			Scanner userInputScanner = new Scanner(System.in);
			if (!hasEnteredNumberToKeep) {
				System.out.print("How many high scores would you like to keep?: ");
				if (userInputScanner.hasNextInt()) {
					int numberInput = userInputScanner.nextInt();
					if (userInputNumberCheck(numberInput)) {
						listOfHighScores = new int[numberInput];
						hasEnteredNumberToKeep = true;
						initialiseHighScore(listOfHighScores);
						System.out.println(numberInput + " high scores will be kept.");
					}
				} else {
					System.out.println("You must enter a positive whole number.");
				}
			} else {
				System.out.print("Please enter a number to add (or 'quit' to exit, 'zero' to clear all high scores, "
						+ "or 'print' to print all scores): ");
				if (userInputScanner.hasNextInt()) {
					int numberInput = userInputScanner.nextInt();
					if (userInputNumberCheck(numberInput)) {
						insertScore(listOfHighScores, numberInput);
						printHighScores(listOfHighScores);
					}
				} else {
					finished = userInputNotNumber(userInputScanner.next(), listOfHighScores);
				}
			}
		}
	}

	// Returns true if the user enters a positive whole number, otherwise prints an error and returns false
	public static boolean userInputNumberCheck(int numToCheck) {
		if (numToCheck > 0)
			return true;
		System.out.println("You must enter a positive whole number.");
		return false;
	}

	// Analyzes the input and performs the command it relates to.
	public static boolean userInputNotNumber(String inputString, int[] arrayOfHighScores) {
		if (inputString.equals("quit")) {
			System.out.println("Goodbye...");
			return true;
		} else if (inputString.equals("zero")) {
			initialiseHighScore(arrayOfHighScores);
			System.out.println("All high scores set to zero");
		} else if (inputString.equals("print")) {
			printHighScores(arrayOfHighScores);
		} else {
			System.out.println("Sorry, your input was not recognised.");
		}
		return false;
	}

	// Sets all values in the array to zero
	public static void initialiseHighScore(int[] listOfHighScoresToZero) {
		for (int index = 0; index < listOfHighScoresToZero.length; index++) {
			listOfHighScoresToZero[index] = 0;
		}
	}

	// Takes an array and prints all the values
	public static void printHighScores(int[] listOfHighScoresToPrint) {
		if(listOfHighScoresToPrint[0] != 0) {
		String stringToPrint = "The high scores are";
		if (listOfHighScoresToPrint[1] == 0)
			stringToPrint = "The high score is";
		for (int index = 0; index < listOfHighScoresToPrint.length; index++) {
			if (listOfHighScoresToPrint[index] != 0)
				stringToPrint += (" " + listOfHighScoresToPrint[index]
						+ ((index < listOfHighScoresToPrint.length - 1 && listOfHighScoresToPrint[index + 1] > 0) ? ","
								: ""));
		}
		System.out.println(stringToPrint);
		}else {
			System.out.println("There are no high scores. Please enter some.");
		}
	}

	// Returns if a number is higher than any value in the list.
	public static boolean higherThan(int[] listOfHighScores, int numToCheck) {
		if (numToCheck < listOfHighScores[listOfHighScores.length - 1])
			return false;
		return true;
	}

	// returns how many numbers in the array the passed number is higher than, if there are none, returns -1
	public static int higherThanXNumbers(int[] listOfHighScores, int numToCheck) {
		if (numToCheck < listOfHighScores[listOfHighScores.length - 1])
			return -1;
		int higherThanXNumbers = 0;
		if (numToCheck > listOfHighScores[0])
			return (listOfHighScores.length);
		for (int index = 0; index < listOfHighScores.length; index++) {
			if (numToCheck > listOfHighScores[index])
				higherThanXNumbers++;
		}
		return higherThanXNumbers;
	}

	// Takes an array and a number and inserts the number into the correct position in the array
	public static void insertScore(int[] listOfHighScores, int numToInsert) {
		if (higherThanXNumbers(listOfHighScores, numToInsert) != -1 && higherThan(listOfHighScores, numToInsert)) {
			int higherThanXNumbers = higherThanXNumbers(listOfHighScores, numToInsert);
			for (int index = (listOfHighScores.length - 1); index > (listOfHighScores.length - higherThanXNumbers); index--) {
				int tmpIndex = index - 1;
				listOfHighScores[index] = listOfHighScores[tmpIndex];
			}
			listOfHighScores[listOfHighScores.length - higherThanXNumbers] = numToInsert;
		}
	}
}