package de.fhh.pr2.jhass.vorlesung;

public class Employee {
	private int years;
	
	public Employee() {
		this.setYears(0);
	}
	
	public Employee(int years) {
		this.setYears(years);
	}
	
	public void setYears(int years) {
		this.years = years;
	}
	
	public int getYears() {
		return this.years;
	}
	
	// works 40 hours / week
	public int getHours() {
		return 40;
	}
	
	public double getBaseSalary() {
		return 400000.0;
	}
	
	// 40,000.00 / year
	public double getSalary() {
		return this.getBaseSalary();
	}
	
	// 6 weeks' paid vacation
	public int getVacationDays() {
		return 30+this.getBonusVacationDays();
	}
	
	public int getBonusVacationDays() {
		return this.getYears()*2;
	}
	
	// use the yellow form
	public String getVacationForm() {
		return "yellow";
	}
}
