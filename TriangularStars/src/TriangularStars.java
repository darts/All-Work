//In response to the feedback on my 12 Days of Christmas assignment I have ensured 
//to include plenty of justification and comments.
/* SELF ASSESSMENT
 1. Did I use easy-to-understand meaningful variable names formatted properly (in lowerCamelCase)?
        Mark out of 5:	5 - The variables used are all formatted in lowerCamelCase : currentTriangleNumber, 
        numberToCheck, starNumberCounter, currentStarNumber, counter, numToTriangle, triangleNum, triangleNumCountdown.
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
       Mark out of 10:  10 - Yes, the program will potentially test all values of 'n' up to the maximum value for int but will 
       stop if one of the functions returns a negative number because at that stage the program 
 7. Does my program compute and print all the correct triangular star numbers?
       Mark out of 20: 20 - Yes, as far as I'm aware the 5 results produced by the program are correct. They are all Triangular 
       Star number. They pass both checks (for a Triangular number and a Star number) within the code without the integers wrapping
       around.
 8. How well did I complete this self-assessment?
        Mark out of 5: 5 - I graded my code and justified the grades, I provided explainations and justification for every grade.
 Total Mark out of 100 (Add all the previous marks): 100
*/
public class TriangularStars {

	public static void main(String[] args) {

		// Section for finding Triangular Squares below a certain number.
		for (int counter = 1; counter < Integer.MAX_VALUE && determineTriangleNumber(counter) != -1; counter++) {
			int currentTriangleNumber = determineTriangleNumber(counter);
			if (isStarNumber(currentTriangleNumber)){
				System.out.println(currentTriangleNumber);
			}
		}
	}

	// Checks if a number is a Star Number. Calls the determineStarNumber function
	// multiple times to do this. Will return false if number is negative or result is negative.
	public static boolean isStarNumber(int numberToCheck) {
		int starNumberCounter = 1;
		int currentStarNumber = determineStarNumber(starNumberCounter);
		while (numberToCheck >= currentStarNumber) {
			if (numberToCheck == currentStarNumber){
				return true;
			}else if(currentStarNumber < 0){
				return false;
			}
			starNumberCounter++;
			currentStarNumber = determineStarNumber(starNumberCounter);
		}
		return false;
	}

	// Determines the Triangular Number corresponding to the supplied index. Returns
	// 1 if supplied number is negative. Returns -1 if integer wraps around.
	public static int determineStarNumber(int numToStar) {
		if (numToStar < 0)
			return 1;
		int starNumber = ((6 * numToStar * (numToStar - 1)) + 1);
		if (starNumber > 0)
			return starNumber;
		return -1;
	}

	// Determines the Triangular Number corresponding to the supplied index. Returns
	// 1 if supplied number is negative. Returns -1 if integer wraps around.
	public static int determineTriangleNumber(int numToTriangle) {
		int triangleNum = 1;
		for (int triangleNumCountdown = numToTriangle; numToTriangle > 1
				&& triangleNumCountdown > 0; triangleNumCountdown--) {
			triangleNum += numToTriangle--;
			if(triangleNum < 0)
				return -1;
		}
		return triangleNum;
	}
}
