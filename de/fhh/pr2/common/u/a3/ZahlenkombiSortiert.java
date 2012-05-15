package de.fhh.pr2.common.u.a3;

import java.util.ArrayList;
import java.util.Arrays;

import de.fhh.pr2.common.Zahlenkombi;

public class ZahlenkombiSortiert extends Zahlenkombi {
	private int[] sortedZahlen;
	private ArrayList<Integer> neededTimes;

	public ZahlenkombiSortiert(int max) {
		super(max);
		this.neededTimes = new ArrayList<Integer>();
	}
	
	@Override
	public boolean istEnthalten(int zahl) {
		long start = System.currentTimeMillis();
		if (this.sortedZahlen == null) {
			this.sortedZahlen = this.getZahlenArray();
			Arrays.sort(this.sortedZahlen);
		}
		
		boolean enthalten = (Arrays.binarySearch(this.sortedZahlen, zahl) >= 0);
		this.neededTimes.add((int) (System.currentTimeMillis()-start));
		return enthalten;
	}
	
	public double getAverageNeededTime() {
		double sum = 0;
		for(int time : this.neededTimes) {
			sum += time;
		}
		
		return sum/this.neededTimes.size();
	}
}



