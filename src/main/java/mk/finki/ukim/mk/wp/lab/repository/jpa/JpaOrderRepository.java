package mk.finki.ukim.mk.wp.lab.repository.jpa;

import mk.finki.ukim.mk.wp.lab.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface JpaOrderRepository extends JpaRepository<Order,Long> {
    List<Order> findAllByUserId(Long id);
}
