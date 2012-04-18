package de.fhh.pr2.jhass.u.a5;

public class Book extends Medium {
	private String publisher;
	private String author;
	
	public Book(String title, int releaseYear, String publisher, String author) {
		super(title, releaseYear);
		this.setPublisher(publisher);
		this.setAuthor(author);
	}
	
	public String getPublisher() {
		return publisher;
	}
	
	public void setPublisher(String publisher) {
		if (publisher == null || publisher.equals("")) {
			throw new IllegalArgumentException("publisher must not be empty");
		}
		
		this.publisher = publisher;
	}
	
	public String getAuthor() {
		return author;
	}
	
	public void setAuthor(String author) {
		if (author == null || author.equals("")) {
			throw new IllegalArgumentException("author must not be empty");
		}
		
		this.author = author;
	}
	
	@Override
	public int getLendingPeriod() {
		return 28;
	}
	
	@Override
	public String toString() {
		return String.format("%s: %s (%d) %s", this.getAuthor(), this.getTitle(),
							 this.getReleaseYear(), this.getPublisher());
	}
}
