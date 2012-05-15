package de.fhh.pr2.rpump.u.a6;

import java.util.*;

public class MedienMain {

	public static void main(String[] args) {
		Set<Medium> medien = new HashSet<Medium>();
		Collections.addAll(medien, new Book(
				"Building Java Programs - A Back to Basics Approach", 2007,
				"Addison Wesley", "Stuart Reges, Marty Stepp"), new CD(
				"Are you Experienced?", 1967, "Jimi Hendrix", 40),
				new Magazine("Der Spiegel", 2010, 3));
		System.out.println(getMaxErscheinungsjahr(medien));

		// Sortenreines Set von Büchern
		Set<Book> buecher = new HashSet<Book>();
		Collections.addAll(buecher, new Book(
				"Building Java Programs - A Back to Basics Approach", 2007,
				"Addison Wesley", "Stuart Reges, Marty Stepp"), new Book(
				"Java ist auch eine Insel", 2009, "Christian Ullenboom",
				"Galileo Computing"));
		System.out.println(getMaxErscheinungsjahr(buecher));

		// Sortenreines Set von Zeitschriften
		Set<Magazine> zeitschriften = new HashSet<Magazine>();
		Collections.addAll(zeitschriften,
				new Magazine("Der Spiegel", 2009, 12), new Magazine(
						"Der Spiegel", 2010, 1), new Magazine("Der Spiegel",
						2010, 2));
		System.out.println(getMaxErscheinungsjahr(zeitschriften));

		Medium[] medien2 = {
				new Book("Building Java Programs - A Back to Basics Approach",
						2007, "Addison Wesley", "Stuart Reges, Marty Stepp"),
				new CD("Are you Experienced?", 1967, "Jimi Hendrix", 40),
				new Magazine("Der Spiegel", 2010, 3) };
		Arrays.sort(medien2);
		for (Medium m : medien2) {
			System.out.println(m);
		}
	}

	public static int getMaxErscheinungsjahr(Set<? extends Medium> medien) {
		return Collections.max(medien, new Comparator<Medium>() {
			@Override
			public int compare(Medium a, Medium b) {
				return new Integer(a.getReleaseYear()).compareTo(b
						.getReleaseYear());
			}
		}).getReleaseYear();
	}

}
