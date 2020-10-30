package mk.finki.ukim.mk.wp.lab.service;

import mk.finki.ukim.mk.wp.lab.model.Order;

public interface OrderService{
    Order placeOrder(String balloonColor, String clientName, String address);
}