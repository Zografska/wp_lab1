package mk.finki.ukim.mk.wp.lab.service.impl;

import mk.finki.ukim.mk.wp.lab.model.Order;
import mk.finki.ukim.mk.wp.lab.model.User;
import mk.finki.ukim.mk.wp.lab.repository.OrderRepository;
import mk.finki.ukim.mk.wp.lab.service.OrderService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {
    private final OrderRepository orderRepository;

    public OrderServiceImpl(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @Override
    public Order placeOrder(String balloonColor,String balloonSize, User user) {
        return orderRepository.saveOrder(new Order(balloonColor,balloonSize,user));
    }

    @Override
    public List<Order> findOrdersByClientName(String clientName) {
        return orderRepository.findOrdersByClientName(clientName);
    }
}
