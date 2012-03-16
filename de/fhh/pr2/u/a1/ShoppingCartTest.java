package de.fhh.pr2.u.a1;


public class ShoppingCartTest {

    public static void main(String[] args) {
        ShoppingCart cart = new ShoppingCart();

        CartItem dogfood = new CartItem("dogfood", 4, 3.20);
        CartItem cookies = new CartItem("cookies", 4, 1.59);
        CartItem milk = new CartItem("milk", 1, 0.69);
        CartItem strawberryMarmelade = new CartItem("strawberry marmelade", 3, 2.19);

        cart.add(dogfood);
        cart.add(cookies);
        cart.add(milk);
        cart.add(strawberryMarmelade);

        dogfood.setQuantity(6);

        //System.out.printf("You gonna pay %.2f VD.\n", cart.getTotalCost());
        System.out.println(cart);

    }

}
