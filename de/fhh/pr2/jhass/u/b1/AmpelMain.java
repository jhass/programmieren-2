package de.fhh.pr2.jhass.u.b1;

public class AmpelMain {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] phasesWO = {3, 1, 6, 1};
		int[] phasesNS = {6, 1, 3, 1};
		Ampel ampelWO = new Ampel("West-Ost", phasesWO, Ampel.Phase.RED);
		Ampel ampelNS = new Ampel("Nord-Süd", phasesNS, Ampel.Phase.GREEN);
		ampelWO.setOtherAmpel(ampelNS);
		ampelNS.setOtherAmpel(ampelWO);
		ampelWO.start();
		ampelNS.start();

	}

}
