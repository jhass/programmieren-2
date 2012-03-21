package de.fhh.pr2.rpump.u.a1;

import java.util.ArrayList;

public class ShoppingCart {
	private ArrayList<CartItem> Stuff = new ArrayList<CartItem>();
	
		
	public void add(CartItem item) {
		Stuff.add(item);
	}
	
		
	public double getTotalCost() {
		if(Stuff.size() == 0){
			return 0.0;
		}else{
			double sum = Stuff.get(0).getCost();
			for(int i = 1; i<Stuff.size(); i++){
				sum += Stuff.get(i).getCost();
			}
			sum=((double)((int)(sum*100)/1)/100);
			
			return sum;
		}
	}

	public String toString() {
		StringBuilder Sb = new StringBuilder();
		for(int i = 0; i<Stuff.size(); i++)
		{
			Sb.append(Stuff.get(i));
		}
		
		Sb.append(String.format("%n %-46s %10.2f", "Gesamt:",getTotalCost())); 
		return Sb.toString();
	}

	public CartItem getItembyName(String name) throws NullPointerException {
		for(int i = 0; i<Stuff.size(); i++){
			if(Stuff.get(i).getName().equals(name)) {
				return Stuff.get(i);
			}
		}
		return null;
	}
	
	public void setItemAmountbyName(String name, int i) {
		this.getItembyName(name).setQuantity(i);
	}
}