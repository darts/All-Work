/* SELF ASSESSMENT
   1. Did I use appropriate CONSTANTS instead of numbers within the code?
       Mark out of 5: 5 - Appropriate constants are used.
   2. Did I use easy-to-understand, meaningful CONSTANT names formatted correctly in UPPERCASE?
       Mark out of 5: 5 - Constant names are easy to understand and in uppercase.
   3. Did I use easy-to-understand meaningful variable names formatted properly (in lowerCamelCase)?
       Mark out of 10: 10 - Variables are meaningful and in lowerCamelCase.
   4. Did I indent the code appropriately?
       Mark out of 10: 10 - Code is indented correctly.
   5. Did I use an appropriate loop (or loops) to produce the different verses?
       Mark out of 20: 20 - One appropriate for loop is used.
   6. Did I use a switch to build up the verses?
       Mark out of 25: 25 - A single switch statement is used to build up the verses.
   7. Did I avoid duplication of code and of the lines which make up the verses (each line should be referred to in the code only once (or twice))?
       Mark out of 10: 10 - No code is duplicated and all constants are called only once.
   8. Does the program produce the correct output?
       Mark out of 10: 10 - The correct output is produced.
   9. How well did I complete this self-assessment?
       Mark out of 5: - I graded my code and justified the marks.
   Total Mark out of 100 (Add all the previous marks): 100
*/

public class TwelveDaysOfChristmas {
	public static final String DAY_ONE_GIFT = "A Partridge in a Pear Tree";
	public static final String DAY_TWO_GIFT = "2 Turtle Doves";
	public static final String DAY_THREE_GIFT = "3 French Hens";
	public static final String DAY_FOUR_GIFT = "4 Calling Birds";
	public static final String DAY_FIVE_GIFT = "5 Golden Rings";
	public static final String DAY_SIX_GIFT = "6 Geese a Laying";
	public static final String DAY_SEVEN_GIFT = "7 Swans a Swimming";
	public static final String DAY_EIGHT_GIFT = "8 Maids a Milking";
	public static final String DAY_NINE_GIFT = "9 Ladies Dancing";
	public static final String DAY_TEN_GIFT = "10 Lords a Leaping";
	public static final String DAY_ELEVEN_GIFT = "11 Pipers Piping";
	public static final String DAY_TWELVE_GIFT = "12 Drummers Drumming";

	public static final String DAY_ONE = "first";
	public static final String DAY_TWO = "second";
	public static final String DAY_THREE = "third";
	public static final String DAY_FOUR = "fourth";
	public static final String DAY_FIVE = "fifth";
	public static final String DAY_SIX = "sixth";
	public static final String DAY_SEVEN = "seventh";
	public static final String DAY_EIGHT = "eigth";
	public static final String DAY_NINE = "ninth";
	public static final String DAY_TEN = "tenth";
	public static final String DAY_ELEVEN = "eleventh";
	public static final String DAY_TWELVE = "twelfth";

	public static final int daysOfChristmas = 12;

	public static void main(String[] args) {
		String stringToPrint = "";
		for (int dayNumber = 1; dayNumber <= daysOfChristmas; dayNumber++) {
			String dayToPrint = "";

			switch (dayNumber) {
			case 1:
				stringToPrint = DAY_ONE_GIFT + "\n" + stringToPrint;
				dayToPrint = DAY_ONE;
				break;
			case 2:
				stringToPrint = DAY_TWO_GIFT + "\n" + "And " + stringToPrint;
				dayToPrint = DAY_TWO;
				break;
			case 3:
				stringToPrint = DAY_THREE_GIFT + "\n" + stringToPrint;
				dayToPrint = DAY_THREE;
				break;
			case 4:
				stringToPrint = DAY_FOUR_GIFT + "\n" + stringToPrint;
				dayToPrint = DAY_FOUR;
				break;
			case 5:
				stringToPrint = DAY_FIVE_GIFT + "\n" + stringToPrint;
				dayToPrint = DAY_FIVE;
				break;
			case 6:
				stringToPrint = DAY_SIX_GIFT + "\n" + stringToPrint;
				dayToPrint = DAY_SIX;
				break;
			case 7:
				stringToPrint = DAY_SEVEN_GIFT + "\n" + stringToPrint;
				dayToPrint = DAY_SEVEN;
				break;
			case 8:
				stringToPrint = DAY_EIGHT_GIFT + "\n" + stringToPrint;
				dayToPrint = DAY_EIGHT;
				break;
			case 9:
				stringToPrint = DAY_NINE_GIFT + "\n" + stringToPrint;
				dayToPrint = DAY_NINE;
				break;
			case 10:
				stringToPrint = DAY_TEN_GIFT + "\n" + stringToPrint;
				dayToPrint = DAY_TEN;
				break;
			case 11:
				stringToPrint = DAY_ELEVEN_GIFT + "\n" + stringToPrint;
				dayToPrint = DAY_ELEVEN;
				break;
			case 12:
				stringToPrint = DAY_TWELVE_GIFT + "\n" + stringToPrint;
				dayToPrint = DAY_TWELVE;
				break;
			}
			System.out.println(
					"On the " + dayToPrint + " day of Christmas\n" + "my true love sent to me: \n" + stringToPrint);
		}
	}
}