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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Long getId() {
        return id;
    }

    public Manufacturer getManufacturer() {
        return manufacturer;
    }
}
