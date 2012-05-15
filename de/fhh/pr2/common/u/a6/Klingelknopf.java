package de.fhh.pr2.common.u.a6;

public class Klingelknopf extends BeobachtetesObjekt {
	private boolean istGedrueckt = false;
	
	public void knopfDruecken() {
		this.istGedrueckt = true;
		this.informiereBeobachter();
	}
	
	public void knopfLoslassen() {
		this.istGedrueckt = false;
		this.informiereBeobachter();
	}
	
	@Override
	public String getZustand() {
		if (this.istGedrueckt) {
			return "gedrückt";
		} else {
			return "losgelassen";
		}
	}

}
