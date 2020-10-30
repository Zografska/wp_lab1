package mk.finki.ukim.mk.wp.lab.service;

import mk.finki.ukim.mk.wp.lab.model.Balloon;

import java.util.List;

public interface BalloonService {
    List<Balloon> listAll();
    List<Balloon> searchByNameOrDescription(String text);
}
