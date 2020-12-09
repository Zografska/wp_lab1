package mk.finki.ukim.mk.wp.lab.model;

import lombok.Data;

import java.util.Random;
@Data
public class Balloon {
    Long id;
    String name;
    String description;
    Manufacturer manufacturer;

    public Balloon(String name, String description, Manufacturer manufacturer) {
        Random r = new Random();
        this.id = r.nextLong()*1000;
        this.name = name;
        this.description = description;
        this.manufacturer = manufacturer;
    }

}
