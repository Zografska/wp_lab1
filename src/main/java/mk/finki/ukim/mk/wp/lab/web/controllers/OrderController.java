package mk.finki.ukim.mk.wp.lab.web.controllers;

import mk.finki.ukim.mk.wp.lab.model.Order;
import mk.finki.ukim.mk.wp.lab.model.User;
import mk.finki.ukim.mk.wp.lab.service.AuthService;
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
    private final AuthService authService;
    public OrderController(OrderService orderService, AuthService authService) {
        this.orderService = orderService;
        this.authService = authService;
    }

    @GetMapping
    public String ShowOrders(HttpServletRequest req,Model model){
        //(String)req.getSession().getAttribute("user");
        String username="zogra";
    User user = authService.findUser(username).get();
    List<Order> orderList = orderService
            .findOrdersByUserId(user.getId());
    model.addAttribute("ordersList",orderList);
    return "userOrders";
    }
    @PostMapping("add-order")
    public String addOrder(HttpServletRequest request){

        orderService.placeOrder((String)(request.getSession().getAttribute("color")),
                (String)(request.getSession().getAttribute("size")),
                "zogra");
//(String)(request.getSession().getAttribute("user")
        return "redirect:/orders";
    }
}
