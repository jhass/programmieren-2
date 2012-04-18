package de.fhh.pr2.jhass.u.a5;

public class CD extends Medium {
	private String artist;
	private int duration;

	public CD(String title, int releaseYear, String artist, int duration) {
		super(title, releaseYear);
		this.setArtist(artist);
		this.setDuration(duration);
	}
	
	public String getArtist() {
		return artist;
	}

	public void setArtist(String artist) {
		checkStringEmpty(artist, "artist");
		
		this.artist = artist;
	}


	public int getDuration() {
		return duration;
	}


	public void setDuration(int duration) {
		checkGreatherEqualThan(duration, 1, "duration");
		
		this.duration = duration;
	}

	@Override
	public int getLendingPeriod() {
		return 14;
	}
	
	@Override
	public String toString() {
		return String.format("%s: %s (%d) %d Minuten", this.getArtist(),
							 this.getTitle(), this.getReleaseYear(), this.getDuration());
	}
}
