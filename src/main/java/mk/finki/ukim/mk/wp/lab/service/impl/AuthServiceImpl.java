package mk.finki.ukim.mk.wp.lab.service.impl;

import mk.finki.ukim.mk.wp.lab.model.Order;
import mk.finki.ukim.mk.wp.lab.model.User;
import mk.finki.ukim.mk.wp.lab.repository.UserRepository;
import mk.finki.ukim.mk.wp.lab.service.AuthService;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AuthServiceImpl implements AuthService {
    private final UserRepository userRepository;

    public AuthServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public Optional<User> findUser(String username) {
        return userRepository.findUser(username);
    }

    @Override
    public Optional<User> successfulLogin(String username, String password) {
        return userRepository.successfulLogin(username,password);
    }

    @Override
    public User addUser(User user) {
        return userRepository.addUser(user);
    }

    @Override
    public boolean validRegistration(String username) {
        return userRepository.ValidRegister(username);
    }

    @Override
    public void addOrder(String username, Order order) {
        userRepository.addOrderToUser(order,username);
    }

}
