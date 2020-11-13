package mk.finki.ukim.mk.wp.lab.repository;


import mk.finki.ukim.mk.wp.lab.bootstrap.DataHolder;
import mk.finki.ukim.mk.wp.lab.model.Balloon;
import mk.finki.ukim.mk.wp.lab.model.Manufacturer;
import org.springframework.stereotype.Repository;

import javax.xml.crypto.Data;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
public class BalloonRepository {
    public List<Balloon> findAllBalloons(){
        return DataHolder.balloonList;
    }
    public List<Balloon> findAllByNameOrDescription(String searchText){
        return DataHolder.balloonList.stream()
                .filter(balloon ->
                        balloon.getName()
                            .contains(searchText)
                        ||
                        balloon.getDescription()
                                .contains(searchText))
                .collect(Collectors.toList());
    }
    public Balloon saveOrUpdate(Balloon balloon){
        DataHolder.balloonList.removeIf(b -> b.getName().equals(balloon.getName()));
        DataHolder.balloonList.add(balloon);
        return balloon;
    }
    public void deleteBalloon(Long id){
        DataHolder.balloonList.removeIf(balloon -> balloon.getId().equals(id));
    }
    public Optional<Balloon> getBalloonById(Long id){
        return DataHolder.balloonList.stream().filter(balloon -> balloon.getId().equals(id)).findFirst();
    }
}
