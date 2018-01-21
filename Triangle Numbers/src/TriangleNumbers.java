/*
Write a program in Java to make such a pattern like right angle triangle with a number which will repeat a number in a row.
https://www.w3resource.com/java-exercises/conditional-statement/index.php
*/
// Was too tired for error checking input.
// 16-11-17 @ 17:45 - dartse

import java.util.Scanner;

public class TriangleNumbers {

	public static void main(String[] args) {
		System.out.print("Please enter the number of rows: ");
		Scanner userInputScanner = new Scanner(System.in);
		int numberOfRows = userInputScanner.nextInt();
		userInputScanner.close();
		for(int count = 0; numberOfRows > count; count++) {
			for(int tempCount = count; tempCount > 0; tempCount--) {
				System.out.print(count);
			}
			System.out.print("\n");
		}
		
	}

}
