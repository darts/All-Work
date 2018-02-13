/* SELF ASSESSMENT

1. ResolveBet

    I have correctly defined ResolveBet which takes the bet type (String) and the Wallet object, and a void return type [Mark out of 7:7].
    Comment:Yes, the function takes a bet type in the form of a string, a wallet object and a Scanner object as trying to get 2 scanners to point at the 
    same input didn't work. The function has return type void. 
    My program presents the amount of cash in the wallet and asks the user how much he/she would like to bet [Mark out of 8:8].
    Comment:Yes, it displays the amount of cash in the wallet before and after each bet. It also asks the user how much they would like to bet.
    My program ensures the bet amount is not greater than the cash in the wallet [Mark out of 5:5].
    Comment:Yes, it checks that the bet amount is less than or equal to the cash in the wallet.
    My program creates three Dice objects, rolls them and creates a total variable with a summation of the roll values returned [Mark out of 15:15]..
    Comment:Yes, three dice are created and added to an array where the sum of the faces is gotten as well as the top face of each in order to determine the score type; 
    My program determines the winnings by comparing the bet type with the total and comparing the bet type with the dice faces for the triple bet [Mark out of 20:20].
    Comment:Yes, my program checks what type of bet was rolled and compares that with the user's bet. It also calculates the appropriate payout.
    My program outputs the results (win or loss) and adds the winnings to the wallet if user wins or removes the bet amount from the wallet if the user loses [Mark out of 10:10].
    Comment:Yes, the outcome is displayed and the winnings (if any) are added to the wallet. The bet amount is subtracted from the wallet before the dice are rolled.


2. Main

    I ask the user for the amount of cash he/she has, create a Wallet object and put this cash into it [Mark out of 15:15]
    Comment:Yes, the user is asked for the amount of cash they would like to put into their wallet and this amount is then added to the wallet.
    My program loops continuously until the user either enters quit or the cash in the wallet is 0 [Mark out of 5:5]
    Comment:Yes, my program loops until the user enters the quit command ('cashout') to cash out or the amount of cash in the wallet is 0.
    I ask the user to enter any of the four bet types or quit [Mark out of 5:5].
    Comment:Yes the user is asked to enter any of the four bet types or the quit command.
    My program calls resolveBet for each bet type entered [Mark out of 5:5].
    Comment:Yes, the function is called every time a bet is entered.
    At the end of the game my program presents a summary message regarding winnings and losses [Mark out of 5: ]
    Comment:Yes, the program displays the amount of cash the player started with and how much they finished with. It prints the percentage change in cash of the player.


 Total Mark out of 100 (Add all the previous marks):100
*/

import java.util.Scanner;

public class ChucALuck {
	public static final int NUMBER_OF_DICE = 3;// Number of dice in the game.
	public static final int NUMBER_OF_SIDES = 6;// Number of sides on each die.
	public static final int LOSS = 0;
	public static final int TRIPLE = 1;
	public static final int FIELD = 2;
	public static final int HIGH = 3;
	public static final int LOW = 4;
	public static final int TRIPLE_PAYOUT = 30;
	public static final int NORMAL_PAYOUT = 1;

	public static void main(String[] args) {
		Boolean walletSetup = false;
		Wallet userWallet = new Wallet();
		Scanner inputScanner = new Scanner(System.in);
		boolean stillPlaying = true;
		double initAmount = 0;
		while (stillPlaying) {
			if (!walletSetup) {
				System.out.print("How much money (in $) would you like to put in your wallet? ");
				if (inputScanner.hasNextDouble()) {
					initAmount = inputScanner.nextDouble();
					if (initAmount > 0) {
						userWallet.put(initAmount);
						walletSetup = true;
					} else {
						System.out.println("Please enter an amount greater than 0.");
					}
				} else {
					System.out.println("Please enter a valid number greater than 0.");
					inputScanner.nextLine();
				}
			} else {
				if (userWallet.check() > 0) {
					System.out.print("Please enter your bet type (triple, field, high, low) or type 'cashout' to cash out: ");
					if (inputScanner.hasNext()) {
						String userBet = inputScanner.next();
						if (userBet.equals("cashout")) {
							stillPlaying = false;
							System.out.println("You started with $" + initAmount + " and finished with $" + userWallet.check() + ".");
							System.out.print(winLossPercent(initAmount, userWallet.check()));
						} else {
							if (ResolveBetType(userBet) != -1) {
								ResolveBet(userBet, userWallet, inputScanner);
								System.out.println("Your balance is $" + userWallet.check());
							} else {
								System.out.println("This is not a valid bet.");
							}
							inputScanner.nextLine();
						}
					} else {
						System.out.println("Please enter a valid bet.");
					}
				} else {
					System.out.println("This isn't a charity, you can't play without coin. Goodbye.");
					stillPlaying = false;
				}
			}
		}
		inputScanner.close();

	}

