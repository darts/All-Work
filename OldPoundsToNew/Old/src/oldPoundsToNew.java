 /*  SELF ASSESSMENT
   1. Did I use appropriate CONSTANTS instead of numbers within the code?
       Mark out of 10:	10, the original constants and the ones used in the code are defined.  
   2. Did I use easy-to-understand, meaningful CONSTANT names?
       Mark out of 5:	5, they seem to be fairly self-explanatory. 
    3. Did I format the CONSTANT names properly (in UPPERCASE)?
       Mark out of 5:	5, all constants are in uppercase.
   4. Did I use easy-to-understand meaningful variable names?
       Mark out of 10:	9, I'd say they're pretty good.
   5. Did I format the variable names properly (in lowerCamelCase)?
       Mark out of 10:	10, all variables are formatted in lowerCamelCase.
   6. Did I indent the code appropriately?
       Mark out of 10:	10,  
   7. Did I read the input correctly from the user using (an) appropriate question(s)?
       Mark out of 10:  8, the question could be more clear.
   8. Did I compute the answer correctly for all cases?
       Mark out of 20:  
   9. Did I output the correct answer in the correct format (as shown in the examples)?
       Mark out of 10:  
   10. How well did I complete this self-assessment?
       Mark out of 10:  
   Total Mark out of 100 (Add all the previous marks):  
*/ 

import java.text.DecimalFormat;
import java.util.InputMismatchException;
import java.util.Scanner;
import javax.swing.JOptionPane;

public class oldPoundsToNew {
	
	public static final double OLD_PENNIES_TO_NEW_PENNIES = 67;
	public static final double OLD_SHILLINGS_TO_OLD_PENNIES = 12;
	public static final double OLD_POUNDS_TO_OLD_SHILLINGS = 20;
	
	public static final double OLD_PENNIES_TO_NEW_POUNDS = (OLD_PENNIES_TO_NEW_PENNIES / 100); //0.67
	public static final double OLD_SHILLINGS_TO_NEW_POUNDS = (OLD_SHILLINGS_TO_OLD_PENNIES * OLD_PENNIES_TO_NEW_PENNIES) / 100; //8.04	
	public static final double OLD_POUNDS_TO_NEW_POUNDS = 
			((OLD_POUNDS_TO_OLD_SHILLINGS * OLD_SHILLINGS_TO_OLD_PENNIES) * OLD_PENNIES_TO_NEW_PENNIES) / 100; //160.8
	
	
	public static void main(String[] args) {
		
		String userOldCurrencyAsk = JOptionPane.showInputDialog(
				"Please enter the amount to be converted in the order: Pounds Shillings Pence, separated by spaces.");
		Scanner userInputScanner = new Scanner(userOldCurrencyAsk);
		
		int oldPounds = 0;
		int oldShillings = 0;
		int oldPennies = 0;	
		String inputNotNumber = "";
		
		//Attempted to use basic try statements here.
		try {
			oldPounds = userInputScanner.nextInt();
		} catch(InputMismatchException e) {
			inputNotNumber = userInputScanner.next();
			System.out.println("User did not enter a number of pounds! Instead they entered: " + inputNotNumber);
		} catch(Exception e ) {
			System.out.println("User did not enter a number of pounds!");
		};
		
		try {
			oldShillings = userInputScanner.nextInt();
		} catch(InputMismatchException e) {
			inputNotNumber = userInputScanner.next();
			System.out.println("User did not enter a number of shillings! Instead they entered: " + inputNotNumber);
		} catch(Exception e) {
			System.out.println("User did not enter a number of shillings!");
		};
		
		try {
			oldPennies = userInputScanner.nextInt();
		} catch(InputMismatchException e) {
			inputNotNumber = userInputScanner.next();
			System.out.println("User did not enter a number of pennies! Instead they entered: " + inputNotNumber);
		} catch(Exception e) {
			System.out.println("User did not enter a number of pennies!");
		};
			
		userInputScanner.close();
		
		double newCurrency =  oldPounds * OLD_POUNDS_TO_NEW_POUNDS;
		newCurrency +=  oldShillings * OLD_SHILLINGS_TO_NEW_POUNDS;
		newCurrency +=  oldPennies * OLD_PENNIES_TO_NEW_POUNDS;
		
		DecimalFormat currencyFormatter = new DecimalFormat("#0.00");
		
		JOptionPane.showMessageDialog(null, 
				oldPounds + " old pound, " + oldShillings + " old shilling and " + oldPennies + " old pence = £"
				+ currencyFormatter.format(newCurrency));
	}

}
