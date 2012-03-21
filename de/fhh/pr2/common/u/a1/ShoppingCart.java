package de.fhh.pr2.common.u.a1;

import java.util.ArrayList;


/**
 * Small wrapper to manage CartItems
 * 
 * @author Jonne Haß
 * @author Richard Pump
 *
 */
public class ShoppingCart {
	private ArrayList<CartItem> items;
	
	public ShoppingCart() {
		this.items = new ArrayList<CartItem>();
	}
	
	
	/**
	 * Adds a new item to the cart.
	 * 
	 * @param item the CartItem
	 */
	public void add(CartItem item) {
		this.items.add(item);
	}
	
	/**
	 * Gets the total cost of all items in the cart.
	 * 
	 * @return the sum of all items in the cart
	 */
	public double getTotalCost() {
		double sum = 0;
		for (CartItem item: this.items) {
			sum += item.getCost();
		}
		return sum;
	}
	
	public String toString() {
		StringBuilder bon = new StringBuilder();
		for (CartItem item: this.items) {
			bon.append(item);
		}
		bon.append(String.format("%n%-64s%6.2f%n", "Summe:", this.getTotalCost()));
		return bon.toString();
	}
}
