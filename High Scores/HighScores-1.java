/* SELF ASSESSMENT
 1. Did I use easy-to-understand meaningful variable names formatted properly (in lowerCamelCase)?
        Mark out of 5:  
 2. Did I indent the code appropriately?
        Mark out of 5: 
 3. Did I write the initialiseHighlistOfHighScores function correctly (parameters, return type and function body) and invoke it correctly?
       Mark out of 15:  
 4. Did I write the printHighlistOfHighScores function correctly (parameters, return type and function body) and invoke it correctly?
       Mark out of 15:  
 5. Did I write the higherThan function correctly (parameters, return type and function body) and invoke it correctly?
       Mark out of 15:  
 6. Did I write the insertScore function correctly (parameters, return type and function body) and invoke it correctly?
       Mark out of 20:  
 7. Did I write the main function body correctly (first asking for the number of listOfHighScores to be maintained and then repeatedly asking for listOfHighScores)?
       Mark out of 20:  
 8. How well did I complete this self-assessment?
        Mark out of 5:
 Total Mark out of 100 (Add all the previous marks):
*/ 

import java.util.Scanner;
public class HighScoresOne {

	public static void main(String[] args) {
		boolean hasEnteredNumberToKeep = false;
		boolean finished = false;
		int[] listOfHighScores = {};
		while (!finished) {
			Scanner userInputScanner = new Scanner(System.in);
			if (!hasEnteredNumberToKeep) {
				System.out.print("How many listOfHighScores would you like to keep?: ");
				if (userInputScanner.hasNextInt()) {
					int numberInput = userInputScanner.nextInt();
					if (numberInput > 0) {
						listOfHighScores = new int[numberInput];
						hasEnteredNumberToKeep = true;
					}
				}
			} else {
				System.out.print(
						"Please enter a number to add (or 'quit' to exit, 'zero' to clear all listOfHighScores): ");
				if (userInputScanner.hasNextInt()) {
					int numberInput = userInputScanner.nextInt();
					if (numberInput > 0) {
						insertScore(listOfHighScores, numberInput);
						printHighlistOfHighScores(listOfHighScores);
					} else {
						System.out.println("You must enter a positive whole number");
					}
				} else {
					finished = userInputNotNumber(userInputScanner.next(), listOfHighScores);
				}
			}
		}
	}

	// Analyzes the input and performs the command it relates to.
	public static boolean userInputNotNumber(String inputString, int[] arrayOflistOfHighScores) {
		if (inputString.equals("quit")) {
			System.out.println("Goodbye...");
			return true;
		} else if (inputString.equals("zero")) {
			initialiseHighScore(arrayOflistOfHighScores);
			printHighlistOfHighScores(arrayOflistOfHighScores);
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
	public static void printHighlistOfHighScores(int[] listOfHighScoresToPrint) {
		String stringToPrint = "The high listOfHighScores are";
		for (int index = 0; index < listOfHighScoresToPrint.length; index++) {
			stringToPrint += (" " + listOfHighScoresToPrint[index] + ((index < listOfHighScoresToPrint.length - 1) ? "," : ""));
		}
		System.out.println(stringToPrint);
	}

	// Takes an array and a number and return if the number is higher than any
	// number in the array
	public static boolean higherThan(int[] listOfHighScores, int numToCheck) {
		if (numToCheck > listOfHighScores[listOfHighScores.length - 1])
			return true;
		return false;
	}

	// returns how many numbers in the array the passed number is higher than
	public static int higherThanInt(int[] listOfHighScores, int numToCheck) {
		int higherThanXNumbers = 0;
		if (numToCheck > listOfHighScores[0])
			return (listOfHighScores.length);
		for (int index = 0; index < listOfHighScores.length; index++) {
			if (numToCheck > listOfHighScores[index])
				higherThanXNumbers++;
		}
		return higherThanXNumbers;
	}

	// Takes an array and a number and inserts the number into the correct
	// position in the array
	public static void insertScore(int[] listOfHighScores, int numToInsert) {
		if (higherThan(listOfHighScores, numToInsert)) {
			int higherThanXNumbers = higherThanInt(listOfHighScores, numToInsert);
			for (int index = (listOfHighScores.length - 1); index > (listOfHighScores.length - higherThanXNumbers); index--) {
				int tmpIndex = index - 1;
				listOfHighScores[index] = listOfHighScores[tmpIndex];
			}
			listOfHighScores[listOfHighScores.length - higherThanXNumbers] = numToInsert;
		}
	}
}