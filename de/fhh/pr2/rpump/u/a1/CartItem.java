package de.fhh.pr2.rpump.u.a1;

public class CartItem {
	private String name;
	private int quantity;
	private double pricePerUnit;
	
	
	public CartItem(String iName, int iQuantity, double iPricePerUnit) {
		name = iName;
		quantity = iQuantity;
		pricePerUnit = iPricePerUnit;
	}
	
	public double getCost() {
		return quantity*pricePerUnit;
	}
	
	public String getName() {
		return name;
	}
	
	public void setQuantity(int i) {
		if(i<1){
			System.out.println("Quantity can't be negative!");
		}else{
			quantity = i;
		}
	}
	public String toString() {
		return String.format("%4d x %-30s %8.2f %10.2f %n", quantity, name, pricePerUnit, getCost()); 
	}

}
