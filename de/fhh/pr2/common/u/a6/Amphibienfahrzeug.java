package de.fhh.pr2.common.u.a6;

public class Amphibienfahrzeug implements Fahrbar, Schwimmfaehig {

	@Override
	public void schwimme() {
		System.out.println("Schwimme mit dem Amphibienfahrzeug");
		
	}

	@Override
	public void fahre() {
		System.out.println("Fahre mit dem Amphibienfahrzeug");
		
	}

}
