package mk.finki.ukim.mk.wp.lab.service.impl;

import mk.finki.ukim.mk.wp.lab.model.Order;
import mk.finki.ukim.mk.wp.lab.model.ShoppingCart;
import mk.finki.ukim.mk.wp.lab.model.User;
import mk.finki.ukim.mk.wp.lab.repository.jpa.JpaUserRepository;
import mk.finki.ukim.mk.wp.lab.service.AuthService;
import mk.finki.ukim.mk.wp.lab.service.ShoppingCartService;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AuthServiceImpl implements AuthService {
    private final JpaUserRepository userRepository;
    private final ShoppingCartService shoppingCartService;

    public AuthServiceImpl(JpaUserRepository userRepository, ShoppingCartService shoppingCartService) {
        this.userRepository = userRepository;
        this.shoppingCartService = shoppingCartService;
    }

    @Override
    public Optional<User> findUser(String username) {

        return userRepository.findByUsername(username);
    }

    @Override
    public Optional<User> successfulLogin(String username, String password) {
        return userRepository.findByUsernameAndPassword(username,password);
    }

    @Override
    public User addUser(String username,String password) {
        ShoppingCart shoppingCart = shoppingCartService.create();
        return userRepository.save(new User(username,password,shoppingCart));
    }
//    @Override
//    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
//        return userRepository.findByUsername(s).orElseThrow(()->new UsernameNotFoundException(s));
//    }


    @Override
    public boolean validRegistration(String username) {
        return userRepository.findByUsername(username).isEmpty();
    }

    @Override
    public void addOrder(String username, Order order) {
      //  userRepository.findByUsername(username).get().getShoppingCart().getOrders().add(order);
    }

}
