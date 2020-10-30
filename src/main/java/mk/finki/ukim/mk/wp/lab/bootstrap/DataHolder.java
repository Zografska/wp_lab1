package mk.finki.ukim.mk.wp.lab.bootstrap;


import lombok.Getter;
import mk.finki.ukim.mk.wp.lab.model.Balloon;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Component
@Getter
public class DataHolder {
    public static List<Balloon> balloonList = new ArrayList<>();
    @PostConstruct
    public void init(){
        balloonList.add(new Balloon("Happy","Has smiles on it"));
        balloonList.add(new Balloon("Sad","Has tears on it"));
        balloonList.add(new Balloon("Bad","El Diablo"));
        balloonList.add(new Balloon("Nice",":D"));
    }
}
