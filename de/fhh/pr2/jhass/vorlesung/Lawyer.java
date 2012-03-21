package de.fhh.pr2.jhass.vorlesung;

public class Lawyer extends Employee {
	public Lawyer(int years) {
		super(years);
	}
	
    public String getVacationForm() {
        return "blue";
    }
    
    @Override
    public int getVacationDays() {
        return super.getVacationDays()-5;
    }
    
    public String sue() {
        return "I sue you!";
    }
}