	public static void ResolveBet(String betType, Wallet userWallet, Scanner userInputScanner) {
		boolean betValid = false;
		while (!betValid) {
			System.out.print("Your balance is: $" + userWallet.check() + ", how much would you like to bet? ");
			if (userInputScanner.hasNextDouble()) {
				double amountBet = userInputScanner.nextDouble();
				if (userWallet.get(amountBet)) {
					ResolveScore(ScoreType(NUMBER_OF_DICE), amountBet, userWallet, ResolveBetType(betType));
					betValid = true;
				} else
					System.out.println("Insufficient funds.");
			} else {
				System.out.println("Please enter a valid number.");
				userInputScanner.next();
			}
		}
	}

	// Creates and rolls a number of dice and returns the nature of the score.
	// Returns -1 if number of dice is below 0.
	public static int ScoreType(int numOfDice) {
		if (numOfDice > 0) {
			Dice[] diceArray = new Dice[numOfDice];
			int sumRolled = 0;
			boolean sameFace = true;
			for (int index = 0; index < numOfDice; index++) {
				diceArray[index] = new Dice(NUMBER_OF_SIDES);
				sumRolled += diceArray[index].topFace();
				if (index - 1 >= 0) {
					if (diceArray[index].topFace() != diceArray[index - 1].topFace())
						sameFace = false;
				}
			}
			if (sumRolled < 11 && !sameFace && sumRolled / numOfDice != 1 && sumRolled / numOfDice != 2
					&& sumRolled / numOfDice != 3)
				return LOW;
			if (sumRolled > 10 && !sameFace && sumRolled / numOfDice != 4 && sumRolled / numOfDice != 5
					&& sumRolled / numOfDice != 6)
				return HIGH;
			if (sumRolled < 8 || sumRolled > 12)
				return FIELD;
			if (sameFace && sumRolled / numOfDice != 1 && sumRolled / numOfDice != 6)
				return TRIPLE;
			return LOSS;
		}
		return -1;
	}

	public static void ResolveScore(int scoreType, double amountBet, Wallet userWallet, int playerBet) {
		String score = "";
		int returnMultiplier = 0;
		switch (scoreType) {
		case LOSS:
			score = "The house wins.";
			break;
		case TRIPLE:
			score = "You rolled a Triple.";
			returnMultiplier = TRIPLE_PAYOUT + 1;
			break;
		case FIELD:
			score = "You rolled a Field.";
			returnMultiplier = NORMAL_PAYOUT + 1;
			break;
		case HIGH:
			score = "You rolled a High.";
			returnMultiplier = NORMAL_PAYOUT + 1;
			break;
		case LOW:
			score = "You rolled a Low.";
			returnMultiplier = NORMAL_PAYOUT + 1;
			break;
		}
		if (scoreType == playerBet && scoreType != LOSS) {
			System.out.println(score + " You win!");
			userWallet.put(amountBet * returnMultiplier);
		} else {
			if (scoreType != 0)
				score += " The house wins.";
			System.out.println(score);
		}
	}

	// Returns an integer of the betType. Returns -1 if input is invalid.
	public static int ResolveBetType(String userInput) {
		if (userInput.equals("triple"))
			return TRIPLE;
		if (userInput.equals("field"))
			return FIELD;
		if (userInput.equals("high"))
			return HIGH;
		if (userInput.equals("low"))
			return LOW;
		return -1;
	}
	
	public static String winLossPercent(double startAmount, double finalAmount) {
		if(startAmount > finalAmount) {
			return "You lost ~%" + (int)((startAmount - finalAmount) / startAmount);
		}else if(startAmount < finalAmount){
			return "You gained ~%" + (int)((finalAmount - startAmount) / startAmount);
		}
		return "You broke even.";
	}
}

