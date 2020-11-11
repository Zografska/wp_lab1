package mk.finki.ukim.mk.wp.lab.model.exceptions;

public class ManufacturerNotFoundException extends RuntimeException{
    public ManufacturerNotFoundException(Long id){
        super(String.format("Manufacturer with id %s not found",id.toString()));
    }
}
