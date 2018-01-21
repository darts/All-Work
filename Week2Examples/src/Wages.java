import java.util.Scanner;

import javax.swing.JOptionPane;

/*
 * Write a program which takes in hours worked, minutes worked and an hourly pay rate,
 * and then determines the amount of pay due...
 */
public class Wages {
	
	public static final int CENTS_PER_EURO = 100;
	public static final int MINUTES_PER_HOUR = 60;
	public static final double ROUNDING_ADJUSTMENT = 0.00001;

	public static void main(String[] args) {
	
		String input = JOptionPane.showInputDialog("Enter time worked (hours:mintes):");
		Scanner inputScanner = new Scanner( input );
		inputScanner.useDelimiter(":");
		int hoursWorked = inputScanner.nextInt();
		int minutesWorked = inputScanner.nextInt();
		input = JOptionPane.showInputDialog("Enter hourly rate (Euros.Cents):");
		//inputScanner = new Scanner( input );
		double euroHourlyRate = inputScanner.nextDouble();
		inputScanner.close();
		
		int totalCentsPerHour = (int) ((euroHourlyRate+ROUNDING_ADJUSTMENT) * CENTS_PER_EURO);
		int totalMinutesWorked = hoursWorked*MINUTES_PER_HOUR + minutesWorked;
		int totalWagesInCents = (totalCentsPerHour * totalMinutesWorked) / MINUTES_PER_HOUR;
		double totalWagesInEuros = ((double) totalWagesInCents) / CENTS_PER_EURO;
		
		JOptionPane.showMessageDialog(null, "Having worked for " +
				hoursWorked + ":" + minutesWorked + " at a rate of €" 
				+ euroHourlyRate + " per hour,\nyou are owed wages of €" + 
				totalWagesInEuros);
	
	}

}