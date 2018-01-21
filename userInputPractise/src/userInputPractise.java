import java.util.Scanner;
import javax.swing.JOptionPane;

public class userInputPractise {

	public static void main(String[] args) {
		String askUserInput =  JOptionPane.showInputDialog(null, "Please enter 5 numbers separated by spaces.");
		Scanner userInputScanner = new Scanner(askUserInput);
		int input1 = userInputScanner.nextInt();
		int input2 = userInputScanner.nextInt();
		int input3 = userInputScanner.nextInt();
		int input4 = userInputScanner.nextInt();
		int input5 = userInputScanner.nextInt();
		System.out.println(input1 + " " + input2 + " " +  input3 + " " + input4 + " " + input5);
		userInputScanner.close();
	}

}
