package mk.finki.ukim.mk.wp.lab.model;

import lombok.Data;

import java.util.Random;

@Data
public class Order {
    String balloonColor;
    String balloonSize;
    private User user;
    Long orderId;

    public Order(String balloonColor, String balloonSize, User user) {
        this.balloonColor = balloonColor;
        this.balloonSize = balloonSize;
        this.user=user;
        Random r = new Random();
        this.orderId = r.nextLong();
    }
}
