package mk.finki.ukim.mk.wp.lab.model;

import lombok.Data;

import javax.persistence.*;
import java.util.Random;

@Data
@Entity
@Table(name = "OrdersPls")
public class Order {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    Long orderId;
    String balloonColor;
    String balloonSize;
    @ManyToOne
    private User user;


    public Order(String balloonColor, String balloonSize, User user) {
        this.balloonColor = balloonColor;
        this.balloonSize = balloonSize;
        this.user=user;
    }

    public Order() {
    }
}
