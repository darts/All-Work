/*
"Write a Java program that reads a floating-point number and prints "zero" if the number is zero.
Otherwise, print "positive" or "negative". Add "small" if the absolute value of the number is less than 1, 
or "large" if it exceeds 1,000,000." 
https://www.w3resource.com/java-exercises/conditional-statement/index.php
*/
// 16-11-2017 @ 14:01 = dartse

import java.util.Scanner;

public class FPPractise {

	public static void main(String[] args) {
		boolean finished = false;
		while(!finished){
			System.out.print("Please enter a floating-point number (or type 'quit' to exit): ");
			Scanner userInputScanner = new Scanner(System.in);
			String stringToPrint = "";
			if (userInputScanner.hasNextDouble()) {
				double userInputFloat = userInputScanner.nextDouble();
				if (userInputFloat == 0) {
					stringToPrint += "zero";
				} else if (userInputFloat > 0) {
					stringToPrint += "positive";
				} else {
					stringToPrint += "negative";
				}
				if (Math.abs(userInputFloat) < 1) {
					stringToPrint += ", small";
				}else if(Math.abs(userInputFloat) > 1000000) {
					stringToPrint += ", large";
				}
			System.out.println(stringToPrint);
			} else {
				stringToPrint = userInputScanner.nextLine();
				if (stringToPrint.equals("quit")) {
					finished = true;
					userInputScanner.close();
				} else {
					System.out.println("'" + stringToPrint + "' is not a valid input.");
				}
			}
		}

	}

}
