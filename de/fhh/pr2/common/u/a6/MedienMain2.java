package de.fhh.pr2.common.u.a6;

import java.util.Arrays;

import de.fhh.pr2.jhass.u.a5.Book;
import de.fhh.pr2.jhass.u.a5.CD;
import de.fhh.pr2.jhass.u.a5.Magazine;
import de.fhh.pr2.jhass.u.a5.Medium;

public class MedienMain2 {
	public static void main(String[] args) {
		Medium[] medien= {
			new Book("Building Java Programs - A Back to Basics Approach",
				2007, "Addison Wesley", "Stuart Reges, Marty Stepp"),
			new CD("Are you Experienced?", 1967, "Jimi Hendrix", 40),
			new Magazine("Der Spiegel", 2010, 3)
		};
		
		Arrays.sort(medien);
		for (Medium m : medien) {
			System.out.println(m);
		}
	}
}
