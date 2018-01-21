// Write a program that outputs the first recurring character in a string. e.g. ABBA -> 'B'
// Reddit dailyProgrammer #340
// 17-11-2017 @ 15:57 - dartse

import java.util.Scanner;

public class recurChar {

	public static void main(String[] args) {
		System.out.print("Please enter a string of characters: ");
		Scanner userInputScanner = new Scanner(System.in);
		String userInString = userInputScanner.nextLine();
		char charToPrint = '\0';
		int currentDiff = Integer.MAX_VALUE;
		for(int currentCharNum = 0; currentCharNum < userInString.length(); currentCharNum++) {
		    char currentChar = userInString.charAt(currentCharNum);
		    boolean charNotEqual = true;
		    int newDiff = currentCharNum;
		    for(int i = currentCharNum + 1; i < userInString.length() && charNotEqual; i++) {
		    	char nextChar = userInString.charAt(i);
		    	newDiff++;
		    	if(nextChar == currentChar) {
		    		charNotEqual = false;
		    	}
		    }
			if(newDiff < currentDiff) {
				charToPrint = currentChar;
				currentDiff = newDiff;
			}
		}
		System.out.println(charToPrint);
	}
}
