package mk.finki.ukim.mk.wp.lab.service.impl;

import mk.finki.ukim.mk.wp.lab.model.Balloon;
import mk.finki.ukim.mk.wp.lab.model.Manufacturer;
import mk.finki.ukim.mk.wp.lab.model.exceptions.ManufacturerNotFoundException;
import mk.finki.ukim.mk.wp.lab.repository.jpa.JpaBalloonRepository;
import mk.finki.ukim.mk.wp.lab.repository.jpa.JpaManufacturerRepository;
import mk.finki.ukim.mk.wp.lab.service.BalloonService;
import org.springframework.stereotype.Service;

import java.util.List;

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
        return balloonRepository.findAllByNameLike(text);
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
