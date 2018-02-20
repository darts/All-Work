public class Rational {
	private int numerator;
	private int denominator;
	
	public Rational(int numerator, int denominator) throws Exception {
		this.numerator = numerator;
		if(denominator == 0)
			throw new Exception("Divide by zero. Denominator cannot equal 0.");
		else
			this.denominator = denominator;
	}
	
	public Rational(int numerator) throws Exception {
		this(numerator, 1);
	}
	
	public Rational add(Rational rational) throws Exception {
		int newDenominator = this.denominator * rational.getDenominator();
		int newNumerator = (this.numerator * rational.getDenominator()) + (rational.getNumerator() * this.denominator);
		return new Rational(newNumerator, newDenominator);
	}
	
	public Rational subtract(Rational rational) throws Exception {
		int newDenominator = this.denominator * rational.getDenominator(); 
		int primaryNumerator = this.numerator * rational.getDenominator();
		int secondaryNumerator = rational.getNumerator() * this.denominator;
		return new Rational(primaryNumerator - secondaryNumerator, newDenominator);
	}
	
	public Rational multiply(Rational rational) throws Exception {
		return new Rational(this.numerator * rational.getNumerator(), this.denominator * rational.getDenominator());
	}
	
	public Rational divide(Rational rational) throws Exception {
		return new Rational(this.numerator * rational.getDenominator(), this.denominator * rational.getNumerator());
	}
	
	public boolean equals(Rational rational) {
		if((this.numerator * rational.getDenominator()) - (rational.getNumerator() * this.denominator) == 0)
			return true;
		return false;
	}
	
	public boolean isLessThan(Rational rational) {
		if(this.numerator * rational.getDenominator() < rational.getNumerator() * this.denominator)
			return true;
		return false;
	}
	
	public Rational simplify() {
		int greatestCommonDivisor = greatestCommonDivisor();
		this.numerator /= greatestCommonDivisor;
		this.denominator /= greatestCommonDivisor;
		return this;
	}

	private int greatestCommonDivisor() {
		int maxNum;
		if(Math.abs(this.numerator) > Math.abs(this.denominator))
			maxNum = Math.abs(this.denominator);
		else
			maxNum = Math.abs(this.numerator);
		while(maxNum > 0) {
			if(this.numerator % maxNum == 0 && this.denominator % maxNum == 0)
				return maxNum;
			maxNum--;
		}
		return -1;
	}

	public int getNumerator() {
		return numerator;
	}

	public void setNumerator(int numerator) {
		this.numerator = numerator;
	}

	public int getDenominator() {
		return denominator;
	}

	public void setDenominator(int denominator) {
		this.denominator = denominator;
	}
	
	public String toString() {
		return numerator + "/" + denominator;
	}
}
