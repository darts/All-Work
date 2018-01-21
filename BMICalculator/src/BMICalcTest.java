import javax.swing.JOptionPane;
import java.util.Scanner;

public class BMICalcTest {

	public static void main(String[] args) {
		
		String userInput = JOptionPane.showInputDialog("What is your height in metres?");
		Scanner userInputScanner = new Scanner(userInput);
		double userHeight = userInputScanner.nextDouble();
		
		userInput = JOptionPane.showInputDialog("What is your weight in kilograms?");
		//Scanner userWeightInputScanner = new Scanner(userWeightInput);
		double userWeight = userInputScanner.nextDouble();
		
		double userHeightSquared = userHeight * userHeight;
		double userBMI = userWeight / userHeightSquared;
		
		JOptionPane.showMessageDialog(null, "With a height of " + userHeight + " metres and a weight of " + userWeight + " kilograms your BMI is: " + userBMI);

	}

}
