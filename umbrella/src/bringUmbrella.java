/* SELF ASSESSMENT 
   1. Did I use easy-to-understand meaningful variable names? 
       Mark out of 10: 10
   2. Did I format the variable names properly (in lowerCamelCase)? 
       Mark out of 10: 10
   3. Did I indent the code appropriately? 
       Mark out of 10: 10
   4. Did I read the input correctly from the user using appropriate questions? 
       Mark out of 20: 17, questions could be better.
   5. Did I use an appropriate (i.e. not more than necessary) series of if statements? 
       Mark out of 30: 30
   6. Did I output the correct answer for each possibility in an easy to read format? 
       Mark out of 15: 15
   7. How well did I complete this self-assessment? 
       Mark out of 5: 5
   Total Mark out of 100 (Add all the previous marks): 97 
*/

import javax.swing.JOptionPane;

public class bringUmbrella {
	public static final String ASK_IS_RAINING_NOW = "Is it raining now?";
	public static final String LOOK_LIKE_WILL_RAIN = "Does it look like it will rain?";
	public static final String SHOULD_BRING_UMBRELLA_AND_OPEN = "You should bring an umbrella and open it.";
	public static final String SHOULD_BRING_UMBRELLA_AND_NOT_OPEN = "You should bring an umbrella but not open it.";
	public static final String SHOULD_NOT_BRING_UMBRELLA = "You do not need to bring an umbrella.";
	
	public static void main(String[] args) {
		int askRaining = JOptionPane.showConfirmDialog(null, ASK_IS_RAINING_NOW, null, JOptionPane.YES_NO_OPTION);
		
		if (askRaining == JOptionPane.YES_OPTION){
			JOptionPane.showMessageDialog(null, SHOULD_BRING_UMBRELLA_AND_OPEN);
		}else if (askRaining == JOptionPane.NO_OPTION){
			int looksLikeRain = JOptionPane.showConfirmDialog(null, LOOK_LIKE_WILL_RAIN, null, JOptionPane.YES_NO_OPTION);
			
			if (looksLikeRain == JOptionPane.YES_OPTION){
				JOptionPane.showMessageDialog(null, SHOULD_BRING_UMBRELLA_AND_NOT_OPEN);
			}else if(looksLikeRain == JOptionPane.NO_OPTION){
				JOptionPane.showMessageDialog(null, SHOULD_NOT_BRING_UMBRELLA);
			}
		}
	}
}
