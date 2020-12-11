package mk.finki.ukim.mk.wp.lab.model;

import lombok.Data;

import javax.persistence.*;
import java.util.Random;
@Data
@Entity
public class Balloon {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String name;
    String description;
    @ManyToOne
    Manufacturer manufacturer;

    public Balloon(String name, String description, Manufacturer manufacturer) {
        Random r = new Random();
        this.id = r.nextLong()*1000;
        this.name = name;
        this.description = description;
        this.manufacturer = manufacturer;
    }

    public Balloon() {

    }
}
