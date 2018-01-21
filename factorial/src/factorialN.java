
public class factorialN {

	public static void main(String[] args) {
		System.out.print(computeFactorialN(10));
	}
	
	//Returns 1 if input is negative or zero.
	public static int computeFactorialN(int number) {
		int factorial = 1;
		if (number > 0) 
			factorial = number * computeFactorialN(number - 1);
		return factorial;
	}

}
