package mk.finki.ukim.mk.wp.lab.service;

import mk.finki.ukim.mk.wp.lab.model.Balloon;

import java.util.List;
import java.util.Optional;

public interface BalloonService {
    List<Balloon> listAll();
    List<Balloon> searchByNameOrDescription(String text);
    Balloon saveOrUpdate(String name, String description, Long ManuId);
    void deleteBalloon(Long id);
    public Optional<Balloon> getBalloonById(Long id);
}
