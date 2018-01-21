/* SELF ASSESSMENT
   1. createSequence:
    Did I use the correct method definition?
    Mark out of 5:5
    Comment:The function returns a boolean array after being passed an integer n corresponding to the size of the desired array.
    Did I create an array of size n (passed as the parameter) and initialise it?
    Mark out of 5:5
    Comment:Yes, the function creates an array up to an index of n.
    Did I return the correct item?
    Mark out of 5:5
    Comment:Yes, the desired array is returned.

   2. crossOutMultiples
    Did I use the correct method definition?
    Mark out of 5:5
    Comment:Yes, it is passed an array and an integer and 'crosses out' (sets to false) multiples of that number. It does not return anything.
    Did I ensure the parameters are not null and one of them is a valid index into the array
    Mark out of 2:2
    Comment:Yes, the function checks for both of those parameters.
    Did I loop through the array using the correct multiple?
    Mark out of 5:5
    Comment:Yes, the program loops through the array using the correct multiple.
    Did I cross out correct items in the array that were not already crossed out?
    Mark out of 3:3
    Comment:Yes, non crossed out items are correctly crossed out.

   3. sieve   
    Did I have the correct function definition?
    Mark out of 5:5
    Comment:Yes, the function takes a number and returns a boolean array with all non-prime values set to false.
    Did I make calls to other methods?
    Mark out of 5:5
    Comment:Yes, the function calls the createSequence and crossOutHigherMultiples.
    Did I return an array with all non-prime numbers are crossed out?
    Mark out of 2:2
    Comment:Yes I did.

   4. sequenceTostring  
    Did I have the correct function definition?
    Mark out of 5:5
    Comment:The function takes a boolean array and converts it to a string either including or excluding crossed out numbers.
    Did I ensure the parameter to be used is not null?
    Mark out of 3:3
    Comment:Yes, the function checks that the array passed is not null.
    Did I Loop through the array updating the String variable with the non-crossed out numbers and the crossed numbers in brackets?
    Mark out of 10:10 
    Comment:Yes, the contents of the array is printed with non-prime numbers in brackets.

   5. nonCrossedOutSubseqToString  
    Did I have the correct function definition?
    Mark out of 5:5
    Comment:Yes, it takes a boolean array and returns a string of prime numbers. 
    Did I ensure the parameter to be used is not null? 
    Mark out of 3:3
    Comment:Yes as this is handled by the sequenceToString function.
    Did I loop through the array updating the String variable with just the non-crossed out numbers?
    Mark out of 5:5
    Comment:Yes that is what the function does.

   6. main  
    Did I ask  the user for input n and handles input errors? 
    Mark out of 5:5
    Comments:Yes, the user is asked for an input n and handles input errors.
    Did I make calls to other methods (at least one)?
    Mark out of 5:5
    Comment:Yes, the sieve and both seqToString functions are called.
    Did I print the output as shown in the question? 
    Mark out of 5:5
    Comment:Yes, if any changes are made to the array i.e multiples of a number are crossed out, the entire array is printed and finally the result is printed.

   7. Overall
    Is my code indented correctly?
    Mark out of 4:4
    Comments:I used the IDE's auto-indent feature.
    Do my variable names make sense?
    Mark out of 4:4
    Comments:Yes, the names make sense in their respective contexts.
    Do my variable names, method names and class name follow the Java coding standard
    Mark out of 4:4
    Comments:Yes, I followed the Java coding standard.

      Total Mark out of 100 (Add all the previous marks):100
*/

import java.util.Scanner;

public class Sieve_of_Eratosthenes2 {

	public static void main(String[] args) {
		boolean finished = false;
		Scanner userInputScanner = new Scanner(System.in);
		while (!finished) {
			System.out.print("Enter int >= 2 (or type 'quit' to exit): ");
			if (userInputScanner.hasNextInt()) {
				int maxNum = userInputScanner.nextInt();
				String clcLine = userInputScanner.nextLine();
				if (maxNum >= 2) {
					System.out.println(nonCrossedOutSubseqToString(sieve(maxNum)));
				} else {
					System.out.println("The number entered must be greater than or equal to 2");
				}
			} else if (userInputScanner.hasNext()) {
				String userInput = userInputScanner.next();
				String clcLine = userInputScanner.nextLine();
				if (userInput.equals("quit")) {
					finished = true;
				} else {
					System.out.println("Sorry, the input was not recognised.");
				}
			} else {
				System.out.println("You must enter a number or type 'quit' to exit.");
			}
		}
		userInputScanner.close();
		System.out.println("Goodbye...");
	}

	// Creates a boolean array of length: size + 1
	public static boolean[] createSequence(int size) {
		boolean[] sequence = new boolean[size + 1];
		for (int index = 0; index < sequence.length; index++) {
			sequence[index] = true;
		}
		return sequence;
	}

