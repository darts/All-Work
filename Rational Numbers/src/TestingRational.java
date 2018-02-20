
/* SELF ASSESSMENT
Class Retional
I declared two member variables: numerator and denominator (marks out of 4:4).
Comment:The two private variables are declared.

Constructor 1
My program takes take two integers as parameters (for numerator and denominator) and initialises the member variables with the corresponding values . 
If the denominator is equal to 0 I throw an exception (marks out of 5:5).
Comment:The constructor takes two inputs, if the denominator is 0 an exception is thrown.

Constructor 2
My program takes only one integer as parameter (numerator), and set the numerator to this value . I set the denominator to 1 in this case, as the 
resulting rational number in this case is an integer (marks out of 3:3).
Comment:The constructor takes a numerator and calls the first constructor with the denominator set to 1.

Add Method
My program takes only a rational number as a parameter and returns a new rational number which has a numerator and denominator which the addition of 
the two objects - this and the parameter. My program does not overwrite any of the other two rational numbers (marks out of 8:8).
Comment:The add method takes a rational number, adjusts both numbers so the base is the same and then performs the addition function, returning the new Rational object.

Subtract Method
I have implemented this the same as add method, except it implements subtraction (marks out of 8:8).
Comment:The function of this method is the same as the previous method but subtracts the normalised numerators. 

Multiply Method
I have implemented this the same as add method, except it implements multiplication (marks out of 8:8).
Comment:Like the add and subtract methods but multiplies the normalised numerators.

Divide Method
I have implemented this the same as add method, except it implements divide (marks out of 8: ).
Comment:The same as the previous methods but divides the normalised numerators.

Equals Method
My program takes a rational number as a parameter and compares it to the reference object. I only use multiplication between numerators/denominators for 
the purpose of comparison, as integer division will lead to incorrect results. I return a boolean value ((marks out of 8:8).
Comment:The method multiplies numerators/denominators and subtracts them to see if they are equal. It returns a boolean result.

isLessThan
My program takes a rational number as a parameter and compares it to the reference object. I only use multiplication as integer division will lead to 
incorrect results. I return a boolean value (marks out of 8:8).
Comment:The method uses multiplication to normalise each rational to the same base and returns a boolean.

Simplify Method
My program returns a rational number but not a new rational number, instead it returns the current reference which is this. It doesn't take any parameters 
as it works only with the reference object. I first find the greatest common divisor (GCD) between the numerator and denominator, and then obtain the new 
numerator and denominator by dividing to the GCD (marks out of 8: ).
Comment:The method simplifies the number by dividing it by the GCD and then returns the Rational.

gcd function
My program returns the greatest common divider of two integers: the numerator and the denominator (marks out of 6:6).
Comment:The method returns the greatest common divisor of the two integers.

toString Method
My program returns a string showing the fraction representation of the number, eg. "1/2". It takes no parameters (marks out of 4:4).
Comment:The method returns the fractional representation of the number and takes no parameters.

Test Client Class
My program asks the user for two rational numbers, creates two rational objects using the constructor and passing in the provided values, calls addition,
 subtraction, multiplication, division, comparison and simplification and prints out the results (marks out of 22:22).
Comment:The program asks the user for two rational numbers and then creates two Rational objects and performs all of the various functions of the class (add, subtract, etc.).
*/

import java.util.Scanner;

public class TestingRational {

	public static void main(String[] args) {
		boolean userInputValid = false;
		Scanner userInputScanner = new Scanner(System.in);
		Rational firstRational = null;
		Rational secondRational = null;
		while (!userInputValid) {
			System.out
					.print("Please enter the numerator and denominator of your first number, followed by the numerator "
							+ "and denominator of your second number, separated by spaces: ");
			int firstNumerator = 0;
			int firstDenominator = 0;
			int secondNumerator = 0;
			int secondDenominator = 0;
			if (userInputScanner.hasNextInt()) {
				firstNumerator = userInputScanner.nextInt();
				if (userInputScanner.hasNextInt()) {
					firstDenominator = userInputScanner.nextInt();
					if (userInputScanner.hasNextInt()) {
						secondNumerator = userInputScanner.nextInt();
						if (userInputScanner.hasNextInt())
							secondDenominator = userInputScanner.nextInt();
					}
				} else {
					System.out.println("The first denominator is not valid.");
				}
			} else {
				System.out.println("This is not a valid number");
				if (userInputScanner.hasNext())
					userInputScanner.nextLine();
			}
			if (firstDenominator != 0 && secondDenominator != 0) {
				try {
					firstRational = new Rational(firstNumerator, firstDenominator);
					secondRational = new Rational(secondNumerator, secondDenominator);
					userInputValid = true;
				} catch (Exception e) {
					System.out.print("Divided by zero error in creating rational.");
				}
			} else {
				System.out.println("Denominator cannot be 0.");
			}
		}

		try {
			System.out.println("Addition : " + firstRational.add(secondRational).toString());
			System.out.println("Subtraction : " + firstRational.subtract(secondRational).toString());
			System.out.println("Multiplication : " + firstRational.multiply(secondRational).toString());
			System.out.println("Division : " + firstRational.divide(secondRational).toString());
			System.out.println("AreEqual : " + firstRational.equals(secondRational));
			System.out.println("IsLessThan : " + firstRational.isLessThan(secondRational));
			firstRational.simplify();
			secondRational.simplify();
			System.out.println("First Rational Simplified : " + firstRational.toString());
			System.out.println("Second Rational Simplified : " + secondRational.toString());
		} catch (Exception e) {
			System.out.println("Divide by zero error in performing rational operations.");
		}

	}

}
