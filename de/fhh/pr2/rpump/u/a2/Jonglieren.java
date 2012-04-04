package de.fhh.pr2.rpump.u.a2;

public class Jonglieren extends Ballspiel {
	@Override
	public int getMannschaften(){
		return 1;
		}
	
	@Override
	public int getBaelle(){
		return 5;
	}
	
	public String getLernregel(){
		return "Üben, üben, üben!";
	}
}