	// Crosses out higher multiples of a number.
	public static void crossOutHigherMultiples(boolean[] numArray, int number) {
		if (numArray != null && number != 0) {
			int arrayLength = numArray.length - 1;
			boolean changedState = false;
			for (int index = 2; (index * number) <= arrayLength; index++) {
				if (numArray[index * number] == true) {
					numArray[index * number] = false;
					changedState = true;
				}
			}
			if (changedState)
				System.out.println(sequenceToString(numArray, true));
		}
	}

	// Takes a number and returns an array of 2 -> N with non-primes as false;
	public static boolean[] sieve(int maxNum) {
		boolean[] numArray = createSequence(maxNum);
		for (int index = 2; index < numArray.length - 1; index++) {
			if (numArray[index])
				crossOutHigherMultiples(numArray, index);
		}
		return numArray;
	}

	// Takes an array and returns a string of the numbers (indices).
	public static String sequenceToString(boolean[] numArray, boolean includeCrossedOut) {
		if(numArray != null) {
		String returnString = "2";
		for (int index = 3; index < numArray.length; index++) {
			if (numArray[index]) {
				returnString += ", " + index;
			} else if (includeCrossedOut) {
				returnString += ", [" + index + "]";
			}
		}
		return returnString;
		}
		return "Null String in seqToString";
	}

	// Takes an array and returns a string of non-crossed out numbers (indices).
	public static String nonCrossedOutSubseqToString(boolean[] numArray) {
		return sequenceToString(numArray, false);
	}
}




//This was my first attempt at the program. It is fully functional. I rewrote it due to its inefficiency and because it is a very messy solution. 
/*
import java.util.Scanner;
public class Sieve_of_Eratosthenes {
	public static void main(String[] args) {
		boolean finished = false;
		Scanner userInputScanner = new Scanner(System.in);
		while (!finished) {
			System.out.print("Enter int >= 2 (or type 'quit' to exit): ");
			if (userInputScanner.hasNextInt()) {
				int maxNum = userInputScanner.nextInt();
				String clcLine = userInputScanner.nextLine();
				if (maxNum >= 2) {
					System.out.println(nonCrossedOutSubseqToString(sieve(maxNum)));
				} else {
					System.out.println("The number entered must be greater than or equal to 2");
				}
			} else if (userInputScanner.hasNext()) {
				String userInput = userInputScanner.next();
				String clcLine = userInputScanner.nextLine();
				if (userInput.equals("quit")) {
					finished = true;
				} else {
					System.out.println("Sorry, the input was not recognised.");
				}
			} else {
				System.out.println("You must enter a number or type 'quit' to exit.");
			}
		}
		userInputScanner.close();
		System.out.println("Goodbye...");
	}

	public static String[] createSequence(int maxNumber) {
		String[] numArray = new String[maxNumber - 1];
		for (int index = 0; index < maxNumber - 1; index++)
			numArray[index] = Integer.toString(index + 2);
		return numArray;
	}

	public static String sequenceToString(String[] arrayToPrint, String separator, boolean printString) {
		String stringToPrint = "";
		for (int index = 0; index < arrayToPrint.length; index++) {
			stringToPrint += arrayToPrint[index] + ((index != arrayToPrint.length - 1)?separator:"");
		}
		if(printString)
			System.out.println(stringToPrint);
		return(stringToPrint);
	}

	public static String[] convertToStringArray(int[] numArray) {
		String[] stringArray = new String[numArray.length];
		for (int index = 0; index < numArray.length; index++)
			stringArray[index] = Integer.toString(numArray[index]);
		return stringArray;
	}

	public static void crossOutHigherMultiples(String[] numArray, int numToCross, int indexOfNum) {
		for (int index = indexOfNum + 1; index < numArray.length; index++) {
			try {
				int currentNum = Integer.parseInt(numArray[index]);
				if (currentNum % numToCross == 0)
					numArray[index] = "[" + numArray[index] + "]";
			} catch (NumberFormatException e) {
			} 
		}
	}

	public static String[] sieve(int maxNum) {
		String[] numArray = createSequence(maxNum);
		for (int index = 0; index < numArray.length; index++) {
			try {
				crossOutHigherMultiples(numArray, Integer.parseInt(numArray[index]), index);
			} catch (NumberFormatException e) {
			}
		}
		//sequenceToString(numArray, ", ", true);
		return numArray;
	}

	public static String nonCrossedOutSubseqToString(String[] arrayToConvert) {
		int numberValid = 0;
		for (int index = 0; index < arrayToConvert.length; index++) {
			try {
				Integer.parseInt(arrayToConvert[index]);
				numberValid++;
			} catch (NumberFormatException e) {
			}
		}	
		String[] primeArray = new String[numberValid];
		for (int index = 0, primeArrayIndex = 0; primeArrayIndex < primeArray.length; index++) {
			try {
				primeArray[primeArrayIndex] = Integer.toString(Integer.parseInt(arrayToConvert[index]));
				primeArrayIndex++;
			} catch (NumberFormatException e) {
			} 
		}
		return sequenceToString(primeArray, ", ", false);
	}
}
*/
