package mk.finki.ukim.mk.wp.lab.service.impl;

import mk.finki.ukim.mk.wp.lab.model.User;
import mk.finki.ukim.mk.wp.lab.repository.UserRepository;
import mk.finki.ukim.mk.wp.lab.service.AuthService;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AuthServiceImpl implements AuthService {
    UserRepository userRepository;
    @Override
    public Optional<User> findUser(String username) {
        return userRepository.findUser(username);
    }

    @Override
    public Optional<User> successfulLogin(String username, String password) {
        return userRepository.successfulLogin(username,password);
    }

    @Override
    public User addUser(String password, String username, String name, String address) {
        User user= new User(username,password);
        return userRepository.addUser(user);
    }
}
