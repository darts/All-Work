
/* SELF ASSESSMENT

Connect4Game class (35 marks) 35
My class creates references to the Connect 4 Grid and two Connect 4 Players. It asks the user whether he/she would like 
to play/quit inside a loop. If the user decides to play then: 
1. Connect4Grid2DArray is created using the Connect4Grid interface, 
2. the two players are initialised - must specify the type to be ConnectPlayer, and 
3. the game starts. In the game, I ask the user where he/she would like to drop the piece. 
I perform checks by calling methods in the Connect4Grid interface. Finally a check is performed to determine a win.
Comment: The class creates a grid and 2 players, it asks the user/s how many ai players there should be. It asks the user 
to play/quit in a loop. If the user decides to play then the game starts with each player being asked to place a piece. After
each piece is placed the game checks if the grid is full and if someone won. 

Connect4Grid interface (10 marks) 10
I define all 7 methods within this interface.
Comment: All 7 methods are defined in this interface.

Connect4Grid2DArray class (25 marks) 25
My class implements the Connect4Grid interface. 
It creates a grid using a 2D array Implementation of the method to check whether the column to drop the piece is valid.
It provides as implementation of the method to check whether the column to drop the piece is full.
It provides as implementation of the method to drop the piece.
It provides as implementation of the method to check whether there is a win.
Comment:The class implements the interface. It creates a 2D array of strings. It implements a method to check if the 
column to drop the piece is valid. It implements a method to check if the column to drop the piece is full. It implements 
a method to drop the piece. It implements a method to check if there is a win.

ConnectPlayer abstract class (10 marks) 10
My class provides at lest one non-abstract method and at least one abstract method.
Comment: The class has one abstract and 2 non-abstract methods.

C4HumanPlayer class (10 marks) 10
My class extends the ConnectPlayer class and overrides the abstract method(s). It provides the Human player functionality.
Comment: The class extends the ConnectPlayer class and overrides the abstract methods. It provides all the required functionality.

C4RandomAIPlayer class (10 marks) 10
My class extends the ConnectPlayer class and overrides the abstract method(s). It provides AI player functionality.
Comment:The class extends connectPlayer and overrides the abstract methods. It provides all the required functionality.

Total Marks out of 100: 100

*/

import java.util.Scanner;

public class Connect4Game {
	private final String PLAYER_ONE_PIECE = "O";
	private final String PLAYER_TWO_PIECE = "T";

	public static void main(String[] args) {
		Connect4Game theGame = new Connect4Game();
		theGame.play();
	}

	Connect4Grid2DArray theGrid;
	ConnectPlayer playerOne;
	ConnectPlayer playerTwo;
	Scanner userInputScanner;

	public Connect4Game() {
		userInputScanner = new Scanner(System.in);
		setupGame();
	}

	private void setupGame() {
		theGrid = new Connect4Grid2DArray();
		setupUsers();
	}

	public void play() {
		boolean gameOver = false;
		while (!gameOver && !theGrid.isGridFull() && !theGrid.didLastPieceConnect4()) {
			theGrid.dropPiece(playerOne, playerOne.getColumn(theGrid, userInputScanner));
			theGrid.printGrid();
			if (!theGrid.isGridFull() && !theGrid.didLastPieceConnect4()) {
				theGrid.dropPiece(playerTwo, playerTwo.getColumn(theGrid, userInputScanner));
				theGrid.printGrid();
			}
		}
		System.out.print("Game Over. Play again? (yes/no) \n >");
		if (userInputScanner.hasNext()) {
			String userInput = userInputScanner.next();
			if (userInput.equals("yes")) {
				this.setupGame();
				this.play();
			} else {
				System.out.println("Goodbye...");
			}
		}

	}

	public void setupUsers() {
		boolean usersSetup = false;
		int numberOfAIPlayers = 0;
		while (!usersSetup) {
			System.out.print("Please enter the number of AI players: ");
			if (userInputScanner.hasNext()) {
				if (userInputScanner.hasNextInt()) {
					numberOfAIPlayers = userInputScanner.nextInt();
					if (numberOfAIPlayers >= 0 && numberOfAIPlayers <= 2) {
						usersSetup = true;
					} else {
						System.out.print("The number entered must be between 0-2");
					}
				} else {
					System.out.print("Please enter a number between 0-2");
				}
			}
		}
		switch (numberOfAIPlayers) {
		case 1:
			playerOne = new C4HumanPlayer();
			playerTwo = new C4RandomAIPlayer();
			System.out.println("Player 1 is human, Player 2 is AI.");
			break;
		case 2:
			playerOne = new C4RandomAIPlayer();
			playerTwo = new C4RandomAIPlayer();
			System.out.println("Player 1 is AI, Player 2 is AI, this will be a short game.");
			break;
		default:
			playerOne = new C4HumanPlayer();
			playerTwo = new C4HumanPlayer();
			System.out.println("Player 1 is human, Player 2 is human.");
		}
		playerOne.setPiece(PLAYER_ONE_PIECE);
		System.out.println("Player one's piece is: " + playerOne.getPiece());
		playerTwo.setPiece(PLAYER_TWO_PIECE);
		System.out.println("Player two's piece is: " + playerTwo.getPiece() + "\n");
		theGrid.printGrid();
	}

}
