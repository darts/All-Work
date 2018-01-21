//import javax.swing.JOptionPane;
import java.util.Scanner;


public class HelloName {

	public static void main(String[] args) {

		//String name = JOptionPane.showInputDialog("What is your name?");
		//JOptionPane.showMessageDialog(null, "Hello " + name);
		
		System.out.print("What is your name? ");
		Scanner input = new Scanner( System.in );
		String name = input.next();
		input.close();
		System.out.println("Hello " + name);

	}

}