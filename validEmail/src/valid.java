import java.util.Scanner;

public class valid {
	public static final char[] ARRAY = { ' ', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o',
			'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J',
			'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', '0', '1', '2', '3', '4',
			'5', '6', '7', '8', '9' };

	public static void main(String[] args) {
		Scanner userInputScanner = new Scanner(System.in);
		
		for (int index = 0; index < ARRAY.length; index++) {
			char a = ARRAY[index];
			int b = Character.getNumericValue(a);
			System.out.println(a + " " + b);
		}
	}

}
