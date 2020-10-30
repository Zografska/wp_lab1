package mk.finki.ukim.mk.wp.lab.repository;


import mk.finki.ukim.mk.wp.lab.bootstrap.DataHolder;
import mk.finki.ukim.mk.wp.lab.model.Balloon;
import org.springframework.stereotype.Repository;

import java.util.List;
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
}
