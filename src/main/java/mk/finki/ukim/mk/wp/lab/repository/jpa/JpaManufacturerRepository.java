package mk.finki.ukim.mk.wp.lab.repository.jpa;

import mk.finki.ukim.mk.wp.lab.model.Manufacturer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface JpaManufacturerRepository extends JpaRepository<Manufacturer,Long> {
        List<Manufacturer> findAllByNameLike(String search);
}
