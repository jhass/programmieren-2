package de.fhh.pr2.rpump.u.a3;

import java.util.ArrayList;

import de.fhh.pr2.common.*;

public class ZahlenkombiMitZeitmessung extends Zahlenkombi{
	private ArrayList<Integer> aufrufZeiten= new ArrayList<Integer>();
	
	public ZahlenkombiMitZeitmessung(int max) {
		super(max);
		
	}
	
	@Override
	public boolean istEnthalten(int zahl){
		
		long start = System.currentTimeMillis();
		boolean temp = super.istEnthalten(zahl);
		long stop = System.currentTimeMillis();
		
		aufrufZeiten.add((int) (stop - start));
		
		return temp;
	}
	
	public double averageTime(){
		double sum = 0;
		for(int i : aufrufZeiten){
			sum += i;
		}
		return (sum/aufrufZeiten.size());
	}

}
