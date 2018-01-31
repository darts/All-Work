
/* SELF ASSESSMENT
   1. clearBoard:

    Did I use the correct method definition?
    Mark out of 5:5
    Comment:The function takes an array input and returns nothing.
    Did I use loops to set each position to the BLANK character?
    Mark out of 5:5
    Comment:Yes, each character is set to blank.

   2. printBoard

    Did I use the correct method definition?
    Mark out of 5:5
    Comment:The function takes an array input and returns nothing.
    Did I loop through the array and print out the board in a way that it looked like a board?
    Mark out of 5:5
    Comment:Yes, I used dashes and vertical bars to set up the board

   3. canMakeMove

    Did I have the correct function definition and returned the correct item?
    Mark out of 5:5
    Comment:The function takes a board and a location (row & column) and returns a boolean.
    Did I check if a specified location was BLANK?
    Mark out of 5:5
    Comment:Yes, it checks if a location is blank in order to determine if it is blank.

   4. makeMove

    Did I have the correct function definition?
    Mark out of 5:5
    Comment:The function takes an array, location and character and does not return anything.
    Did I set the  currentPlayerPiece in the specified location?
    Mark out of 5:5
    Comment:Yes, it places the piece in the specified location.

   5. isBoardFull

    Did I have the correct function definition and returned the correct item?
    Mark out of 5:5
    Comment:The function takes an array and returns a boolean. 
    Did I loop through the board to check if there are any BLANK characters?
    Mark out of 5:5
    Comment:I looped through the board to check if there were any blank characters.

   6. winner

    Did I have the correct function definition and returned the winning character
    Mark out of 5:5
    Comment:The function takes an array and returns a character.
    Did I identify all possible horizontal, vertical and diagonal winners 
    Mark out of 15:15
    Comment:All winning positions are accounted for.

   7.main

    Did I create a board of size 3 by 3 and use the clearBoard method to set all the positions to the BLANK character ('  ')?
    Mark out of 3:3
    Comments:A 3x3 board is created and cleared.
    Did I loop asking the user for a location until wither the board was full or there was a winner?
    Mark out of 5:5
    Comments:I looped asking the user for a location until either the board was full or there was a winner.
    Did I call all of the methods above?
    Mark out of 5:5
    Comments:Yes, all methods are called.
    Did I handle incorrect locations provided by the user (either occupied or invalid locations)?
    Mark out of 3:3
    Comments:Yes incorrect locations are safely handled.
    Did I switch the current player piece from cross to nought and vice versa after every valid move?
    Mark out of 3:3
    Comments:Yes I switched the piece after every valid move.
    Did I display the winning player piece or a draw at the end of the game?
    Mark out of 3:3
    Comments:I displayed the result of the game at the end.

   8. Overall

    Is my code indented correctly?
    Mark out of 3:3
    Comments:I used the IDE's indenting feature.
    Do my variable names and Constants (at least four of them) make sense?
    Mark out of 3:3
    Comments:All variables and constants make sense in their respective contexts.
    Do my variable names, method names and class name follow the Java coding standard
    Mark out of 2:2
    Comments:The coding standard is followed.

      Total Mark out of 100 (Add all the previous marks):100
*/

import java.util.Scanner;

public class NoughtsAndCrossed {
	public static char NOUGHTS = 'O';
	public static char CROSSES = 'X';
	public static int NUMBER_OF_ROWS = 3;
	public static int NUMBER_OF_COLUMNS = 3;

	public static void main(String[] args) {
		char[][] board = new char[NUMBER_OF_ROWS][NUMBER_OF_COLUMNS];
		clearBoard(board);
		boolean finished = false;
		Scanner userInputScanner = new Scanner(System.in);
		printBoard(board);
		int playerTurn = 0;
		boolean hasWinner = false;
		while (!finished) {
			String player = (playerTurn % 2 == 0) ? "noughts" : "crosses";
			System.out.println("It is " + player
					+ "' turn to play. \nPlease enter the desired location of your piece in the format: row column");
			if (userInputScanner.hasNextInt()) {
				int row = userInputScanner.nextInt();
				int column = -1;
				if (userInputScanner.hasNextInt())
					column = userInputScanner.nextInt();
				if (canMakeMove(board, --row, --column)) {
					makeMove(board, (playerTurn % 2 == 0) ? NOUGHTS : CROSSES, row, column);
					playerTurn++;
					printBoard(board);
					if (winner(board) != ' ') {
						System.out.print("The winner is " + player + ".");
						finished = true;
						hasWinner = true;
					}
					if (isBoardFull(board))
						finished = true;
				} else {
					System.out.println("Sorry, you can't do that.");
				}
			} else {
				System.out.print("Please enter the desired location of your piece in the format: row column");
			}
			String garbage = userInputScanner.nextLine();
		}
		if (!hasWinner)
			System.out.println("The game is a draw.");
	}

	public static void clearBoard(char[][] board) {
		for (int row = 0; row < NUMBER_OF_ROWS; row++) {
			for (int column = 0; column < NUMBER_OF_COLUMNS; column++) {
				board[row][column] = ' ';
			}
		}
	}

	public static void printBoard(char[][] board) {
		System.out.println(" 1 2 3");
		for (int row = 0; row < NUMBER_OF_ROWS; row++) {
			String output = "|";
			for (int column = 0; column < NUMBER_OF_COLUMNS; column++) {
				output += (board[row][column]) + "|";
			}
			System.out.println(output + (row + 1));
			if (row >= 0 && row < 2)
				System.out.println("–––––––");
		}
	}

	public static boolean canMakeMove(char[][] board, int row, int column) {
		if (row >= 0 && row < 3 && column >= 0 && column < 3) {
			if (board[row][column] != ' ')
				return false;
			return true;
		}
		return false;
	}

	public static void makeMove(char[][] board, char currentPlayerPiece, int row, int column) {
		board[row][column] = currentPlayerPiece;
	}

	public static boolean isBoardFull(char[][] board) {
		for (int row = 0; row < NUMBER_OF_ROWS; row++) {
			for (int column = 0; column < NUMBER_OF_COLUMNS; column++) {
				if (board[row][column] == ' ')
					return false;
			}
		}
		return true;
	}

	public static char winner(char[][] board) {
		for (int row = 0; row < NUMBER_OF_ROWS; row++) {
			char prevChar = board[row][0];
			boolean hasWinner = true;
			for (int column = 0; column < NUMBER_OF_COLUMNS; column++) {
				if (board[row][column] != prevChar)
					hasWinner = false;
			}
			if (hasWinner && prevChar != ' ')
				return prevChar;
		}

		for (int column = 0; column < NUMBER_OF_ROWS; column++) {
			char prevChar = board[0][column];
			boolean hasWinner = true;
			for (int row = 0; row < NUMBER_OF_COLUMNS; row++) {
				if (board[row][column] != prevChar)
					hasWinner = false;
			}
			if (hasWinner && prevChar != ' ')
				return prevChar;
		}

		char prevChar = board[0][0];
		boolean hasWinner = true;
		for (int index = 0; index < NUMBER_OF_ROWS; index++) {
			if (board[index][index] != prevChar)
				hasWinner = false;
		}

		if (hasWinner && prevChar != ' ')
			return prevChar;

		if (board[0][2] == board[1][1] && board[0][2] == board[2][0] && board[0][2] != ' ')
			return board[0][2];

		return ' ';
	}
}