// import java.util.Scanner;
// import javax.swing.JOptionPane;
//
// public class ChucALuck {
// public static final int NUMBER_OF_DICE = 3;// Number of dice in the game.
// public static final int NUMBER_OF_SIDES = 6;// Number of sides on each die.
// public static final int LOSS = 0;
// public static final int TRIPLE = 1;
// public static final int FIELD = 2;
// public static final int HIGH = 3;
// public static final int LOW = 4;
// public static final int TRIPLE_PAYOUT = 30;
// public static final int NORMAL_PAYOUT = 1;
//
// public static void main(String[] args) {
// Boolean walletSetup = false;
// Wallet userWallet = new Wallet();
// String userQuestion ;
// Scanner inputScanner;
// boolean stillPlaying = true;
// while (stillPlaying) {
// if (!walletSetup) {
// userQuestion = JOptionPane.showInputDialog("How much money (in $) would you
// like to put in your wallet? ");
// inputScanner = new Scanner(userQuestion);
// if (inputScanner.hasNextDouble()) {
// double addAmount = inputScanner.nextDouble();
// if (addAmount > 0) {
// userWallet.put(addAmount);
// walletSetup = true;
// } else {
// JOptionPane.showMessageDialog(null, "Please enter an amount greater than
// 0.");
// }
// } else {
// JOptionPane.showMessageDialog(null, "Please enter a valid number greater than
// 0.");
// }
// } else {
// userQuestion = JOptionPane.showInputDialog("Please enter your bet type
// (triple, field, high, low): ");
// inputScanner = new Scanner(userQuestion);
// if (inputScanner.hasNext()) {
// String userBet = inputScanner.next().toLowerCase();
// if (ResolveBetType(userBet) != -1) {
// ResolveBet(userBet, userWallet);
// JOptionPane.showMessageDialog(null, "Your balance is $" +
// userWallet.check());
// } else {
// JOptionPane.showMessageDialog(null, "This is not a valid bet.");
// }
// }else {
// System.out.println("Fuck.");
// }
// }
// }
// }
//
// public static void ResolveBet(String betType, Wallet userWallet) {
// String userQuestion;
// Scanner userInputScanner;
// boolean betValid = false;
// while (!betValid) {
// userQuestion = JOptionPane.showInputDialog("Your balance is: $" +
// userWallet.check() + ", how much would you like to bet? ");
// userInputScanner = new Scanner(userQuestion);
// if (userInputScanner.hasNextDouble()) {
// double amountBet = userInputScanner.nextDouble();
// if (userWallet.get(amountBet)) {
// ResolveScore(ScoreType(NUMBER_OF_DICE), amountBet, userWallet,
// ResolveBetType(betType));
// betValid = true;
// } else
// JOptionPane.showMessageDialog(null, "Insufficient funds.");
// } else {
// JOptionPane.showMessageDialog(null, "Please enter a valid number.");
// }
// }
// }
//
// // Creates and rolls a number of dice and returns the nature of the score.
// // Returns -1 if number of dice is below 0.
// public static int ScoreType(int numOfDice) {
// if (numOfDice > 0) {
// Dice[] diceArray = new Dice[numOfDice];
// int sumRolled = 0;
// boolean sameFace = true;
// for (int index = 0; index < numOfDice; index++) {
// diceArray[index] = new Dice(NUMBER_OF_SIDES);
// sumRolled += diceArray[index].topFace();
// if (index - 1 >= 0) {
// if (diceArray[index].topFace() != diceArray[index - 1].topFace())
// sameFace = false;
// }
// }
// System.out.println(sumRolled);
// if (sumRolled < 11 && !sameFace && sumRolled / numOfDice != 1 && sumRolled /
// numOfDice != 2
// && sumRolled / numOfDice != 3)
// return LOW;
// if (sumRolled > 10 && !sameFace && sumRolled / numOfDice != 4 && sumRolled /
// numOfDice != 5
// && sumRolled / numOfDice != 6)
// return HIGH;
// if (sumRolled < 8 || sumRolled > 12)
// return FIELD;
// if (sameFace && sumRolled / numOfDice != 1 && sumRolled / numOfDice != 6)
// return TRIPLE;
// return LOSS;
// }
// return -1;
// }
//
// public static void ResolveScore(int scoreType, double amountBet, Wallet
// userWallet, int playerBet) {
// String score = "";
// int returnMultiplier = 0;
// switch (scoreType) {
// case LOSS:
// score = "The house wins.";
// break;
// case TRIPLE:
// score = "You rolled a Triple.";
// returnMultiplier = TRIPLE_PAYOUT + 1;
// break;
// case FIELD:
// score = "You rolled a Field.";
// returnMultiplier = NORMAL_PAYOUT + 1;
// break;
// case HIGH:
// score = "You rolled a High.";
// returnMultiplier = NORMAL_PAYOUT + 1;
// break;
// case LOW:
// score = "You rolled a Low.";
// returnMultiplier = NORMAL_PAYOUT + 1;
// break;
// }
// if (scoreType == playerBet && scoreType != LOSS) {
// JOptionPane.showMessageDialog(null, score + " You win!");
// userWallet.put(amountBet * returnMultiplier);
// } else {
// if (scoreType != 0)
// score += " The house wins.";
// JOptionPane.showMessageDialog(null, score);
// }
// }
//
// // Returns an integer of the betType. Returns -1 if input is invalid.
// public static int ResolveBetType(String userInput) {
// if (userInput.equals("triple"))
// return TRIPLE;
// if (userInput.equals("field"))
// return FIELD;
// if (userInput.equals("high"))
// return HIGH;
// if (userInput.equals("low"))
// return LOW;
// return -1;
// }
// }
