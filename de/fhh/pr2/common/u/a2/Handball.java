package de.fhh.pr2.common.u.a2;

public class Handball extends Ballspiel {
	@Override
	public int getSpieldauer() {
		return 60;
	}
	
	public String getSonderregel() {
		return "Zeitstrafe bei schwerem Regelverstoß";
	}
}
