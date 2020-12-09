package mk.finki.ukim.mk.wp.lab.repository;

import mk.finki.ukim.mk.wp.lab.bootstrap.DataHolder;
import mk.finki.ukim.mk.wp.lab.model.Order;
import mk.finki.ukim.mk.wp.lab.model.ShoppingCart;

import java.util.List;

public class ShoppingCartRepository {
    public List<ShoppingCart> listShoppingCarts() {
        return DataHolder.shoppingCarts;
    }
    public ShoppingCart findShoppingCart(ShoppingCart s)
    {
        return DataHolder.shoppingCarts.stream().filter(shoppingCart -> shoppingCart.getId().equals(s.getId())).findFirst().get();
    }

    public ShoppingCart addToShoppingCart(Order o, ShoppingCart s)
    {
       ShoppingCart shoppingCart = findShoppingCart(s);
       shoppingCart.getOrders().add(o);
       save(shoppingCart);
       return shoppingCart;

    }
    public void save(ShoppingCart s)
    {
        DataHolder.shoppingCarts.removeIf(r->r.getId().equals(s.getId()));
        DataHolder.shoppingCarts.add(s);
    }

}
