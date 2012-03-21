package de.fhh.pr2.common.u.a1;


public class ShoppingCartMain {

    public static void main(String[] args) {
        ShoppingCart cart = new ShoppingCart();

        CartItem dogfood = new CartItem("Hundefutter", 4, 3.20);
        CartItem cookies = new CartItem("Kekse", 4, 1.59);
        CartItem milk = new CartItem("Milch", 1, 0.69);
        CartItem strawberryMarmelade = new CartItem("Erdbeermarmelade", 3, 2.19);

        cart.add(dogfood);
        cart.add(cookies);
        cart.add(milk);
        cart.add(strawberryMarmelade);

        dogfood.setQuantity(6);

        System.out.println(cart);

    }

}
