package de.fhh.pr2.jhass.u.a4;

public class Bruch {
	private int numerator;
	private int denominator;
	
	public Bruch() {
		this.setNumerator(0);
		this.setDenominator(1);
	}
	
	public Bruch(int numerator, int denominator) {
		this.setNumerator(numerator);
		this.setDenominator(denominator);
	}

	private void setNumerator(int numerator) {
		this.numerator = numerator;
	}

	private void setDenominator(int denominator) throws IllegalArgumentException {
		if (denominator == 0) {
			throw new IllegalArgumentException("Denominator can't be zero");
		}
		this.denominator = denominator;
	}
	
	public int getNumerator() {
		return this.numerator;
	}
	
	public int getDenominator() {
		return this.denominator;
	}
	
	public double getDecimal() {
		return this.numerator/(double) this.denominator;
	}
	
	@Override
	public boolean equals(Object other) {
		if (other instanceof Bruch) {
			Bruch bruch = (Bruch) other;
			return ((this.getNumerator() == bruch.getNumerator()) && 
					(this.getDenominator() == bruch.getDenominator()));
		} else {
			return false;
		}
	}
	
	@Override
	public int hashCode() {
		return (int) (this.getDecimal()*1000);
	}
}
