public class Rational {
	private int numerator;
	private int denominator;
	
	public Rational(int numerator, int denominator) {
		this.numerator = numerator;
		this.denominator = denominator;
	}
	
	public Rational(int numerator) {
		this(numerator, 1);
	}
	
}
