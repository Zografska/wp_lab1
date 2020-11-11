package mk.finki.ukim.mk.wp.lab.bootstrap;


import lombok.Getter;
import mk.finki.ukim.mk.wp.lab.model.Balloon;
import mk.finki.ukim.mk.wp.lab.model.Manufacturer;
import mk.finki.ukim.mk.wp.lab.model.User;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Component
@Getter
public class DataHolder {
    public static List<Balloon> balloonList = new ArrayList<>();
    public static List<User> userList = new ArrayList();
    public static List<Manufacturer> manufacturerList = new ArrayList();
    @PostConstruct
    public void init(){
        Manufacturer  manufacturer = new Manufacturer("Nike","America", "NY");
        balloonList.add(new Balloon("Happy","Has smiles on it",manufacturer));
        balloonList.add(new Balloon("Sad","Has tears on it",manufacturer));
        manufacturerList.add(manufacturer);
        manufacturer = new Manufacturer("Adidas","America","Boston");
        manufacturerList.add(manufacturer);
        balloonList.add(new Balloon("Funny","Has jokes on it",manufacturer));
        balloonList.add(new Balloon("Bad","El Diablo",manufacturer));
        balloonList.add(new Balloon("Nice",":D",manufacturer));
        balloonList.add(new Balloon("Annoying","BlaBla",manufacturer));
        userList.add(new User("alex","alex","Aleksandra","Bul.Avnoj"));
    }
}
