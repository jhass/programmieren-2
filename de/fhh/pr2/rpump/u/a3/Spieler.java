package de.fhh.pr2.rpump.u.a3;

public class Spieler {
	private int ryckennummer;
	private String name;
	
	public Spieler(int ryckennummer, String name){
		this.ryckennummer = ryckennummer;
		this.name = name;
	}
	
	public String toString(){
		return name+" ("+ryckennummer+")";
	}

}
