package de.fhh.pr2.rpump.u.a5;

public class MedienMain {

	public static void main(String[] args) {
		Medium[] medien = {
				new Book("Building Java Programs -A Back to Basics Approach",
						 2007, "Addison Wesley", "Stuart Reges, Marty Stepp"),
				new CD("Are you Experienced?", 1967, "Jimi Hendrix", 40),
				new Magazine("Der Spiegel", 2010, 3)
		};
		
		for (Medium m : medien) {
			System.out.println(m);
			System.out.println(" Leihfirst: "+m.getLendingPeriod());
		}
	}

}
