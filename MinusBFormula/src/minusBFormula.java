import java.util.Scanner;

import javax.swing.JOptionPane;

public class minusBFormula {
	public static final String QUIT_COMMAND = "quit";

	public static void main(String[] args) {
		boolean userClosedApp = false;
		String userStringInput;
		while (!userClosedApp) {
			String userInput = JOptionPane.showInputDialog(null,
					"Enter the coefficients of your second order polynomial separated by spaces (or enter quit)");
			Scanner userInputScanner = new Scanner(userInput);
			double root1;
			double root2;
			if (userInputScanner.hasNextInt()) {
				int a = userInputScanner.nextInt();
				if (userInputScanner.hasNextInt()) {
					int b = userInputScanner.nextInt();
					if (userInputScanner.hasNextInt()) {
						int c = userInputScanner.nextInt();
						if (a != 0) {
							userInputScanner.close();
							root1 = ((((-1) * b) + Math.sqrt((b * b) - (4 * a * c))) / (2 * a));
							root2 = ((((-1) * b) - Math.sqrt((b * b) - (4 * a * c))) / (2 * a));
							System.out.println(root1);
							System.out.println(root2);

						} else if (a == 0 && b != 0) {
							root1 = -c / b;
							System.out.println(root1);
						} else {
							System.out.println("Invalid equation!");
						}
					}

				}
			} else if (userInputScanner.hasNext()) {
				userStringInput = userInputScanner.next();
				if (userStringInput.equals(QUIT_COMMAND)) {
					userClosedApp = true;
				} else {
					System.out.println(
							"Sorry, please enter the coefficients of your second order polynomial separated by spaces (or enter quit)");
				}
			} else {
				System.out.println(
						"Sorry, please enter the coefficients of your second order polynomial separated by spaces (or enter quit)");
			}
			// System.out.println(root1);
			// System.out.println(root2);
		}

	}
}
