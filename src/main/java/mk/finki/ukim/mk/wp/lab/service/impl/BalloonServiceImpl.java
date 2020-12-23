package mk.finki.ukim.mk.wp.lab.service.impl;

import mk.finki.ukim.mk.wp.lab.model.Balloon;
import mk.finki.ukim.mk.wp.lab.model.Manufacturer;
import mk.finki.ukim.mk.wp.lab.model.exceptions.ManufacturerNotFoundException;
import mk.finki.ukim.mk.wp.lab.repository.jpa.JpaBalloonRepository;
import mk.finki.ukim.mk.wp.lab.repository.jpa.JpaManufacturerRepository;
import mk.finki.ukim.mk.wp.lab.service.BalloonService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class BalloonServiceImpl implements BalloonService {

    JpaBalloonRepository balloonRepository;
    JpaManufacturerRepository manufacturerRepository;

    public BalloonServiceImpl(JpaBalloonRepository balloonRepository, JpaManufacturerRepository manufacturerRepository) {
        this.balloonRepository = balloonRepository;
        this.manufacturerRepository = manufacturerRepository;
    }

    @Override
    public List<Balloon> listAll() {
        return balloonRepository.findAll();
    }

    @Override
    public List<Balloon> searchByNameOrDescription(String text) {
        Set<Balloon> balloons = new HashSet<>();
        balloons.addAll(balloonRepository.findAllByNameLike(text));
        balloons.addAll(balloonRepository.findAllByDescriptionLike(text));
        for (Manufacturer m :
                manufacturerRepository.findAllByNameLike(text)) {
            balloons.addAll(balloonRepository.findByManufacturer(m));
        }

        return new ArrayList<>(balloons);
    }

    @Override
    public Balloon saveOrUpdate(String name, String description, Long ManuId) {
        Manufacturer manufacturer = manufacturerRepository.findById(ManuId).get();
        return balloonRepository.save(new Balloon(name, description,manufacturer));

    }

    @Override
    public void deleteBalloon(Long id) {
        balloonRepository.deleteById(id);
    }

    @Override
    public Balloon getBalloonById(Long id) {
        return balloonRepository.getOne(id);
    }
}
