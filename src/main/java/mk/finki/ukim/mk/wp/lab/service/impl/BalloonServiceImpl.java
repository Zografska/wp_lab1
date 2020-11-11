package mk.finki.ukim.mk.wp.lab.service.impl;

import mk.finki.ukim.mk.wp.lab.model.Balloon;
import mk.finki.ukim.mk.wp.lab.model.Manufacturer;
import mk.finki.ukim.mk.wp.lab.model.exceptions.ManufacturerNotFoundException;
import mk.finki.ukim.mk.wp.lab.repository.BalloonRepository;
import mk.finki.ukim.mk.wp.lab.repository.ManufactorerRepository;
import mk.finki.ukim.mk.wp.lab.service.BalloonService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
@Service
public class BalloonServiceImpl implements BalloonService {

    BalloonRepository balloonRepository;
    ManufactorerRepository manufactorerRepository;

    public BalloonServiceImpl(BalloonRepository balloonRepository,ManufactorerRepository manufactorerRepository) {
        this.balloonRepository = balloonRepository;
        this.manufactorerRepository = manufactorerRepository;
    }

    @Override
    public List<Balloon> listAll() {
        return balloonRepository.findAllBalloons();
    }

    @Override
    public List<Balloon> searchByNameOrDescription(String text) {
        return balloonRepository.findAllByNameOrDescription(text);
    }

    @Override
    public Balloon saveOrUpdate(String name, String description, Long ManuId) {
        Manufacturer manufacturer = manufactorerRepository.findById(ManuId).orElseThrow(()-> new ManufacturerNotFoundException(ManuId));
        return balloonRepository.saveOrUpdate(new Balloon(name, description,manufacturer));

    }

    @Override
    public void deleteBalloon(Long id) {
        balloonRepository.deleteBalloon(id);
    }

    @Override
    public Optional<Balloon> getBalloonById(Long id) {
        return balloonRepository.getBalloonById(id);
    }
}
