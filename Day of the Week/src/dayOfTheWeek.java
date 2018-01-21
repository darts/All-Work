
/* SELF ASSESSMENT
 1. Did I use appropriate, easy-to-understand, meaningful CONSTANT names formatted correctly in UPPERCASE?
        Mark out of 5:  5, Constant names are clear and formatted correctly.
 2. Did I use easy-to-understand meaningful variable names formatted properly (in lowerCamelCase)?
        Mark out of 5:  5, Variables have meaningful names and are formatted appropriately
 3. Did I indent the code appropriately?
        Mark out of 5: 5, Yes
 4. Did I define the required function correctly (names, parameters & return type) and invoke them correctly?
       Mark out of 20:  20, Required functions are invoked correctly
 5. Did I implement the dayOfTheWeek function correctly and in a manner that can be understood?
       Mark out of 20:  20, Function is implemented correctly in a clear manner.
 6. Did I implement the other functions correctly, giving credit for any code that you take from elsewhere?
       Mark out of 20:  20, Other functions are implemented correctly, no code was taken from elsewhere.
 7. Did I obtain (and process) the input from the user in the correct format (dd/mm/yyyy), and deal with any 
 		invalid input properly?   
       Mark out of 10: 5, Input is taken and handled in the correct manner however the formula does 
       					not work correctly for years under 1000 so the day output is wrong.
 8. Does the program produce the output in the correct format (e.g. Monday, 25th December 2017)?
       Mark out of 10:  10, Yes it does.
 9. How well did I complete this self-assessment?
        Mark out of 5: 5, I graded my code and justified the grade.
 Total Mark out of 100 (Add all the previous marks): 95
*/

import java.util.Scanner;

public class dayOfTheWeek {
	public static final int DAYS_IN_SEP_APR_JUN_NOV = 30;
	public static final int DAYS_IN_FEB = 28;
	public static final int DAYS_IN_FEB_LEAP = 29;
	public static final int DAYS_IN_REST = 31;
	public static final String ENDING_TH = "th ";
	public static final String ENDING_ST = "st ";
	public static final String ENDING_ND = "nd ";
	public static final String ENDING_RD = "rd ";

	public static void main(String[] args) {
		boolean finished = false;
		Scanner userInputScanner;
		Scanner inputEvalScanner;
		while (!finished) {
			System.out.print("Please enter the date in the format: DD/MM/YYYY (or type 'quit' to exit)\n  >> ");
			userInputScanner = new Scanner(System.in);
			String userInput = userInputScanner.nextLine();
			inputEvalScanner = new Scanner(userInput).useDelimiter("/");
			boolean inputValid = true;
			int day = 0;
			int month = 0;
			int year = 0;
			if (inputEvalScanner.hasNextInt()) {
				day = inputEvalScanner.nextInt();
				if (inputEvalScanner.hasNextInt()) {
					month = inputEvalScanner.nextInt();
					if (inputEvalScanner.hasNextInt()) {
						year = inputEvalScanner.nextInt();
					} else {
						inputValid = false;
					}
				} else {
					inputValid = false;
				}
			} else {
				inputValid = false;
			}
			if (dateValid(day, month, year) && inputValid) {
				System.out.println(dayOfTheWeek(day, month, year) + day + numberEnding(day) + monthName(month) + year);
			} else if (inputEvalScanner.next().equals("quit")) {
				finished = true;
				System.out.println("Goodbye...");
				userInputScanner.close();
				inputEvalScanner.close();
			} else {
				System.out.println("Invalid Input!!!");
			}
		}
	}

	public static String dayOfTheWeek(int day, int month, int year) {
		int yearTemp = Math.abs(year);
		/*
		 * The day of the week function should use the Gaussian algorithm… w =
		 * (day + floor(2.6 * (((month + 9) % 12) + 1) - 0.2) + y + floor(y/4) +
		 * floor(c/4) - 2c) mod 7 
		 * where Y: year-1 for January or February, year
		 * for the rest of the year y: last 2 digits of Y 
		 * c: first 2 digits of Y
		 * w: day of week (0=Sunday,..6=Saturday)
		 */
		if (month == 1 || month == 2)
			yearTemp--;
		int lastTwoDigits = yearTemp % 100; // Last two digits
		int yearForFirstTwoDigits = yearTemp;
//		/*
		int firstTwoDigits;
//		if (yearForFirstTwoDigits == 0) {
//			firstTwoDigits = 0;
//		}else {
//		while(yearForFirstTwoDigits > 9999)
//			yearForFirstTwoDigits = yearForFirstTwoDigits / 10;//To correctly calculate first two digits
//		while (yearForFirstTwoDigits < 1000)
//			yearForFirstTwoDigits = yearForFirstTwoDigits * 10;//^^
//		*/
		firstTwoDigits = yearForFirstTwoDigits / 100; // First two digits
//		}
		int dayOfWeek = ((int) (day + (Math.floor(2.6 * (((month + 9) % 12) + 1) - .2) + lastTwoDigits
				+ Math.floor(lastTwoDigits / 4) + Math.floor(firstTwoDigits / 4) - (2 * firstTwoDigits))) % 7);
//		if(dayOfWeek < 0)	//This is necessary to correctly calculate the day for years under 1000 
//			dayOfWeek += 6;
		switch (dayOfWeek) {
		case 0:
			return "Sunday, ";
		case 1:
			return "Monday, ";
		case 2:
			return "Tuesday, ";
		case 3:
			return "Wednesday, ";
		case 4:
			return "Thursday, ";
		case 5:
			return "Friday, ";
		case 6:
			return "Saturday, ";
		default:
			return "Error!!! ";
			
		}
	}

	public static String monthName(int month) {
		switch (month) {
		case 1:
			return "January ";
		case 2:
			return "February ";
		case 3:
			return "March ";
		case 4:
			return "April ";
		case 5:
			return "May ";
		case 6:
			return "June ";
		case 7:
			return "July ";
		case 8:
			return "August ";
		case 9:
			return "September ";
		case 10:
			return "October ";
		case 11:
			return "November ";
		case 12:
			return "December ";
		default:
			return "Error!!!";
		}
	}

	public static String numberEnding(int day) {
		String endingToPrint = ENDING_TH;
		switch (day) {
		case 1:
			endingToPrint = ENDING_ST;
			break;
		case 2:
			endingToPrint = ENDING_ND;
			break;
		case 3:
			endingToPrint = ENDING_RD;
			break;
		default:
			if (day > 20) {
				int lastDigit = day % 10;
				switch (lastDigit) {
				case 1:
					endingToPrint = ENDING_ST;
					break;
				case 2:
					endingToPrint = ENDING_ND;
					break;
				case 3:
					endingToPrint = ENDING_RD;
					break;
				}
			}
		}
		return endingToPrint;
	}

	public static boolean dateValid(int day, int month, int year) {
		if (month > 0 && month <= 12) {
			if (daysInMonth(month, year) >= day && day > 0) {
				return true;
			}
		}
		return false;
	}

	public static int daysInMonth(int month, int year) {
		switch (month) {
		case 4:
		case 6:
		case 9:
		case 11:
			return DAYS_IN_SEP_APR_JUN_NOV;
		case 2:
			if (isLeapYear(year))
				return DAYS_IN_FEB_LEAP;
			return DAYS_IN_FEB;
		default:
			return DAYS_IN_REST;
		}
	}

	public static boolean isLeapYear(int year) {
		if ((year % 4 == 0 && year % 100 != 0) || year % 400 == 0)
			return true;
		return false;
	}
}
