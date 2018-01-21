import java.util.Scanner;
import javax.swing.JOptionPane;

public class UserInput {

	public static void main(String[] args) {
		String askUserInput =  JOptionPane.showInputDialog(null, "Please enter 5 numbers separated by commas.");
		Scanner userInputScanner = new Scanner(askUserInput);
		userInputScanner.useDelimiter(",");
		int input1 = userInputScanner.nextInt();
		int input2 = userInputScanner.nextInt();
		int input3 = userInputScanner.nextInt();
		int input4 = userInputScanner.nextInt();
		int input5 = userInputScanner.nextInt();
		int averageInput = (input1 + input2 + input3 + input4 + input5) / 5;
		System.out.println("String is: " + input1 + " " + input2 + " " +  input3 + " " + input4 + " " + input5);
		System.out.println("Average is: " + averageInput);
		userInputScanner.close();
		System.out.println("Odd numbers are: ");
		if(input1 % 2 == 0){
			System.out.println(input1);
		}
		if(input2 % 2 == 0){
			System.out.println(input2);
		}
		if(input3 % 2 == 0){
			System.out.println(input3);
		}
		if(input4 % 2 == 0){
			System.out.println(input4);
		}if(input5 % 2 == 0){
			System.out.println(input5);
		}
	}
}
