/* SELF ASSESSMENT

 1. Did I use easy-to-understand meaningful variable names formatted properly (in lowerCamelCase)?

        Mark out of 5:5  Yes, all variables are easy to understand and meaningful in their context. 

 2. Did I indent the code appropriately?

       Mark out of 5:5 Yes, I used the IDE's auto-indent function. 

 3. Did I write the createCipher function correctly (parameters, return type and function body) and invoke it correctly?

       Mark out of 20:20 Yes, the function is passed an array and scrambles the characters in the array. It does not return anything. 

 4. Did I write the encrypt function correctly (parameters, return type and function body) and invoke it correctly?

       Mark out of 20:20 Yes, the function takes the data to encrypt, a cipher array and the original array. It then scrambles the data.

 5. Did I write the decrypt function correctly (parameters, return type and function body) and invoke it correctly?

       Mark out of 20:20 Yes, the function calls the encrypt function, swapping the cipher and original array in order to return the correct result. 

 6. Did I write the main function body correctly (repeatedly obtaining a string and encrypting it and then decrypting the encrypted version)?

       Mark out of 25:25 Yes, the program continues to take an input from the user and encrypts and decrypts each input.

 7. How well did I complete this self-assessment?

        Mark out of 5:5 I graded my code and justified the grade.

 Total Mark out of 100 (Add all the previous marks):100

*/ 

import java.util.Scanner;
import java.util.Random;

public class encrypt {
	public static final char[] ORIGINAL_ARRAY_LOWER_CASE = { ' ', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k',
			'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z' };
	public static final char[] ORIGINAL_ARRAY_UPPER_AND_LOWER_CASE = { ' ', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i',
			'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', 'A', 'B', 'C', 'D',
			'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y',
			'Z' };
	public static final boolean USE_UPPER_CASE = true; // Set as true to use upper case letters too.

	public static void main(String[] args) {
		char originalArray[] = (USE_UPPER_CASE == false) ? (ORIGINAL_ARRAY_LOWER_CASE)
				: (ORIGINAL_ARRAY_UPPER_AND_LOWER_CASE);
		boolean finished = false;
		char cipherArray[] = new char[originalArray.length];
		resetCipher(cipherArray, originalArray);
		createCipher(cipherArray);
		Scanner userInputScanner = new Scanner(System.in);
		System.out.println(
				"This program can only use alphabetic characters i.e. 'a' - 'z' and ' ' (space). Phrases entered that contain other characters will be rejected.");
		while (!finished) {
			System.out.print("Please enter the phrase you would like to encrypt (or type '?quit' to exit): ");
			boolean hasValidInput = false;
			String userInputString = null;
			while (!hasValidInput) {
				userInputString = userInputScanner.nextLine();
				if (!userInputString.equals("")) {
					if (userInputString.equals("?quit")) {
						finished = true;
						hasValidInput = true;
					}
					if (USE_UPPER_CASE == false)
						userInputString = userInputString.toLowerCase();
					if (inputIsValid(userInputString.toCharArray(), originalArray) && !finished) {
						hasValidInput = true;
					} else if (!inputIsValid(userInputString.toCharArray(), originalArray) && !finished)
						System.out.print(
								"You did not enter a valid phrase, only characters 'a' - 'z' and ' 'space are allowed: ");
				} else {
					System.out.print(
							"You did not enter a phrase. \nPlease enter the phrase you would like to encrypt (or type '?quit' to exit): ");
				}
			}
			if (!finished) {
				char[] userInput = userInputString.toCharArray();
				encrypt(userInput, cipherArray, originalArray);
				printArray(userInput, "");
				decrypt(userInput, cipherArray, originalArray);
				printArray(userInput, "");
			}
		}
		userInputScanner.close();
		System.out.println("Goodbye...");
	}

	// Checks if all the elements in one array are in another.
	public static boolean inputIsValid(char[] inputArray, char[] arrayToMatch) {
		for (int index = 0; index < inputArray.length; index++) {
			for (int matchIndex = 0; matchIndex < arrayToMatch.length; matchIndex++) {
				if (matchIndex == arrayToMatch.length - 1 && inputArray[index] != arrayToMatch[matchIndex])
					return false;
				if (inputArray[index] == arrayToMatch[matchIndex])
					matchIndex = arrayToMatch.length;
			}
		}
		return true;
	}

