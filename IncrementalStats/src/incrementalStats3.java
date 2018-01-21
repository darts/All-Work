/* SELF ASSESSMENT
   1. Did I use easy-to-understand meaningful variable names?
       Mark out of 10: 10, all variables are clear.
   2. Did I format the variable names properly (in lowerCamelCase)?
       Mark out of 5: 5, all are lower camel case.
   3. Did I indent the code appropriately?
       Mark out of 10: 10, code is indented correctly. 
   4. Did I input the numbers one at a time from the command line?
       Mark out of 10: 10, the system will only read the first number.
   5. Did I check the input to ensure that invalid input was handled appropriately?
       Mark out of 10: 10, all invalid input is handled.
   6. Did I use an appropriate while or do-while loop to allow the user to enter numbers until they entered exit/quit?
       Mark out of 20: 20, an appropriate loop is used.
   7. Did I implement the loop body correctly so that the average and variance were updated and output appropriately?
       Mark out of 30: 30, the values were calculated correctly and the result displayed.
   8. How well did I complete this self-assessment?
       Mark out of 5: 5, I went through the assessment and when I found issues I modified my code to meet the requirements.
   Total Mark out of 100 (Add all the previous marks): 100
*/

import java.util.Scanner;

public class incrementalStats3 {

	public static void main(String[] args) {
		boolean finished = false;
		double currentAverage = 0;
		double currentNumber = 0;
		double variance = 0;
		int numberCount = 0;
		Scanner userInputScanner = new Scanner(System.in);
		while (!finished) {
			System.out.print("Please enter a number (or type 'exit' or 'quit'): ");
			String userInputString = null;
			if (userInputScanner.hasNextDouble()) {
				double prevAverage;
				numberCount++;
				currentNumber = userInputScanner.nextDouble();
				prevAverage = currentAverage;
				currentAverage = currentAverage + ((currentNumber - currentAverage) / numberCount);
				variance = ((variance * (numberCount - 1))
						+ (currentNumber - prevAverage) * (currentNumber - currentAverage)) / numberCount;
				System.out.println("So far the average is " + currentAverage + " and the variance is " + variance);
				userInputString = userInputScanner.nextLine();
			} else {
				userInputString = userInputScanner.nextLine();
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
