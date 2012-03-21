package de.fhh.pr2.common.u.a1;

/**
 * A CartItem represents a possible item in the cart with its price
 * per unit and quantity
 * 
 * @author Jonne Haß
 * @author Richard Pump 
 *
 */
public class CartItem {
	private String name;
	private int quantity;
	private double pricePerUnit;
	
	/**
	 * Constructs a new CartItem.
	 * 
	 * @param name
	 * @param quantity
	 * @param pricePerUnit
	 */
	public CartItem(String name, int quantity, double pricePerUnit) {
		this.setName(name);
		this.setQuantity(quantity);
		this.setPricePerUnit(pricePerUnit);
	}
	
	/**
	 * Sets the name.
	 * 
	 * @param name
	 */
	public void setName(String name) {
		this.name = name;
	}
	
	/**
	 * Sets the quantity.
	 * 
	 * Ensures that quantity is at least one, throws IllegalArgumentException if not.
	 * 
	 * @param quantity
	 * @throws IllegalArgumentException
	 */
	public void setQuantity(int quantity) throws IllegalArgumentException {
		if (quantity < 1) {
			throw new IllegalArgumentException("You can't put 0 "+this.name+" into your cart!");
		}
		this.quantity = quantity;
	}
	
	/**
	 * Sets the price per unit.
	 * 
	 * @param pricePerUnit
	 */
	public void setPricePerUnit(double pricePerUnit) {
		this.pricePerUnit = pricePerUnit;
	}
	
	/**
	 * Gets the total cost of this item.
	 * 
	 * @return the total cost of this item
	 */
	public double getCost() {
		return this.pricePerUnit*this.quantity;
	}
	
	public String toString() {
		return String.format("  %d x %-50s%5.2f%9.2f%n",
				this.quantity, this.name,
				this.pricePerUnit, this.getCost());
	}
}
