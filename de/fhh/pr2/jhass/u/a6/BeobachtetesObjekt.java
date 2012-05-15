package de.fhh.pr2.jhass.u.a6;

public abstract class BeobachtetesObjekt {
	public abstract String getZustand();
	
	private Beobachter beobachter;
	public void setBeobachter(Beobachter beobachter) {
		this.beobachter = beobachter;
	}
	
	public void informiereBeobachter() {
		if (this.beobachter != null) {
			this.beobachter.update(this);
		}
	}
}
