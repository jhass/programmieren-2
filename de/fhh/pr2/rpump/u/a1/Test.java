package de.fhh.pr2.rpump.u.a1;

public class Test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			//Aufgabe 4:
/*	Point p1 = new Point(2,2);
			Point p2 = new Point(4,2);
			
			System.out.print("Abstand = "+p1.manhattanDistance(p2));
*/
			//Aufgabe 5:
			ShoppingCart Hugo = new ShoppingCart();
			CartItem Dogfood = new CartItem("Hundefutter", 4, 3.20);
			Hugo.add(Dogfood);
			Hugo.add(new CartItem("Kekse", 4, 1.59));
			Hugo.add(new CartItem("Milch", 1, 0.69));
			Hugo.add(new CartItem("Erbeerkonfituere", 3, 2.19));
			Hugo.setItemAmountbyName("Milch",2);
			Hugo.getItembyName("Kekse").setQuantity(5);
			Dogfood.setQuantity(6);
			//System.out.println("Gesamtkosten: "+Hugo.getTotalCost()+" Euro");
			
			//Aufgabe 6:
			System.out.print(Hugo);
		} catch (NullPointerException NoItem) {
			System.out.print("Item not found with that name. ");
		}
	}

}
