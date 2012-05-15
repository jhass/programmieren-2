package de.fhh.pr2.rpump.u.a3;

import de.fhh.pr2.common.*;

public class ZahlenkombiMain {
	public static void main(String[] args) {
		ZahlenkombiMitZeitmessung zombi = new ZahlenkombiMitZeitmessung(100000);
		suche(zombi);
		System.out.println(zombi.averageTime()+"ms");
	}

	private static void suche(Zahlenkombi kombi) {
		for (int i = 0; i < kombi.getMax(); i++) {
			if (kombi.istEnthalten(i)) {
				System.out.println(i);
			}
		}
	}
}
