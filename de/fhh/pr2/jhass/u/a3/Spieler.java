package de.fhh.pr2.jhass.u.a3;

public class Spieler {
	private String name;
	private int number;
	
	public Spieler(String name, int number) {
		this.setName(name);
		this.setNumber(number);
	}
	
	private void setName(String name) {
		this.name = name;
	}
	
	private void setNumber(int number) {
		this.number = number;
	}
	
	public String getName() {
		return this.name;
	}
	
	public int getNumber() {
		return this.number;
	}
	
	public String toString() {
		return this.getName()+" ("+this.getNumber()+")";
	}
}
