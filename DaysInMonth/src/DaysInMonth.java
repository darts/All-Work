/* 
Write a Java program to find the number of days in a month.
https://www.w3resource.com/java-exercises/conditional-statement/index.php 
*/
// 16-11-2017 @ 16:26 - dartse

import java.util.Scanner;

public class DaysInMonth {

	public static final int DAYS_IN_FEB = 28;
	public static final int DAYS_IN_FEB_LEAP = 29;
	public static final int DAYS_IN_SEP_APR_JUN_NOV = 30;
	public static final int DAYS_IN_REST = 31;

	public static void main(String[] args) {
		boolean finished = false;
		while (!finished) {
			System.out.println("Please enter the year and month in the following format: YYYY M(1-12): ");
			Scanner userInputScanner = new Scanner(System.in);
			int year = 0;
			int month = 0;
			boolean inputCorrect = true;
			String daysToPrint = "";
			if (userInputScanner.hasNextInt()) {
				year = userInputScanner.nextInt();
				if (userInputScanner.hasNextInt()) {
					month = userInputScanner.nextInt();
				} else {
					inputCorrect = false;
				}
			}else {
				inputCorrect = false;
			}
			
			if (inputCorrect) {
				boolean isLeapYear = false;
				if (((year % 4 == 0) && year % 100 != 0) || year % 400 == 0) {
					isLeapYear = true;
				}
				switch(month) {
				case 2: 
					if (isLeapYear) {
						daysToPrint += DAYS_IN_FEB_LEAP;
					}else {
						daysToPrint += DAYS_IN_FEB;
					}
					break;
				case 4:
				case 6:
				case 9:
				case 11:
					daysToPrint += DAYS_IN_SEP_APR_JUN_NOV; 
					break;
				default:
					daysToPrint += DAYS_IN_REST;
				}
				System.out.println(daysToPrint);
			}else {
				daysToPrint = userInputScanner.nextLine();
				if(daysToPrint.equals("quit")) {
					finished = true;
					userInputScanner.close();
				} else {
					System.out.println("'" + daysToPrint + "' is not a valid input.");
				}
			}
		}
	}
}
