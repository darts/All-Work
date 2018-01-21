public class TwelveDaysTwo {
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
		for (int dayNumber = 1; dayNumber <= daysOfChristmas; dayNumber++) {
			String dayToPrint = "";
			switch (dayNumber) {
			case 1:
				dayToPrint = DAY_ONE;
				break;
			case 2:
				dayToPrint = DAY_TWO;
				break;
			case 3:
				dayToPrint = DAY_THREE;
				break;
			case 4:
				dayToPrint = DAY_FOUR;
				break;
			case 5:
				dayToPrint = DAY_FIVE;
				break;
			case 6:
				dayToPrint = DAY_SIX;
				break;
			case 7:
				dayToPrint = DAY_SEVEN;
				break;
			case 8:
				dayToPrint = DAY_EIGHT;
				break;
			case 9:
				dayToPrint = DAY_NINE;
				break;
			case 10:
				dayToPrint = DAY_TEN;
				break;
			case 11:
				dayToPrint = DAY_ELEVEN;
				break;
			case 12:
				dayToPrint = DAY_TWELVE;
				break;
			}
			System.out.println("On the " + dayToPrint + " day of Christmas\n" + "my true love sent to me:");
			
			switch(dayNumber){
			case 12: 
				System.out.println(DAY_TWELVE_GIFT);
			case 11: 
				System.out.println(DAY_ELEVEN_GIFT);
			case 10: 
				System.out.println(DAY_TEN_GIFT);
			case 9:  
				System.out.println(DAY_NINE_GIFT);
			case 8:  
				System.out.println(DAY_EIGHT_GIFT);
			case 7:  
				System.out.println(DAY_SEVEN_GIFT);
			case 6:  
				System.out.println(DAY_SIX_GIFT);
			case 5:  
				System.out.println(DAY_FIVE_GIFT);
			case 4:  
				System.out.println(DAY_FOUR_GIFT);
			case 3:  
				System.out.println(DAY_THREE_GIFT);
			case 2:  
				System.out.println(DAY_TWO_GIFT);
			case 1:  
				if(dayNumber > 1)
					System.out.print("And ");
				System.out.println(DAY_ONE_GIFT + "\n");
				break;
			}
		}
	}
}
