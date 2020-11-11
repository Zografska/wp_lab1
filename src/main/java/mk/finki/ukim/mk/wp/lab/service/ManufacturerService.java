package mk.finki.ukim.mk.wp.lab.service;

import mk.finki.ukim.mk.wp.lab.model.Balloon;
import mk.finki.ukim.mk.wp.lab.model.Manufacturer;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


public interface ManufacturerService {
     List<Manufacturer> findAll();
     Optional<Manufacturer> findById(Long id);

}
