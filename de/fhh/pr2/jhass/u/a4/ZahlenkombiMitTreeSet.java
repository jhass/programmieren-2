package de.fhh.pr2.jhass.u.a4;

import java.util.Random;
import java.util.TreeSet;

public class ZahlenkombiMitTreeSet implements IZahlenkombi {
	private int max;
	private TreeSet<Integer> zahlen;
	
	public ZahlenkombiMitTreeSet(int max) {
		this.setMax(max);
		this.zahlen = new TreeSet<Integer>();
		Random generator = new Random();
		for (int i=0; i<10000; i++) {
			this.zahlen.add(generator.nextInt(this.max));
		}
	}
	
	private void setMax(int max) {
		this.max = max;
	}

	@Override
	public boolean istEnthalten(int n) {
		return this.zahlen.contains(n);
	}

	@Override
	public int getMax() {
		return this.max;
	}

}
