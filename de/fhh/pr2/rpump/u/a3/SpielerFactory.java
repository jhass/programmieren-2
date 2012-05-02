package de.fhh.pr2.rpump.u.a3;

public class SpielerFactory {
	private static int counter = 0;
	public static Spieler createSpieler(String name){
		if(counter < 11){
			counter++;
			return new Spieler(counter, name);
		}
		return null;
	}

}
