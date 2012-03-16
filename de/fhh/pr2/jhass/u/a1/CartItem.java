package de.fhh.pr2.jhass.u.a1;

public class CartItem {
	private String name;
	private int quantity;
	private double pricePerUnit;
	
	public CartItem(String name, int quantity, double pricePerUnit) {
		this.setName(name);
		this.setQuantity(quantity);
		this.setPricePerUnit(pricePerUnit);
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public void setQuantity(int quantity) throws IllegalArgumentException {
		if (quantity < 1) {
			throw new IllegalArgumentException("You can't put 0 "+this.name+" into your cart!");
		}
		this.quantity = quantity;
	}
	
	public void setPricePerUnit(double pricePerUnit) {
		this.pricePerUnit = pricePerUnit;
	}
	
	public double getCost() {
		return this.pricePerUnit*this.quantity;
	}
	
	public String toString() {
		return String.format("  %d x %-50s%05.2f\t%05.2f%n",
				this.quantity, this.name,
				this.pricePerUnit, this.getCost());
	}
}
