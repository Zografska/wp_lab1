package mk.finki.ukim.mk.wp.lab.repository;

import mk.finki.ukim.mk.wp.lab.bootstrap.DataHolder;
import mk.finki.ukim.mk.wp.lab.model.Order;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
public class OrderRepository {

    public List<Order> findOrdersByClientName(String clientName) {
        return DataHolder.orderList.stream()
                .filter(order -> order.getClientName().equals(clientName)).collect(Collectors.toList());
    }
    public Order saveOrder(Order order)
    {
        DataHolder.orderList.add(order);
        return order;
    }
}
