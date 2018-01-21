import javax.swing.JOptionPane;
import java.util.Scanner;

public class BMICalc {

	public static void main(String[] args) {
		
		//Get user height.
		String userHeightInput = JOptionPane.showInputDialog("What is your height in metres?");
		Scanner userHeightInputScanner = new Scanner(userHeightInput);
		double userHeight = userHeightInputScanner.nextDouble();
		userHeightInputScanner.close();
		
		//Get user weight.
		String userWeightInput = JOptionPane.showInputDialog("What is your weight in kilograms?");
		Scanner userWeightInputScanner = new Scanner(userWeightInput);
		double userWeight = userWeightInputScanner.nextDouble();
		userWeightInputScanner.close();
		
		//Calculate BMI.
		double userHeightSquared = userHeight * userHeight;
		double userBMI = userWeight / userHeightSquared;
		
		//Print result.
		JOptionPane.showMessageDialog(null, "With a height of " + userHeight + " metres and a weight of " + userWeight + " kilograms your BMI is: " + userBMI);

	}

}
