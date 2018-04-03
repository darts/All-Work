
public class Connect4Grid2DArray implements Connect4Grid {
	private static final int WIDTH = 7;
	private static final int HEIGHT = 6;
	private String[][] theGrid = new String[HEIGHT][WIDTH];
	private final String EMPTY = " ";
	// private final int PLAYER_ONE_PIECE = 1;
	// private final int PLAYER_TWO_PIECE = 2;
	{
		emptyGrid();
	}

	public Connect4Grid2DArray() {
	}

	public void emptyGrid() {
		for (int row = 0; row < HEIGHT; row++) {
			for (int column = 0; column < WIDTH; column++) {
				theGrid[row][column] = EMPTY;
			}
		}
	}

	@Override
	public boolean isValidColumn(int column) {
		if (column >= 0 && column < WIDTH)
			return true;
		return false;
	}

	@Override
	public boolean isColumnFull(int column) {
		if (theGrid[0][column].equals(EMPTY))
			return false;
		return true;
	}

	@Override
	public void dropPiece(ConnectPlayer player, int column) {
		if (isValidColumn(column) && !isColumnFull(column)) {
			theGrid[getNextFreeRow(column)][column] = player.getPiece();
		}
	}

	public int getNextFreeRow(int column) {
		for (int row = HEIGHT - 1; row >= 0; row--) {
			if (theGrid[row][column].equals(EMPTY))
				return row;
		}
		return -1;
	}

	@Override
	public boolean didLastPieceConnect4() {
		for (int row = 0; row < HEIGHT; row++) {
			for (int column = 0; column < WIDTH; column++) {
				if (!theGrid[row][column].equals(EMPTY)) {
					if(checkRowToRight(row, column))
						return true;
					if(checkColumn(row, column))
						return true;
					if(checkRightDiagonal(row, column))
						return true;
					if(checkLeftDiagonal(row, column))
						return true;
				}
			}
		}
		return false;
	}

	// Returns true if row to right is valid.
	private boolean checkRowToRight(int row, int column) {
		if (column <= WIDTH - 4) {
			String thisSquare = theGrid[row][column];
			for(int offset = 1; offset < 4; offset++) {
				if(!theGrid[row][column + offset].equals(thisSquare))
					return false;
			}
			return true;
		}
		return false;
	}
	
	private boolean checkColumn(int row, int column) {
		if(row <= HEIGHT - 4) {
			String thisSquare = theGrid[row][column];
			for(int offset = 1; offset < 4; offset++) {
				if(!theGrid[row + offset][column].equals(thisSquare))
					return false;
			}
			return true;
		}
		return false;
	}
	
	private boolean checkRightDiagonal(int row, int column) {
		if(row <= HEIGHT - 4 && column <= WIDTH - 4) {
			String thisSquare = theGrid[row][column];
			for(int offset = 1; offset < 4; offset++) {
				if(!theGrid[row + offset][column + offset].equals(thisSquare))
					return false;
			}
			return true;
		}
		return false;
	}
	
	private boolean checkLeftDiagonal(int row, int column) {
		if(row <= HEIGHT - 4 && column >= 3) {
			String thisSquare = theGrid[row][column];
			for(int offset = 1; offset < 4; offset++) {
				if(!theGrid[row + offset][column - offset].equals(thisSquare))
					return false;
			}
			return true;
		}
		return false;
	}

	@Override
	public boolean isGridFull() {
		for (int row = 0; row < HEIGHT; row++) {
			for (int column = 0; column < WIDTH; column++) {
				if (theGrid[row][column].equals(EMPTY))
					return false;
			}
		}
		return true;
	}

	public void printGrid() {
		for (int row = 0; row < HEIGHT; row++) {
			String printStr = "|";
			for (int column = 0; column < WIDTH; column++) {
				printStr += theGrid[row][column] + "|";
			}
			System.out.println(printStr);
		}
		String indexString = "|";
		for (int column = 0; column < WIDTH; column++) {
			indexString += column + "|";
		}
		for (int i = 0; i < indexString.length(); i++)
			System.out.print("_");
		System.out.print("\n");
		System.out.println(indexString + "\n");
	}

	public static int getWidth() {
		return WIDTH;
	}

}
