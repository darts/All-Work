//point scanner to string work from there

import java.util.Scanner;

public class TalkingClock {
	public static final String AM = "am";
	public static final String PM = "pm";
	public static final String OH = "oh";
	public static final String ONE = "one";
	public static final String TWO = "two";
	public static final String THREE = "three";
	public static final String FOUR = "four";
	public static final String FIVE = "five";
	public static final String SIX = "six";
	public static final String SEVEN = "seven";
	public static final String EIGHT = "eight";
	public static final String NINE = "nine";
	public static final String TEN = "ten";
	public static final String ELEVEN = "eleven";
	public static final String TWELVE = "twelve";
	public static final String TEEN = "teen";
	public static final String TWENTY = "twenty";
	public static final String THIRTY = "thirty";
	public static final String FORTY = "forty";
	public static final String FIFTY = "fifty";

	public static void main(String[] args) {
		boolean finished = false;
		while (!finished) {
			System.out.print("Please enter the time in a 24 hour format(or type 'quit' to exit): ");
			int hour = 0;
			int minutes = 0;
			boolean inputValid = true;
			Scanner userInputScanner = new Scanner(System.in);
			String userIn = "";
			//if (userInputScanner.hasNextLine()) {
				userIn = userInputScanner.nextLine();

				Scanner userInScanner = new Scanner(userIn);
				userInScanner.useDelimiter(":");
				if (userInScanner.hasNextInt()) {
					hour = userInScanner.nextInt();
					if (userInScanner.hasNextInt()) {
						minutes = userInScanner.nextInt();
					} else {
						inputValid = false;
					}
				} else {
					inputValid = false;
				}
				userInputScanner.close();
				if (inputValid) {
					String hourPrint = "1";
					String minutesPrint = "1";
					String amPm = AM;
					if (hour > 11)
						amPm = PM;

					System.out.println("It's " + hourPrint + " " + minutesPrint + amPm);
				} else {
					if (userInScanner.nextLine().equals("quit")) {
						finished = true;
					} else {
						System.out.println("You must enter a valid input");
					}
				}
			//}
		}
	}
}

/*
 * //point scanner to string work from there
 * 
 * 
 * import java.util.Scanner;
 * 
 * public class TalkingClock { public static final String AM = "am"; public
 * static final String PM = "pm"; public static final String OH = "oh"; public
 * static final String ONE = "one"; public static final String TWO = "two";
 * public static final String THREE = "three"; public static final String FOUR =
 * "four"; public static final String FIVE = "five"; public static final String
 * SIX = "six"; public static final String SEVEN = "seven"; public static final
 * String EIGHT = "eight"; public static final String NINE = "nine"; public
 * static final String TEN = "ten"; public static final String ELEVEN =
 * "eleven"; public static final String TWELVE = "twelve"; public static final
 * String TEEN = "teen"; public static final String TWENTY = "twenty"; public
 * static final String THIRTY = "thirty"; public static final String FORTY =
 * "forty"; public static final String FIFTY = "fifty";
 * 
 * public static void main(String[] args) { Scanner userInputScanner = new
 * Scanner(System.in); userInputScanner.useDelimiter(":"); boolean finished =
 * false; while (!finished) { System.out.
 * print("Please enter the time in a 24 hour format(or type 'quit' to exit): ");
 * int hour = 0; int minutes = 0; boolean inputValid = true; String userIn =
 * userInputScanner.nextLine(); if (userInputScanner.hasNextInt()) { hour =
 * userInputScanner.nextInt(); if (userInputScanner.hasNextInt()) { minutes =
 * userInputScanner.nextInt(); } else { inputValid = false; } } else {
 * inputValid = false; }
 * 
 * if (inputValid) { String hourPrint = "1"; String minutesPrint = "1"; String
 * amPm = AM; if (hour > 11) amPm = PM;
 * 
 * 
 * System.out.println("It's " + hourPrint + " " + minutesPrint + amPm); } else {
 * if (userInputScanner.nextLine().equals("quit")) { finished = true; } else {
 * System.out.println("You must enter a valid input"); } } } } }
 * 
 */