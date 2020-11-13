package mk.finki.ukim.mk.wp.lab.service;

import mk.finki.ukim.mk.wp.lab.model.Order;

import java.util.List;


public interface OrderService{
    Order placeOrder(String balloonColor,String balloonSize, String clientName, String address);
    List<Order> findOrdersByClientName(String clientName);
}