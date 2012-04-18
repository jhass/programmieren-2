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
		if (title == null || title.equals("")) {
			throw new IllegalArgumentException("title must not be empty");
		}
		this.title = title;
	}
	public int getReleaseYear() {
		return releaseYear;
	}
	public void setReleaseYear(int releaseYear) {
		if (releaseYear < 0) {
			throw new IllegalArgumentException("release year must be greather or equal zero");
		}
		this.releaseYear = releaseYear;
	}
	
	public abstract int getLendingPeriod();
	
	@Override
	public String toString() {
		return String.format("%s, %d", this.getTitle(), this.getReleaseYear());
	}
}
