import java.util.Scanner;

public class HighScoresTwo {

	public static void main(String[] args) {
		boolean hasEnteredNumberToKeep = false;
		boolean finished = false;
		int[] scores = {};
		while (!finished) {
			Scanner userInputScanner = new Scanner(System.in);
			if (!hasEnteredNumberToKeep) {
				System.out.print("How many scores would you like to keep?: ");
				if (userInputScanner.hasNextInt()) {
					int numberInput = userInputScanner.nextInt();
					if (numberInput > 0) {
						scores = new int[numberInput];
						hasEnteredNumberToKeep = true;
					}
				}
			} else {
				System.out.print(
						"Please enter a number to add (or 'quit' to exit, 'zero' to clear all scores): ");
				if (userInputScanner.hasNextInt()) {
					int numberInput = userInputScanner.nextInt();
					if (numberInput > 0) {
						insertScore(scores, numberInput);
						printHighScores(scores);
					} else {
						System.out.println("You must enter a positive whole number");
					}
				} else {
					finished = userInputNotNumber(userInputScanner.next(), scores);
				}
			}
		}
	}

	// Analyzes the input and performs the command it relates to.
	public static boolean userInputNotNumber(String inputString, int[] arrayOfScores) {
		if (inputString.equals("quit")) {
			System.out.println("Goodbye...");
			return true;
		} else if (inputString.equals("zero")) {
			initialiseHighScore(arrayOfScores);
			printHighScores(arrayOfScores);
		} else {
			System.out.println("Sorry, your input was not recognised.");
		}
		return false;

	}

	// Sets all values in the array to zero
	public static void initialiseHighScore(int[] scoresToZero) {
		for (int index = 0; index < scoresToZero.length; index++) {
			scoresToZero[index] = 0;
		}
	}

	// Takes an array and prints all the values
	public static void printHighScores(int[] scoresToPrint) {
		String stringToPrint = "The high scores are";
		for (int index = 0; index < scoresToPrint.length; index++) {
			stringToPrint += (" " + scoresToPrint[index] + ((index < scoresToPrint.length - 1) ? "," : ""));
		}
		System.out.println(stringToPrint);
	}

	// Takes an array and a number and return if the number is higher than any
	// number in the array
	public static boolean higherThan(int[] scores, int numToCheck) {
		if (numToCheck > scores[scores.length - 1])
			return true;
		return false;
	}

	// returns how many numbers in the array the passed number is higher than
	public static int higherThanInt(int[] scores, int numToCheck) {
		int higherThanXNumbers = 0;
		if (numToCheck > scores[0])
			return (scores.length);
		for (int index = 0; index < scores.length; index++) {
			if (numToCheck > scores[index])
				higherThanXNumbers++;
		}
		return higherThanXNumbers;
	}

	// Takes an array and a number and inserts the number into the correct
	// position in the array
	public static void insertScore(int[] scores, int numToInsert) {
		if (higherThan(scores, numToInsert)) {
			int higherThanXNumbers = higherThanInt(scores, numToInsert);
			for (int index = (scores.length - 1); index > (scores.length - higherThanXNumbers); index--) {
				int tmpIndex = index - 1;
				scores[index] = scores[tmpIndex];
			}
			scores[scores.length - higherThanXNumbers] = numToInsert;
		}
	}
}

/*
 * import java.util.Scanner;
 * 
 * public class HighScores {
 * 
 * public static void main(String[] args) { boolean hasEnteredNumberToKeep =
 * false; int[] scores = {}; while (!hasEnteredNumberToKeep) { System.out.print(
 * "How many scores would you like to keep? \n  >>"); Scanner userInputScanner =
 * new Scanner(System.in); if (userInputScanner.hasNextInt()) { int numberInput
 * = userInputScanner.nextInt(); if (numberInput > 0) { scores = new
 * int[numberInput]; hasEnteredNumberToKeep = true; } }
 * userInputScanner.close(); } boolean finished = false; // Scanner
 * inputScanner; while (!finished) { System.out.print(
 * "Please enter a number to add (type 'quit' to exit or 'print' to print a list of scores) \n  >>"
 * ); Scanner inputScanner = new Scanner(System.in); if
 * (inputScanner.hasNextInt()) { int numberInput = inputScanner.nextInt(); if
 * (numberInput > 0) { insertScore(scores, numberInput); }else{
 * System.out.println("You must enter a positive whole number"); } }
 * 
 * else{ finished = userInputNotNumber(inputScanner.next(), scores); }
 * 
 * 
 * } insertScore(scores, 1); printHighScores(scores); }
 * 
 * public static boolean userInputNotNumber(String inputString, int[]
 * arrayOfScores) {
 * 
 * if (inputString.equals("quit")) { return true; } else if
 * (inputString.equals("print")) { printHighScores(arrayOfScores); }else{
 * System.out.println("Sorry, your input was not recognised."); } return false;
 * 
 * }
 * 
 * public static void initialiseHighScore(int[] scoresToZero) { for (int index =
 * 0; index < scoresToZero.length; index++) { scoresToZero[index] = 0; } }
 * 
 * public static void printHighScores(int[] scoresToPrint) { String
 * stringToPrint = "The high scores are"; for (int index = 0; index <
 * scoresToPrint.length; index++) { stringToPrint += (" " + scoresToPrint[index]
 * + ((index < scoresToPrint.length - 1) ? "," : "")); }
 * System.out.println(stringToPrint); }
 * 
 * // is fucking stupid public static boolean higherThan(int[] scores, int
 * numToCheck) { if (numToCheck > scores[scores.length - 1]) return true; return
 * false; }
 * 
 * // returns how many numbers in the array the passed number is higher than
 * public static int higherThanInt(int[] scores, int numToCheck) { int
 * higherThanXNumbers = 0; if (numToCheck > scores[0]) return (scores.length);
 * for (int index = 0; index < scores.length; index++) { if (numToCheck >
 * scores[index]) higherThanXNumbers++; } return higherThanXNumbers; }
 * 
 * public static void insertScore(int[] scores, int numToInsert) { if
 * (higherThan(scores, numToInsert)) { int higherThanXNumbers =
 * higherThanInt(scores, numToInsert); for (int index = (scores.length - 1);
 * index > (scores.length - higherThanXNumbers); index--) { int tmpIndex = index
 * - 1; scores[index] = scores[tmpIndex]; } scores[scores.length -
 * higherThanXNumbers] = numToInsert; } } }
 */