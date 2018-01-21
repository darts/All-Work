
/* SELF ASSESSMENT
   1. Did I use appropriate CONSTANTS instead of numbers within the code? 
       Mark out of 5: 5 All values that could be constants are constants. The current year is also taken from the system clock.
   2. Did I use easy-to-understand, meaningful CONSTANT names?
       Mark out of 5: 5 They are clear, simple and descriptive.
   3. Did I format the CONSTANT names properly (in UPPERCASE)?
       Mark out of 5: 5 All constant names are in uppercase.
   4. Did I use easy-to-understand meaningful variable names?
       Mark out of 10: 10 A clear, simple variable name is used.
   5. Did I format the variable names properly (in lowerCamelCase)?
       Mark out of 10: 10 Variable is formatted in lowerCamelCase.
   6. Did I indent the code appropriately?
       Mark out of 10: 10 All code is indented correctly.
   7. Did I use an appropriate for loop to test all possibilities?  There should be only one.
       Mark out of 20: 20 An appropriate loop to test all possibilities is used. There is only one loop. 
   8. Did I correctly check if people alive today were or could be alive in a year that is the square of their age in that year.
       Mark out of 30: 30 Yes, the program returns the correct result.
   9. How well did I complete this self-assessment?
       Mark out of 5: 5  I graded my code and justified the grade.
   Total Mark out of 100 (Add all the previous marks): 100
*/

import java.util.Calendar;
import java.lang.Math;

public class ageSquaredT2 {
	public static final int MAX_AGE = 123;
	public static final int CURRENT_YEAR = Calendar.getInstance().get(Calendar.YEAR);

	public static void main(String[] args) {
		int age = 0;

		for (age = 0; age <= MAX_AGE; age++) 
		{
			if (MAX_AGE >= (age + Math.abs((age * age) - CURRENT_YEAR))) 
			{
				System.out.println("In the year " + (age * age) + " a person aged " + age
						+ " will be aged the square root of the year.");
			}
		}
	}
}
