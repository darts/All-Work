import java.util.Random;
import javax.swing.JOptionPane;

public class coinToss {
	public static final int NUMBER_OF_TOSSES = 100000000;
	public static final int NUMBER_OF_SIDES = 2;
	public static final int TAILS = 0;
	public static final int HEADS = 1;
	
	public static void main(String[] args) {
		Random generator = new Random();
		int numberOfHeads = 0;
		int numberOfTails = 0;
		int lastToss = -1;
		String lastTossOut = "";
		
		for(int tossCount = 0; tossCount < NUMBER_OF_TOSSES; tossCount++) {
			lastToss = generator.nextInt(NUMBER_OF_SIDES);
			if(lastToss == TAILS) {
				numberOfTails++;
				lastTossOut = "tails.";
			}else{
				numberOfHeads++;
				lastTossOut = "heads.";
			}
		}
		
		JOptionPane.showMessageDialog(null, "In " + NUMBER_OF_TOSSES +
				" tosses, the system recorded " + numberOfHeads + " heads and " + 
				numberOfTails + " tails. The last toss was " + lastTossOut);
	}
}
