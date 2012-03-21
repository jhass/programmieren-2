package de.fhh.pr2.common.u.a2;

public class Fussball extends Ballspiel {
	@Override
	public int getSpieldauer() {
		return 90;
	}
	
	public String einwurfRegel() {
		return "Ball darf in die Hand genommen werden";
	}
	
	public String eckRegel() {
		return "Mindestabstand anderer Spieler: 9,15 m";
	}
}
