package de.fhh.pr2.common.u.a3;

public class SpielerFactory {
	private static int currentNumber = 0;
	
	public static Spieler createSpieler(String name) {
		if (SpielerFactory.currentNumber >= 11) {
			return null;
		}
		return new Spieler(name, ++SpielerFactory.currentNumber);
	}
}
