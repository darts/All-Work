//In response to the feedback on my 12 Days of Christmas assignment I have ensured 
//to include plenty of justification and comments.
/* SELF ASSESSMENT
 1. Did I use easy-to-understand meaningful variable names formatted properly (in lowerCamelCase)?
        Mark out of 5:	5 - The variables used are all formatted in lowerCamelCase : numberOfTriangularSquaresFound, 
        numberCounter, numberToCheck, starNumberCounter, counter, numToTriangle, triangleNum, triangleNumCountdown.
        All of these variables are easy-to-understand and meaningful within their respective contexts.
 2. Did I indent the code appropriately?
        Mark out of 5: 5 - The code is indented appropriately (or at least as far as Eclipse's built-in formatting 
        function is concerned it is correct).
 3. Did I write the determineStarNumber or determineTriangleNumber function correctly (parameters, return type and 
 	function body) and invoke it correctly?
       Mark out of 20:  20 - Yes, the determineStarNumber function is correctly implemented. It is supplied with 1 parameter 
       (int numToStar) and has the return type int. The function body also contains all of the necessary code to return the 
       Star Number associated with the index provided. The function is invoked correctly in the isStarNumber function.
       The determineTriangleNumber function is correctly implemented. It is supplied with 1 parameter 
       (int numToTriangle) and has the return type int. The function body also contains all of the necessary code to return 
       the Triangle Number associated with the index provided. The function is invoked correctly in the main body of the program.
 4. Did I write the isStarNumber function correctly (parameters, return type and function body) and invoke it correctly?
       Mark out of 20:	20 - Yes, the isStarNumber function is correctly written. It takes in 1 parameter (int numberToCheck) and 
       returns a boolean value of true/false depending on if the number is a Star Number or not. The body of the function contains
       all the code needed in order to check if the number is or is not a Star Number.
 5. Did I calculate and/or check triangle numbers correctly?
       Mark out of 15:	15 - Yes, triangle numbers are calculated correctly using the determineTriangleNumber
       function which takes a single input parameter (int numToTriangle) and returns the Triangle Number corresponding to that 
       index.
 6. Did I loop through all possibilities in the program using system defined constants to determine when to stop?
       Mark out of 10:  10 - It is poss
 7. Does my program compute and print all the correct triangular star numbers?
       Mark out of 20:
 8. How well did I complete this self-assessment?
        Mark out of 5:
 Total Mark out of 100 (Add all the previous marks):
*/
public class TriangularStars {
	public static final int NUMBER_OF_TRIANGULAR_SQUARES_TO_FIND = -1; // Leave this as -1 to turn off. Determines how
																		// many Triangular Squares the system should
																		// attempt to find. Results
																		// unreliable if greater than 5.
	public static final int MAX_NUMBER_FOR_TRIANGULAR_SQUARE = Integer.MAX_VALUE; // Leave this as -1 to turn off.
																					// Determines the
																		// maximum value for a Triangular Square to have. 
																		//To get all Triangular squares
																		// set as 'Integer.MAX_VALUE'

	public static void main(String[] args) {
		// Section for finding a certain number of Triangular Squares.
		int numberOfTriangularSquaresFound = 0;
		int numberCounter = 1;
		while (numberOfTriangularSquaresFound < NUMBER_OF_TRIANGULAR_SQUARES_TO_FIND) {
			if (isStarNumber(determineTriangleNumber(numberCounter))) {
				System.out.println(determineTriangleNumber(numberCounter));
				numberOfTriangularSquaresFound++;
			}
			numberCounter++;
		}

		// Section for finding Triangular Squares below a certain number.
		for (int counter = 1; counter < MAX_NUMBER_FOR_TRIANGULAR_SQUARE; counter++) {
			if (isStarNumber(determineTriangleNumber(counter)))
				System.out.println(determineTriangleNumber(counter));
		}
	}

	// Checks if a number is a Star Number. Calls the determineStarNumber function
	// multiple times to do this. Will return false if number is negative.
	public static boolean isStarNumber(int numberToCheck) {
		int starNumberCounter = 1;
		while (numberToCheck >= determineStarNumber(starNumberCounter)) {
			if (numberToCheck == determineStarNumber(starNumberCounter))
				return true;
			starNumberCounter++;
		}
		return false;
	}

	// Determines the Triangular Number corresponding to the supplied index. Returns
	// 1 if supplied number is negative.
	public static int determineStarNumber(int numToStar) {
		if (numToStar < 0)
			return 1;
		return ((6 * numToStar * (numToStar - 1)) + 1);
	}

	// Determines the Triangular Number corresponding to the supplied index. Returns
	// 1 if supplied number is negative.
	public static int determineTriangleNumber(int numToTriangle) {
		int triangleNum = 1;
		for (int triangleNumCountdown = numToTriangle; numToTriangle > 1
				&& triangleNumCountdown > 0; triangleNumCountdown--) {
			triangleNum += numToTriangle--;
		}
		return triangleNum;
	}
}
