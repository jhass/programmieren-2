package de.fhh.pr2.jhass.u.a5;

public abstract class Medium {
	private String title;
	private int releaseYear;
	
	public Medium(String title, int releaseYear) {
		this.setTitle(title);
		this.setReleaseYear(releaseYear);
	}
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		checkStringEmpty(title, "title");
		
		this.title = title;
	}
	public int getReleaseYear() {
		return releaseYear;
	}
	public void setReleaseYear(int releaseYear) {
		checkGreatherEqualThan(releaseYear, 0, "release year");
		
		this.releaseYear = releaseYear;
	}
	
	public abstract int getLendingPeriod();
	
	@Override
	public String toString() {
		return String.format("%s, %d", this.getTitle(), this.getReleaseYear());
	}
	
	protected void checkStringEmpty(String string, String argName) {
		if (string == null || string.length() == 0) {
			throw new IllegalArgumentException(argName+" must not be empty");
		}
	}
	
	protected void checkGreatherEqualThan(double num, double gt, String argName) {
		if (num < gt) {
			throw new IllegalArgumentException(argName+" must be greather or equal "+gt);
		}
	}
}
