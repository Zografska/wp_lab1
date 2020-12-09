package mk.finki.ukim.mk.wp.lab.service;

import mk.finki.ukim.mk.wp.lab.model.Order;
import mk.finki.ukim.mk.wp.lab.model.User;

import java.util.List;


public interface OrderService{
    Order placeOrder(String balloonColor,String balloonSize, User user);
    List<Order> findOrdersByClientName(String clientName);
}