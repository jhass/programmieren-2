package de.fhh.pr2.rpump.u.a2;

public class Fussball extends Ballspiel{
	@Override
	public int getSpieldauer(){
		return 90;
	}
	public String einwurfRegel(){
		return "Ball darf in die Hand genommen werden.";
	}
	public String eckRegel(){
		return "Andere Spieler müssen mindestens 9,15m entfernt sein.";
	}

}
