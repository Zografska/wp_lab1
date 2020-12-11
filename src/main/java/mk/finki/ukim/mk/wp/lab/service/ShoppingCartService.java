package mk.finki.ukim.mk.wp.lab.service;

import mk.finki.ukim.mk.wp.lab.model.ShoppingCart;

public interface ShoppingCartService {
     ShoppingCart create();
     void addProductToShoppingCart(String username);

}
