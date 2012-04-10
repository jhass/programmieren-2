package de.fhh.pr2.jhass.u.a3;

import java.util.ArrayList;

import de.fhh.pr2.common.Zahlenkombi;

public class ZahlenkombiMitZeitmessung extends Zahlenkombi {
	private ArrayList<Integer> neededTimes;

	public ZahlenkombiMitZeitmessung(int max) {
		super(max);
		this.neededTimes = new ArrayList<Integer>();
	}
	
	@Override
	public boolean istEnthalten(int i) {
		long start = System.currentTimeMillis();
		boolean enthalten = super.istEnthalten(i);
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
