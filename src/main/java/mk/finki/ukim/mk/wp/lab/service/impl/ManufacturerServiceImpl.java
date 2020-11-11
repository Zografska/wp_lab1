package mk.finki.ukim.mk.wp.lab.service.impl;

import mk.finki.ukim.mk.wp.lab.model.Manufacturer;
import mk.finki.ukim.mk.wp.lab.repository.ManufactorerRepository;
import mk.finki.ukim.mk.wp.lab.service.ManufacturerService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ManufacturerServiceImpl implements ManufacturerService {
    private final ManufactorerRepository manufactorerRepository;

    public ManufacturerServiceImpl(ManufactorerRepository manufactorerRepository) {
        this.manufactorerRepository = manufactorerRepository;
    }

    @Override
    public List<Manufacturer> findAll() {
        return manufactorerRepository.findAll();
    }

    @Override
    public Optional<Manufacturer> findById(Long id) {
        return manufactorerRepository.findById(id);
    }
}
