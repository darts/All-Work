import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

public class C4RandomAIPlayer extends ConnectPlayer {

	public C4RandomAIPlayer() {
		// TODO Auto-generated constructor stub
	}

	public int getColumn(Connect4Grid2DArray theGrid, Scanner userInputScanner) {
		while (true) {
			int column = ThreadLocalRandom.current().nextInt(0, Connect4Grid2DArray.getWidth());
			if (!theGrid.isColumnFull(column) && theGrid.isValidColumn(column))
				return column;
		}
	}
}
