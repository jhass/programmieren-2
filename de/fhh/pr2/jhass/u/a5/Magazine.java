package de.fhh.pr2.jhass.u.a5;

public class Magazine extends Medium {
	private int number;
	
	public Magazine(String title, int releaseYear, int number) {
		super(title, releaseYear);
		this.setNumber(number);
	}
	
	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		checkGreatherEqualThan(number, 1, "number");
		
		this.number = number;
	}

	@Override
	public int getLendingPeriod() {
		return 7;
	}
	
	@Override
	public String toString() {
		return String.format("%s (%d/%d)", this.getTitle(), this.getNumber(),
							 this.getReleaseYear());
	}

}
