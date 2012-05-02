package de.fhh.pr2.rpump.u.a3;

import java.util.*;

import de.fhh.pr2.common.*;

public class ZahlenKombisortiert extends Zahlenkombi {
	private int[] sortedArray;
	private ArrayList<Integer> aufrufZeiten= new ArrayList<Integer>();

	public ZahlenKombisortiert(int max) {
		super(max);
	}
	
	@Override
	public boolean istEnthalten(int zahl) {
		long start = System.currentTimeMillis();
		if(sortedArray == null) {
			sortedArray = this.getZahlenArray();
			java.util.Arrays.sort(sortedArray);
		}
		int found = java.util.Arrays.binarySearch(sortedArray, zahl);
		long stop = System.currentTimeMillis();
		aufrufZeiten.add((int) (stop - start));
		return (found>0);
	}
	
	public double averageTime() {
		double sum = 0;
		for(int i : aufrufZeiten) {
			sum += i;
		}
		return (sum/aufrufZeiten.size());
	}

}
