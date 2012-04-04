package de.fhh.pr2.rpump.u.a3;

import java.util.ArrayList;

import de.fhh.pr2.rpump.u.a3.Spieler;
import de.fhh.pr2.rpump.u.a3.SpielerFactory;

public class SpielerClient {

	/**
	 * @param args
	 */
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
