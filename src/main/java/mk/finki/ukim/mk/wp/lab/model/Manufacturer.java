package mk.finki.ukim.mk.wp.lab.model;

import lombok.Data;

import java.util.Random;

@Data
public class Manufacturer {
    private Long id;
    private String name;
    private String country;
    private String address;

    public Manufacturer(String name, String country, String address) {
        this.name = name;
        this.country = country;
        this.address = address;
        Random r = new Random();
        this.id = r.nextLong()*1000;
    }
}
