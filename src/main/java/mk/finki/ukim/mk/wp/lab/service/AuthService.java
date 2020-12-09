package mk.finki.ukim.mk.wp.lab.service;

import mk.finki.ukim.mk.wp.lab.model.Order;
import mk.finki.ukim.mk.wp.lab.model.User;

import java.util.Optional;

public interface AuthService {
    Optional<User> findUser(String username);
    Optional<User> successfulLogin(String username, String password);
    User addUser(User user);
    boolean validRegistration(String username);
    void addOrder(String username, Order order);
}
