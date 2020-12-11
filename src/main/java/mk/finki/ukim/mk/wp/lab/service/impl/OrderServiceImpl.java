package mk.finki.ukim.mk.wp.lab.service.impl;

import mk.finki.ukim.mk.wp.lab.model.Order;
import mk.finki.ukim.mk.wp.lab.model.User;
import mk.finki.ukim.mk.wp.lab.repository.jpa.JpaOrderRepository;
import mk.finki.ukim.mk.wp.lab.repository.jpa.JpaUserRepository;
import mk.finki.ukim.mk.wp.lab.service.OrderService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {
    private final JpaOrderRepository orderRepository;
    private final JpaUserRepository userRepository;

    public OrderServiceImpl(JpaOrderRepository orderRepository, JpaUserRepository userRepository) {
        this.orderRepository = orderRepository;
        this.userRepository = userRepository;
    }

    @Override
    public Order placeOrder(String balloonColor,String balloonSize, String user) {
        User realUser = userRepository.findByUsername(user).get();
        return orderRepository.save(new Order(balloonColor,balloonSize,realUser));
    }

    @Override
    public List<Order> findOrdersByUserId(Long userId) {

        return orderRepository.findAllByUserId(userId);
    }
}
