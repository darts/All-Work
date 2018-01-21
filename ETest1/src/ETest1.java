import java.util.Scanner;

public class ETest1 {

	public static void main(String[] args) {
		boolean finished = false;
		int secondPreviousFibonacci;
		int previousFibonacci;
		int currentFibonacci;
		// int diffPrevious;
		// int diffCurrent;
		// int diffNext;
		Scanner userInputScanner = new Scanner(System.in);
		// while(!finished){
		// String userInputString;
		// secondPreviousFibonacci = 0;
		// previousFibonacci = 1;
		// currentFibonacci = 0;
		while (!finished) {
			System.out.print("What number would you like the closest Fibonacci number for (or enter 'quit'): ");
			String userInputString;
			secondPreviousFibonacci = 0;
			previousFibonacci = 1;
			currentFibonacci = 0;

			if (userInputScanner.hasNextInt()) {
				int userInput = userInputScanner.nextInt();

				int diffPrevious = Math.abs(userInput - previousFibonacci);
				int diffCurrent = Math.abs(userInput - currentFibonacci);
				int diffNext = Math.abs(userInput - (previousFibonacci + secondPreviousFibonacci));

				boolean closestFound = false;

				while (!closestFound) {

					if (diffCurrent > diffNext) {

						currentFibonacci = previousFibonacci + secondPreviousFibonacci;
						secondPreviousFibonacci = previousFibonacci;
						previousFibonacci = currentFibonacci;
						diffPrevious = Math.abs(userInput - previousFibonacci);
						diffCurrent = Math.abs(userInput - currentFibonacci);
						diffNext = Math.abs(userInput - (previousFibonacci + secondPreviousFibonacci));
					} else if (diffPrevious < diffCurrent) {
						System.out.println("The closest Fibonacci number to " + userInput + " is " + previousFibonacci);

						closestFound = true;
					} else if (diffCurrent < diffPrevious) {
						System.out.println("The closest Fibonacci number to " + userInput + " is " + currentFibonacci);
						closestFound = true;
					} 
					/*else if (diffCurrent == diffPrevious) {
						System.out.println("The closest Fibonacci numbers to " + userInput + " are " + previousFibonacci
								+ " and " + currentFibonacci);
						closestFound = true;
					}
					*/

				}
			} else {
				userInputString = userInputScanner.next();
				if (userInputString.equals("quit")) {
					finished = true;
					System.out.println("Goodbye");
				} else {
					System.out.println("'" + userInputString + "' is not a valid input!");
				}
			}
		}
	}
}
