package de.fhh.pr2.jhass.u.b1;

public class AmpelMain {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] phasesWO = {3, 1, 6, 1};
		int[] phasesNS = {6, 1, 3, 1};
		Ampel ampelWO = new Ampel("West-Ost", phasesWO, 2);
		Ampel ampelNS = new Ampel("Nord-Süd", phasesNS, 0);
		ampelWO.setOtherAmpel(ampelNS);
		ampelNS.setOtherAmpel(ampelWO);
		ampelWO.start();
		ampelNS.start();

	}

}
