import java.util.Scanner;

public abstract class ConnectPlayer {

	//abstract void dropPiece(int column);
	public String piece;
	
	public abstract int getColumn(Connect4Grid2DArray theGrid, Scanner userInputScanner);
	
	public String getPiece() {
		return piece;
	}
	
	public void setPiece(String piece) {
		this.piece = piece; 
	}
}
