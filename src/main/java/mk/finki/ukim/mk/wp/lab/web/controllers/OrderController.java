package mk.finki.ukim.mk.wp.lab.web.controllers;

import mk.finki.ukim.mk.wp.lab.model.Order;
import mk.finki.ukim.mk.wp.lab.service.OrderService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping("/orders")
public class OrderController {
    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @GetMapping
    public String ShowOrders(HttpServletRequest req,Model model){
    String clientName = (String)req.getSession().getAttribute("clientName");
    List<Order> orderList = orderService
            .findOrdersByClientName(clientName);
    model.addAttribute("clientName",clientName);
    model.addAttribute("ordersList",orderList);
    return "userOrders";
    }
}
