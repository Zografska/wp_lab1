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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}