import java.util.Scanner;

import javax.swing.JOptionPane;

public class TutLoop {

	public static void main(String[] args) {
		String userInput = JOptionPane.showInputDialog(null, "Please enter a series of number separated by spaces:");
		Scanner inputScanner = new Scanner(userInput);
		// System.out.print("Please enter a series of number separated by spaces: ");

		int currentNumber = 0;
		int currentMax = 0;
		int currentMin = 0;

		if (inputScanner.hasNextInt()) {
			currentNumber = inputScanner.nextInt();
			currentMax = currentNumber;
			currentMin = currentNumber;

			while (inputScanner.hasNextInt()) {
				currentNumber = inputScanner.nextInt();
				if (currentNumber > currentMax)
					currentMax = currentNumber;
				if (currentNumber < currentMin)
					currentMin = currentNumber;
			}
		}
		System.out.println("The maximum number is: " + currentMax + ", and the minimum number is: " + currentMin);
	}
}