	// Encrypts an array using a cipher array.
	public static void encrypt(char[] dataToEncrypt, char[] cipherArray, char[] matchArray) {
		for (int index = 0; index < dataToEncrypt.length; index++) {
			dataToEncrypt[index] = cipherComplement(dataToEncrypt[index], cipherArray, matchArray);
		}
	}

	// Decrypts an array using a cipher array.
	public static void decrypt(char[] dataToDecrypt, char[] cipherArray, char[] matchArray) {
		encrypt(dataToDecrypt, matchArray, cipherArray);
	}

	// Prints an array.
	public static void printArray(char[] arrayToPrint, String separator) {
		String stringToPrint = "";
		for (int index = 0; index < arrayToPrint.length; index++) {
			stringToPrint += arrayToPrint[index] + separator;
		}
		System.out.println(stringToPrint);
	}

	// Sets all elements of an array to another.
	public static void resetCipher(char[] cipherArray, char[] arrayToMatch) {
		for (int index = 0; index < arrayToMatch.length; index++) {
			cipherArray[index] = arrayToMatch[index];
		}
	}

	// Scrambles an array to create a cipher.
	public static void createCipher(char[] arrayToScramble) {
		Random generator = new Random();
		for (int index = 0; index < arrayToScramble.length; index++) {
			int newIndex = generator.nextInt(arrayToScramble.length - 1);
			char valueToSwap = arrayToScramble[index];
			arrayToScramble[index] = arrayToScramble[newIndex];
			arrayToScramble[newIndex] = valueToSwap;
		}

	}

	// Returns the complementary cipher-character.
	// Returns $ if digit is not in second array. I.e. there is no match.
	public static char cipherComplement(char charToMatch, char[] cipherArray, char[] matchArray) {
		for (int index = 0; index < matchArray.length; index++) {
			if (charToMatch == matchArray[index]) {
				return (cipherArray[index]);
			}
		}
		return '$';
	}
}

/*
 * import java.util.Scanner; import java.util.Random;
 * 
 * public class encrypt { public static final char[] originalArrayLowerCase = {
 * ' ', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n',
 * 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z' }; public static
 * final char[] originalArrayUpperAndLowerCase = {' ', 'a', 'b', 'c', 'd', 'e',
 * 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't',
 * 'u', 'v', 'w', 'x', 'y', 'z', 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I',
 * 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X',
 * 'Y', 'Z'};
 * 
 * 
 * public static void main(String[] args) { boolean finished = false; Scanner
 * userInputScanner = new Scanner(System.in); while(!finished) { char[]
 * inputArray = (userInputScanner.next()).toCharArray(); printArray(inputArray);
 * char[] cipherArray = originalArrayLowerCase; createCipher(cipherArray);
 * printArray(cipherArray); //inputArray = encrypt(inputArray, cipherArray);
 * printArray(inputArray); System.out.println(encrypt(inputArray, cipherArray));
 * encrypt(inputArray, originalArrayLowerCase); printArray(inputArray); } }
 * 
 * public static String encrypt(char[] dataToEncrypt, char[] cipherArray) { if
 * (dataToEncrypt != null) { for (int index = 0; index < dataToEncrypt.length;
 * index++) { dataToEncrypt[index] = cipherComplement(dataToEncrypt[index],
 * cipherArray, originalArrayLowerCase); } return dataToEncrypt.toString(); }
 * return "Error, null input"; }
 * 
 * public static void printArray(char[] arrayToPrint) { String stringToPrint =
 * ""; for (int index = 0; index < arrayToPrint.length; index++) { stringToPrint
 * += arrayToPrint[index] + " "; } System.out.println(stringToPrint); }
 * 
 * public static void resetCipher(char[] cipherArray) { cipherArray =
 * originalArrayLowerCase; }
 * 
 * public static void createCipher(char[] arrayToScramble) { Random generator =
 * new Random(); for (int index = 0; index < arrayToScramble.length; index++) {
 * int newIndex = generator.nextInt(arrayToScramble.length - 1); char
 * valueToSwap = arrayToScramble[index]; arrayToScramble[index] =
 * arrayToScramble[newIndex]; arrayToScramble[newIndex] = valueToSwap; }
 * 
 * }
 * 
 * //Returns the complementary cipher-character. //Returns $ if digit is not in
 * second array. Ie there is no match. public static char cipherComplement(char
 * charToMatch, char[] cipherArray, char[] matchArray) { for(int index = 0;
 * index < matchArray.length; index++) {
 * if(String.valueOf(charToMatch).equals(String.valueOf(matchArray[index])))
 * return cipherArray[index]; } return '$'; } }
 */