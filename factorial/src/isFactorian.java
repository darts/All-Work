import java.util.Scanner;

public class isFactorian {

	public static void main(String[] args) {
		// System.out.print(computeFactorialN(10));
		Scanner userInputScanner;
		boolean finished = false;
		while (!finished) {
			System.out.print("Please enter a number to check if it is Factorian (or type 'quit' to exit) \n   >>");
			userInputScanner = new Scanner(System.in);

			if (userInputScanner.hasNextInt()) {
				if (isFactorian(userInputScanner.nextInt())) {
					System.out.println("The number is Factorian.");
				} else {
					System.out.println("The number is not Factorian.");
				}
			}else {
				if(userInputScanner.nextLine().equals("quit")) {
					finished = true;
					System.out.println("Goodbye...");
				}else {
					System.out.println("Please enter a valid number or type 'quit' to exit.");
				}
			}

		}
		System.out.print(isFactorian(145));
	}

	public static boolean isFactorian(int number) {
		int factorianToCalc = number, result = 0;
		while (factorianToCalc > 0) {
			int factorialToCalc = factorianToCalc % 10;
			factorianToCalc = factorianToCalc / 10;
			result += computeFactorialN(factorialToCalc);
			System.out.println(result);
		}
		if (result == number)
			return true;
		return false;
	}

	// Returns 1 if input is negative or zero.
	public static int computeFactorialN(int number) {
		int factorial = 1;
		if (number > 0)
			factorial = number * computeFactorialN(number - 1);
		return factorial;
	}

}
