import java.util.Scanner;

public class Etest2 {
	public static final int ROMAN_MAX = 4999;
	public static final int ROMAN_MIN = 1;
	public static final int M = 1000;
	public static final int D = 500;

	public static void main(String[] args) {
		boolean finished = false;
		Scanner userInputScanner = new Scanner(System.in);
		while (!finished) {
			System.out.print("Enter the Arabic number to be converted>");
			if(userInputScanner.hasNextInt()){
				int userInput = userInputScanner.nextInt();
				if(canBeConvertedToRoman(userInput)){
					System.out.println("In Roman form " + userInput + " is " + convertToRoman(userInput));
				}else{
					System.out.println("This number cannot be converted to Roman form.");
				}
			}else{
				System.out.println("You must enter a number");
			}
		}
	}

	public static boolean canBeConvertedToRoman(int numToCheck) {
		if (numToCheck >= ROMAN_MIN && numToCheck <= ROMAN_MAX) {
			return true;
		}
		return false;
	}

	public static String convertToRoman(int numToConvert) {
		int[] tmpNumToConvert = { numToConvert };
		String numberToReturn = "";
		while (tmpNumToConvert[0] >= 1000) {
			tmpNumToConvert[0] -= 1000;
			numberToReturn += "M";
		}
		numberToReturn += checkForSub(tmpNumToConvert);
		while (tmpNumToConvert[0] >= 500) {
			tmpNumToConvert[0] -= 500;
			numberToReturn += "D";
		}
		numberToReturn += checkForSub(tmpNumToConvert);
		while (tmpNumToConvert[0] >= 100) {
			tmpNumToConvert[0] -= 100;
			numberToReturn += "C";
		}
		numberToReturn += checkForSub(tmpNumToConvert);
		while (tmpNumToConvert[0] >= 50) {
			tmpNumToConvert[0] -= 50;
			numberToReturn += "L";
		}
		numberToReturn += checkForSub(tmpNumToConvert);
		while (tmpNumToConvert[0] >= 10) {
			tmpNumToConvert[0] -= 10;
			numberToReturn += "X";
		}
		numberToReturn += checkForSub(tmpNumToConvert);
		while (tmpNumToConvert[0] >= 5) {
			tmpNumToConvert[0] -= 5;
			numberToReturn += "V";
		}
		numberToReturn += checkForSub(tmpNumToConvert);
		while (tmpNumToConvert[0] > 0) {
			tmpNumToConvert[0]--;
			numberToReturn += "I";
		}
		return numberToReturn;
	}

	public static String checkForSub(int[] numToCheck) {
		switch (numToCheck[0]) {
		case 999:
			numToCheck[0] -= 999;
			return "IM";
		case 990:
			numToCheck[0] -= 990;
			return "XM";
		case 900:
			numToCheck[0] -= 900;
			return "CM";
		case 499:
			numToCheck[0] -= 499;
			return "ID";
		case 490:
			numToCheck[0] -= 490;
			return "XD";
		case 400:
			numToCheck[0] -= 400;
			return "CD";
		case 99:
			numToCheck[0] -= 99;
			return "IC";
		case 90:
			numToCheck[0] -= 90;
			return "XC";
		case 49:
			numToCheck[0] -= 49;
			return "IL";
		case 40:
			numToCheck[0] -= 40;
			return "XL";
		case 9:
			numToCheck[0] -= 9;
			return "IX";
		case 4:
			numToCheck[0] -= 4;
			return "IV";
		default:
			return "";
		}
	}

}
