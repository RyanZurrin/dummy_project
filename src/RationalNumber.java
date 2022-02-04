public class RationalNumber {
	private int numerator; // numerator of the rational number
	private int denominator; // denominator of the rational number

	RationalNumber() {
		numerator = 0;
		denominator = 1;
	}
	RationalNumber(final int numerator, final int denominator) {
		if ( denominator == 0 ) {
			throw new IllegalArgumentException("Denominator cannot be zero");
		} else if (denominator < 0) {
			this.numerator = numerator*-1;
			this.denominator = denominator*-1;
		} else {
			this.numerator = numerator;
			this.denominator = denominator;
		}
	}
	// Gets the numerator of the rational number
	public int getNumerator() {
		return numerator;
	}
	// Gets the denominator of the rational number
	public int getDenominator() {
		return denominator;
	}
	// Sets the numerator of the rational number
	public void setNumerator(final int numerator) {
		this.numerator = numerator;
	}
	// Sets the denominator of the rational number
	public void setDenominator(final int denominator) {
		this.denominator = denominator;
	}
	// Adds two rational numbers
	RationalNumber add(final RationalNumber other) {
		return new RationalNumber(numerator*other.denominator +
				other.numerator*denominator, denominator*other.denominator);
	}
	// Subtracts two rational numbers
	RationalNumber subtract(final RationalNumber other) {
		return new RationalNumber(numerator*other.denominator -
				other.numerator*denominator, denominator*other.denominator);
	}
	// Multiplies two rational numbers
	RationalNumber multiply(final RationalNumber other) {
		return new RationalNumber(numerator*other.numerator,
				denominator*other.denominator);
	}
	// Divides two rational numbers
	RationalNumber divide(final RationalNumber other) {
		return new RationalNumber(numerator*other.denominator,
				denominator*other.numerator);
	}
	// Returns the reciprocal of the rational number
	RationalNumber reciprocal() {
		return new RationalNumber(denominator, numerator);
	}
	// returns the string representation of the rational number
	public String toString() {
		return numerator + "/" + denominator;
	}

	// main method to test the RationalNumber class
	public static void main(String[] args) {
		RationalNumber r1 = new RationalNumber(1, 2);
		RationalNumber r2 = new RationalNumber(2, 3);
		RationalNumber r3 = r1.add(r2);
		System.out.println(r1 + " + " + r2 + " = " + r3);
		r3 = r1.subtract(r2);
		System.out.println(r1 + " - " + r2 + " = " + r3);
		r3 = r1.multiply(r2);
		System.out.println(r1 + " * " + r2 + " = " + r3);
		r3 = r1.divide(r2);
		System.out.println(r1 + " / " + r2 + " = " + r3);
		r3 = r1.reciprocal();
		System.out.println("1 / " + r1 + " = " + r3);
	}
}
