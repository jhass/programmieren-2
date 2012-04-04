package de.fhh.pr2.jhass.u.a3;

import java.util.ArrayList;

public class SpielerMain {
	public static void main(String[] args) {
		String[] names = {"Sepp Maier", "Berti Vogts", "Paule Breitner",
						  "Katsche Schwarzenbeck", "Franz Beckenbauer",
						  "Horst-Dieter Höttges", "Herbert Wimmer",
						  "Bernhard Cullmann", "Jürgen Grabowski",
						  "Günter Netzer", "Jupp Heynckes"};
		
		ArrayList<Spieler> players = new ArrayList<Spieler>();
	
		for (String name: names) {
			players.add(SpielerFactory.createSpieler(name));
		}
		
		System.out.println(players);
		System.out.println("Zwölfter Spieler: "+SpielerFactory.createSpieler("foobar"));

	}

}
