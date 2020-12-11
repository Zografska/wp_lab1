package mk.finki.ukim.mk.wp.lab.repository.jpa;

import mk.finki.ukim.mk.wp.lab.model.Balloon;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface JpaBalloonRepository extends JpaRepository<Balloon, Long> {
        List<Balloon> findAllByNameLike(String search);
       // void deleteById(Long id);
}
