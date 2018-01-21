/*This was a reddit daily challenge. I spent far too much time on it and it doesn't work (mostly). 
 * I may come back to it in a few months time when I have the skills to finish it in a clean and 
 * effective way but for now I won't waste any more time on it. */

// 28-11-2017 @ 14:20 - dartse


import java.util.Scanner;

public class ccfda {

	public static final String AM = "am";
	public static final String PM = "pm";
	public static final String OH = "oh ";
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
	public static final String THIRTEEN = "thirteen";
	public static final String FOURTEEN = "fourteen";
	public static final String FIFTEEN = "fifteen";
	public static final String SIXTEEN = "sixteen";
	public static final String SEVENTEEN = "seventeen";
	public static final String EIGHTEEN = "eighteen";
	public static final String NINETEEN = "nineteen";
	public static final String TWENTY = "twenty";
	public static final String THIRTY = "thirty";
	public static final String FORTY = "forty";
	public static final String FIFTY = "fifty";
	
	public static void main(String[] args) {
		boolean finished = false;
		Scanner userInputScanner;
		Scanner inputEvalScanner;
		while (!finished) {
			System.out.print(
					"Please enter the time (or type 'quit') in the following format: HH:MM \n  >> ");
			userInputScanner = new Scanner(System.in);
			String userInput = userInputScanner.nextLine();
			inputEvalScanner = new Scanner(userInput).useDelimiter(":");
			int hour = 0;
			int minute = 0;
			String amPm = AM;
			boolean inputIsNumber = true;
			if (inputEvalScanner.hasNextInt()) {
				hour = inputEvalScanner.nextInt();
				if (hour < 0 || hour > 23)
					inputIsNumber = false;
				else if(hour > 12) {
					amPm = PM;
					hour = hour - 12;
				}
				if (inputEvalScanner.hasNextInt()) {
					minute = inputEvalScanner.nextInt();
					if (minute < 0 || minute > 59)
						inputIsNumber = false;
				} else {
					inputIsNumber = false;
				}
			} else {
				inputIsNumber = false;
			}
			
			if (inputIsNumber) {
				String hourToPrint = returnNum(hour, false);
				String minuteToPrint = returnNum(minute, true);
				System.out.println("It's " + hourToPrint + " " + minuteToPrint + " " + amPm);
			}else {	
				 if (userInput.equals("quit")) {
					finished = true;
				}else { 
					System.out.println("Input invalid!");
				}
			}	
		}
	}

	public static String returnNum(int number, boolean isMinute) {
		String numToPrint = "";
		if (isMinute && number < 10)
			numToPrint += OH;
		if(number >= 0 && number <= 19) {
			switch(number) {
			case 0:
				if(!isMinute)
					return(numToPrint += TWELVE);
			case 1:
				return(numToPrint += ONE);
			case 2:
				return(numToPrint += TWO);
			case 3:
				return(numToPrint += THREE);
			case 4:
				return(numToPrint += FOUR);
			case 5:
				return(numToPrint += FIVE);
			case 6:
				return(numToPrint += SIX);
			case 7:
				return(numToPrint += SEVEN);
			case 8:
				return(numToPrint += EIGHT);
			case 9:
				return(numToPrint += NINE);
			case 10:
				return(numToPrint += TEN);
			case 11:
				return (numToPrint += ELEVEN);
			case 12:
				return(numToPrint += TWELVE);
			case 13:
				return(numToPrint += THIRTEEN);
			case 14:
				return(numToPrint += FOURTEEN);
			case 15:
				return(numToPrint += FIFTEEN);
			case 16:
				return(numToPrint += SIXTEEN);
			case 17:
				return(numToPrint += SEVENTEEN);
			case 18:
				return(numToPrint += EIGHTEEN);
			case 19:
				return(numToPrint += NINETEEN);
			}
		}else {
			if (number < 30) {
				int tempNum = number - 20;
				numToPrint += TWENTY;
				return (numToPrint + " " + returnNum(tempNum, false));
			}
			//return(numToPrint = "Input out of range!!");
		}
		return numToPrint;
	}
	/*
	public static String askInput(String question) {
		Scanner takeInputScanner = new Scanner(System.in);
		System.out.print(question);
		String userInput = takeInputScanner.nextLine();
		takeInputScanner.close();
		return userInput;
	}
	*/
}