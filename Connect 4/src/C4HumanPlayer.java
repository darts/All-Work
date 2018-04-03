import java.util.Scanner;

public class C4HumanPlayer extends ConnectPlayer {

	public C4HumanPlayer() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public int getColumn(Connect4Grid2DArray theGrid, Scanner userInputScanner) {
		boolean inputValid = false;
		while (!inputValid) {
			System.out.print("Please enter the desired column: ");
			if (userInputScanner.hasNext()) {
				if (userInputScanner.hasNextInt()) {
					int userInput = userInputScanner.nextInt();
					if (!theGrid.isColumnFull(userInput) && theGrid.isValidColumn(userInput)) {
						return userInput;
					} else
						System.out.println("The number entered must be in the range 0-" + Connect4Grid2DArray.getWidth());
				} else {
					System.out.println("Please enter a valid number");
					userInputScanner.nextLine();
				}
			}
		}
		return -1;
	}

}
