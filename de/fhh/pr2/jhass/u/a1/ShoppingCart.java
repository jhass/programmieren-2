package de.fhh.pr2.jhass.u.a1;

import java.util.ArrayList;

public class ShoppingCart {
	private ArrayList<CartItem> items;
	
	public ShoppingCart() {
		this.items = new ArrayList<CartItem>();
	}
	
	public void add(CartItem item) {
		this.items.add(item);
	}
	
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
		bon.append(String.format("Sum:%-54s\t%05.2f%n", "", this.getTotalCost()));
		return bon.toString();
	}
}
