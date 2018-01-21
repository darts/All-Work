//Tutorial problem
// 13-12-2017 @ 13:49 - dartse

import java.util.Scanner;
public class digitFrequency {

	public static void main(String[] args) {
		int[] frequencies = new int[10];
		boolean finished = false;
		Scanner userScanner;
		while (!finished) {
			System.out.print("Enter a number: ");
			userScanner = new Scanner(System.in);
			if (userScanner.hasNextInt()) {
				countDigitFrequencies(Math.abs(userScanner.nextInt()), frequencies);
				printDigitFrequencies(frequencies);
			} else {
				System.out.println("Please enter a valid number.");
			}
		}

	}

	public static void countDigitFrequencies(int number, int[] frequencies) {
		int numberTmp = number;
		do {
			int currentDigit = numberTmp % 10;
			frequencies[currentDigit]++;
			numberTmp /= 10;
		} while (numberTmp != 0);
	}

	public static void printDigitFrequencies(int[] frequencies) {
		if (frequencies != null) {
			String stringToPrint = "Digit frequencies: ";
			for (int index = 0; index < frequencies.length; index++) {
				if (frequencies[index] != 0)
					stringToPrint += index + "(" + frequencies[index] + ") ";
			}
			System.out.println(stringToPrint);
		}
	}
}
