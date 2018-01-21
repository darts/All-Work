import java.util.Scanner;
import javax.swing.JOptionPane;

public class fosatutorial {
	 public static void main(String[]args) {
		 String numberInput = JOptionPane.showInputDialog(null, "Please enter a some numbers seperated by spaces");
		 Scanner inputScanner = new Scanner(numberInput);
		 int currrentNumber = 0;
		 int MAX_NUMBER = 0;
		 int MIN_NUMBER = 0;
		 currrentNumber = MAX_NUMBER;
		 while  (inputScanner.hasNextInt())
		 {
			 if (currrentNumber <inputScanner.nextInt())
			 {
				 currrentNumber = inputScanner.nextInt();
				 MAX_NUMBER = currrentNumber;	 
			 }
			 else if (currrentNumber>inputScanner.nextInt())
			 {
			 MIN_NUMBER = inputScanner.nextInt();
		     }
	     }
		 JOptionPane.
	
 }
}