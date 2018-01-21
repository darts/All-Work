
import java.util.Scanner;

public class incrementalStats2 {

	public static void main(String[] args) {
		boolean finished = false;
		double currentAverage = 0;
		double prevAverage = 0;
		double currentNumber = 0;
		double variance = 0;
		int numberCount = 0;
		String userInputString = null;
		Scanner userInputScanner = new Scanner(System.in);
		while (!finished) {
			System.out.print("Please enter a number (or type 'exit' or 'quit'): ");

			if (userInputScanner.hasNextDouble()) {
				numberCount++;
				currentNumber = userInputScanner.nextDouble();
				prevAverage = currentAverage;
				currentAverage = currentAverage + ((currentNumber - currentAverage) / numberCount);
				variance = ((variance * (numberCount - 1))
						+ (currentNumber - prevAverage) * (currentNumber - currentAverage)) / numberCount;
				System.out.println("So far the average is " + currentAverage + " and the variance is " + variance);

			} else {
				userInputString = userInputScanner.next();
				if (userInputString.equals("exit") || userInputString.equals("quit")) {
					finished = true;
					System.out.println("Goodbye.");
					userInputScanner.close();
				} else {
					System.out.println("'" + userInputString
							+ "' is not a recognised input. You must enter a number or 'quit' or 'exit'.");
				}
			}
		}
	}
}
