import javax.swing.JOptionPane;
import java.util.Scanner;

public class incrementalStats {

	public static void main(String[] args) {
		boolean finished = false;
		double currentAverage = 0;
		double prevAverage = 0;
		double currentNumber = 0;
		double variance = 0;
		int numberCount = 0;
		String userInString = "";

		while (!finished) {
			String userInput = JOptionPane.showInputDialog(null, 
					"Please enter a number (or type 'exit' or 'quit')");
			Scanner userInputScanner = new Scanner(userInput);

			if (userInputScanner.hasNextInt()) {
				numberCount++;
				currentNumber = userInputScanner.nextInt();
				prevAverage = currentAverage;
				currentAverage = average + ((currentNumber - average) / numberCount);
				variance = ((variance * (numberCount + 1))
						+ ((currentNumber - prevAverage) * (currentNumber - average))) / currentNumber;
				System.out.println("So far the average is " + average + " and the variance is " + variance);
				
			} else if (userInputScanner.hasNext()) {
				userInString = userInputScanner.next();
				if (userInString == "exit" || userInString == "quit") {
					finished = true;
				} else {
					JOptionPane.showMessageDialog(null, 
							"No numbers provided.", "Error", JOptionPane.ERROR_MESSAGE);
				}
			}
		}
	}
}
