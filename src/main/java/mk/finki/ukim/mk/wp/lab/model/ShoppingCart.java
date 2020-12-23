package mk.finki.ukim.mk.wp.lab.model;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
@Data
@Entity
public class ShoppingCart {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDateTime dateCreated;


    public ShoppingCart() {

    }
    public ShoppingCart(LocalDateTime dateCreated) {
        this.dateCreated = dateCreated;

    }

}
