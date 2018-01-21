
/* SELF ASSESSMENT
   1. Did I use appropriate CONSTANTS instead of numbers within the code?
       Mark out of 5: 5 
       Comment: Constants were used instead of numbers where appropriate.
   2. Did I use easy-to-understand, meaningful CONSTANT names formatted correctly in UPPERCASE?
       Mark out of 5: 5
       Comment: All constants have reasonable, understandable names.
   3. Did I use easy-to-understand meaningful variable names?
       Mark out of 10: 10
       Comment: Variables names are clear.
   4. Did I format the variable names properly (in lowerCamelCase)?
       Mark out of 5: 5 
       Comment: All variables are in lowerCamelCase
   5. Did I indent the code appropriately?
       Mark out of 10: 10
       Comment: Code is indented correctly.
   6. Did I use an appropriate loop to allow the user to enter their guesses until they win or lose?
       Mark out of 20: 20
       Comment: It is possible to choose how many chances the user has and how many correct answers they need to win. 
       			The loop continues until the conditions are met.
   7. Did I check the input to ensure that invalid input was handled appropriately?
       Mark out of 10: 10  
       Comment: All invalid input is handled correctly by the system.
   8. Did I generate the cards properly using random number generation (assuming all cards are equally likely each time)?
       Mark out of 10: 10
       Comment: A random number generator with a random seed is used.
   9. Did I output the cards correctly as 2, 3, 4, ... 9, 10, Jack, Queen, King?
       Mark out of 10: 10
       Comment: Cards are output correctly.
   10. Did I report whether the user won or lost the game before the program finished?
       Mark out of 10: 10
       Comment: The user knows if they win or lose.
   11. How well did I complete this self-assessment?
       Mark out of 5: 5
       Comment: I went through it and adjusted my code to obtain more marks.
   Total Mark out of 100 (Add all the previous marks): 100
*/

import java.util.Random;
import java.util.Scanner;

public class HiLo {
	public static final int NUMBER_OF_GUESSES = 4;
	public static final int CORRECT_GUESSES_TO_WIN = 4;
	public static final int NUMBER_OF_CHANCES = 100;
	public static final int MAX_CARD_NUMBER = 13;
	public static final int MAX_NUMBER = 10;
	public static final int JACK = 10;
	public static final int QUEEN = 11;
	public static final int KING = 12;
	public static final int ACE = 13;

	public static void main(String[] args) {
		Scanner userInputScanner = new Scanner(System.in);
		int correctGuesses = 0;
		Random generator = new Random();
		int numberOfChancesLeft = NUMBER_OF_CHANCES;
		System.out.println("You must guess correctly " + CORRECT_GUESSES_TO_WIN + " in a row in order to win. You have "
				+ numberOfChancesLeft + " attempt/s.");
		int currentCard = generator.nextInt(MAX_CARD_NUMBER);
		currentCard++;
		int guessCount = 0;
		while (guessCount <= NUMBER_OF_GUESSES) {

			if (currentCard < MAX_NUMBER) {
				System.out.println("The card is a " + (currentCard + 1));
			} else if (currentCard == JACK) {
				System.out.println("The card is a Jack");
			} else if (currentCard == QUEEN) {
				System.out.println("The card is a Queen");
			} else if (currentCard == KING) {
				System.out.println("The card is a King");
			} else {
				System.out.println("The card is an Ace");
			}
			
			if (guessCount < NUMBER_OF_GUESSES && numberOfChancesLeft > 0) {

				System.out.print("Do you think the next card will be higher, lower or equal? ");
				boolean inputValid = false;
				int previousCard = currentCard;
				boolean guessedCorrectly = false;
				currentCard = generator.nextInt(MAX_CARD_NUMBER);
				currentCard++;
				
				while (!inputValid) {
					String userInput = userInputScanner.next();
					inputValid = true;
					if (userInput.equals("higher")) {
						if (previousCard < currentCard)
							guessedCorrectly = true;
					} else if (userInput.equals("lower")) {
						if (previousCard > currentCard)
							guessedCorrectly = true;
					} else if (userInput.equals("equal")) {
						if (previousCard == currentCard)
							guessedCorrectly = true;
					} else {
						inputValid = false;
						System.out.print("You must guess if the next card will be higher, lower or equal. ");
						String userInputIncorrect = userInputScanner.nextLine();
					}
				}
				
				if (guessedCorrectly) {
					System.out.print("You guessed correctly. ");
					correctGuesses++;
				} else {
					System.out.print("You guessed incorrectly. ");
					numberOfChancesLeft--;
					guessCount = -1;
					correctGuesses = 0;
					System.out.println("You have " + numberOfChancesLeft + " chance/s left.");
				}
			} else {
				guessCount = NUMBER_OF_GUESSES + 1;
			}
			guessCount++;
			
		}

		userInputScanner.close();

		if (correctGuesses == NUMBER_OF_GUESSES) {
			System.out.print("Congratulations, you won! ");
		} else {
			System.out.print("So close! Hard luck. ");
		}
	}
}

