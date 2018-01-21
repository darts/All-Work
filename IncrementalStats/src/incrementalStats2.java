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
		System.out.print("Please enter a number (or type 'exit' or 'quit'): ");
		Scanner userInputScanner = new Scanner(System.in);
		while (!finished) {
			//System.out.print("Please enter a number (or type 'exit' or 'quit'): ");
			//Scanner userInputScanner = new Scanner(System.in);

			if (userInputScanner.hasNextDouble()) {
				numberCount++;
				currentNumber = userInputScanner.nextDouble();
				prevAverage = currentAverage;
				currentAverage = currentAverage + ((currentNumber - currentAverage) / numberCount);
				variance = ((variance * (numberCount - 1))
						+ (currentNumber - prevAverage) * (currentNumber - currentAverage)) / currentNumber;
				System.out.println("So far the average is " + currentAverage + " and the variance is " + variance);
				System.out.print("Please enter another number (or type 'exit' or 'quit'): ");
			}/* else if (userInputScanner.hasNext()) {
				userInString = userInputScanner.next();
				if (userInString == "exit" || userInString == "quit") {
					finished = true;
					System.out.println("Goodbye");
					userInputScanner.close();
				} else {
					JOptionPane.showMessageDialog(null, "No numbers provided.", "Error", JOptionPane.ERROR_MESSAGE);
				}
			} else {
				System.out.print("You must enter a number. Please enter a number (or type 'exit' or 'quit'):");
			}*/
		}
	}
}
