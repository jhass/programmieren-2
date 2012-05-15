package de.fhh.pr2.common.u.a6;

public class AmphiMain {
	public static void main(String[] args) {
		Fahrbar[] fahrzeuge= { new Pkw(), new Amphibienfahrzeug() };
		Schwimmfaehig[] schwimmzeuge= { new Boot(), new Amphibienfahrzeug() };
		for (int i=0; i<fahrzeuge.length; i++) {
			fahrzeuge[i].fahre();
		}
		for (int i=0; i<schwimmzeuge.length; i++) {
			schwimmzeuge[i].schwimme();
		}
	}
}