// Semi-Working version backup in case I make a balls of the above code.
/*
 * import java.util.Random; import java.util.Scanner;
 * 
 * public class HiLo { public static int NUMBER_OF_GUESSES = 4; public static
 * int MAX_CARD_NUMBER = 13; public static int MAX_NUMBER = 10; public static
 * int JACK = 9; public static int QUEEN = 10; public static int KING = 11;
 * public static int ACE = 12;
 * 
 * public static void main(String[] args) { Scanner userInputScanner = new
 * Scanner(System.in); int correctGuesses = 0; Random generator = new Random(0);
 * //Test value, change before submission int currentCard =
 * generator.nextInt(MAX_CARD_NUMBER); currentCard++; int guessCount = 0; while
 * (guessCount < NUMBER_OF_GUESSES) { guessCount++; // int currentCard =
 * generator.nextInt(MAX_CARD_NUMBER); if (currentCard <= MAX_NUMBER) {
 * System.out.println("The card is a " + currentCard); } else if (currentCard ==
 * JACK) { System.out.println("The card is a Jack"); } else if (currentCard ==
 * QUEEN) { System.out.println("The card is a Queen"); } else if (currentCard ==
 * KING) { System.out.println("The card is a King"); } else {
 * System.out.println("The card is an Ace"); }
 * 
 * System.out.
 * print("Do you think the next card will be higher, lower or equal? ");
 * 
 * // String userInput = userInputScanner.next(); boolean inputValid = false;
 * int previousCard = currentCard; boolean guessedCorrectly = false; currentCard
 * = generator.nextInt(MAX_CARD_NUMBER); currentCard++; while (!inputValid) {
 * String userInput = userInputScanner.next(); inputValid = true; if
 * (userInput.equals("higher")) { if (previousCard < currentCard)
 * guessedCorrectly = true; } else if (userInput.equals("lower")) { if
 * (previousCard > currentCard) guessedCorrectly = true; } else if
 * (userInput.equals("equal")) { if (previousCard == currentCard)
 * guessedCorrectly = true; } else { inputValid = false; System.out.
 * print("You must guess if the next card will be higher, lower or equal. "); }
 * }
 * 
 * if (guessedCorrectly) { System.out.print("You guessed correctly. ");
 * correctGuesses++; } else { System.out.print("You guessed incorrectly. "); } }
 * if (currentCard <= MAX_NUMBER) { System.out.println("The card is a " +
 * currentCard); } else if (currentCard == JACK) {
 * System.out.println("The card is a Jack"); } else if (currentCard == QUEEN) {
 * System.out.println("The card is a Queen"); } else if (currentCard == KING) {
 * System.out.println("The card is a King"); } else {
 * System.out.println("The card is an Ace"); }
 * 
 * if (correctGuesses == NUMBER_OF_GUESSES) {
 * System.out.print("Congratulations, you got them all correct! "); } else {
 * System.out.print("So close! You almost got it. "); }
 * 
 * System.out.println("You got " + correctGuesses + " out of " +
 * NUMBER_OF_GUESSES + " correct."); } }
 */
