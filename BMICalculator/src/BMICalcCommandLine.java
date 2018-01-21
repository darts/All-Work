import java.util.Scanner;

public class BMICalcCommandLine {

	public static void main(String[] args) {
		
		//Asks for user's height and writes to variable.
		System.out.print("What is your height in metres? ");
		Scanner userInputScanner = new Scanner(System.in);
		double userHeight = userInputScanner.nextDouble();
		
		//Asks for users height and writes to variable.
		System.out.print("What is your weight in kilograms? ");
		//Scanner userWeightScanner = new Scanner(System.in);
		double userWeight = userInputScanner.nextDouble();
		userInputScanner.close();
		
		//Calculate BMI.
		double userHeightSquared = userHeight * userHeight;
		double userBMI = userWeight / userHeightSquared;
		
		//Print result.
		System.out.println("With a height of " + userHeight + " metres and a weight of " + userWeight + " kilograms your BMI is: " + userBMI); 

	}

}
