package mk.finki.ukim.mk.wp.lab.web.controllers;

import mk.finki.ukim.mk.wp.lab.model.Order;
import mk.finki.ukim.mk.wp.lab.model.User;
import mk.finki.ukim.mk.wp.lab.service.OrderService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
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
    User user = (User)req.getSession().getAttribute("user");
    List<Order> orderList = orderService
            .findOrdersByClientName(user.getUsername());
    model.addAttribute("ordersList",orderList);
    return "userOrders";
    }
    @PostMapping("add-order")
    public String addOrder(HttpServletRequest request){

        orderService.placeOrder((String)request.getSession().getAttribute("color"),
                (String)request.getSession().getAttribute("size"),
                (User)request.getSession().getAttribute("user"));
        return "redirect:/orders";
    }
}
