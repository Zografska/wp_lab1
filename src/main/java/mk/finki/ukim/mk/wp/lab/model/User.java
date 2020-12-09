package mk.finki.ukim.mk.wp.lab.model;

import lombok.Data;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Data
public class User {
    private Long id;
    private String username;
    private String password;
    private ShoppingCart shoppingCart;

    public User(String username, String password) {
        Random r = new Random();
        this.id = r.nextLong()*1000;
        this.username = username;
        this.password = password;
        this.shoppingCart = new ShoppingCart(this, LocalDateTime.now(),new ArrayList<>());
    }
}
