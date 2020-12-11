package mk.finki.ukim.mk.wp.lab.service.impl;

import mk.finki.ukim.mk.wp.lab.model.ShoppingCart;
import mk.finki.ukim.mk.wp.lab.repository.jpa.JpaShoppingCartRepository;
import mk.finki.ukim.mk.wp.lab.service.ShoppingCartService;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class ShoppingCartServiceImpl implements ShoppingCartService {
    JpaShoppingCartRepository shoppingCartRepository;

    public ShoppingCartServiceImpl(JpaShoppingCartRepository shoppingCartRepository) {
        this.shoppingCartRepository = shoppingCartRepository;
    }

    @Override
    public ShoppingCart create() {
       return shoppingCartRepository.save(new ShoppingCart(LocalDateTime.now()));
    }

    @Override
    public void addProductToShoppingCart(String username) {

    }


}
