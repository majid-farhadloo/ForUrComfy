package com.example.majid.forurcomfy;
<<<<<<< HEAD
import java.util.List;
import java.util.Vector;

import android.content.res.Resources;

public class ShoppingCartHelper {
=======

import android.content.res.Resources;

import java.util.List;
import java.util.Vector;

public class ShoppingCartHelper {

>>>>>>> Shopping Cart internal Catalog no firebase
    public static final String PRODUCT_INDEX = "PRODUCT_INDEX";

    private static List<Product> catalog;
    private static List<Product> cart;

    public static List<Product> getCatalog(Resources res){
        if(catalog == null) {
            catalog = new Vector<Product>();
<<<<<<< HEAD
            catalog.add(new Product("Dead or Alive", res  //examples of how to add products of course these will be menu items but it will have something like this
                    .getDrawable(R.drawable.deadoralive),
                    "Dead or Alive by Tom Clancy with Grant Blackwood", 29.99));
            catalog.add(new Product("Switch", res
                    .getDrawable(R.drawable.switchbook),
                    "Switch by Chip Heath and Dan Heath", 24.99));
            catalog.add(new Product("Watchmen", res
                    .getDrawable(R.drawable.watchmen),
                    "Watchmen by Alan Moore and Dave Gibbons", 14.99));
=======
            catalog.add(new Product("Artichokes", res
                    .getDrawable(R.drawable.artichokes),
                    "Aritchokes made by chef JP", 29.99));
            catalog.add(new Product("Switch", res
                    .getDrawable(R.drawable.apple_pie),
                    "Apple pie by chef JP", 24.99));
            catalog.add(new Product("Watchmen", res
                    .getDrawable(R.drawable.berry_tart),
                    "Berry tart by chef JP", 14.99));
>>>>>>> Shopping Cart internal Catalog no firebase
        }

        return catalog;
    }

    public static List<Product> getCart() {
        if(cart == null) {
            cart = new Vector<Product>();
        }

        return cart;
    }
<<<<<<< HEAD
}
=======

}
>>>>>>> Shopping Cart internal Catalog no firebase
