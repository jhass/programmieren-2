package de.fhh.pr2.rpump.u.a2;

public class Handball extends Ballspiel {
	@Override
	public int getSpieldauer(){
		return 60;
	}
	
	public String getZeitRegel(){
		return "Zeitstrafe bei schwerem Regelverstoß.";
	}
	
}
