package mk.finki.ukim.mk.wp.lab.repository.jpa;

import mk.finki.ukim.mk.wp.lab.model.Balloon;
import mk.finki.ukim.mk.wp.lab.model.Manufacturer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface JpaBalloonRepository extends JpaRepository<Balloon, Long> {
       // @Query(value = "SELECT b FROM Balloon b WHERE b.name LIKE %:search%")
        List<Balloon> findAllByNameLike(String search);
        List<Balloon> findAllByDescriptionLike(String search);
        List<Balloon> findByManufacturer(Manufacturer manufacturer);
       // void deleteById(Long id);



}
