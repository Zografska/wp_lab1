package mk.finki.ukim.mk.wp.lab.repository.inmemory;

import mk.finki.ukim.mk.wp.lab.bootstrap.DataHolder;
import mk.finki.ukim.mk.wp.lab.model.Order;
import mk.finki.ukim.mk.wp.lab.model.User;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class UserRepository {
    public Optional<User> findUser(String username){
        return DataHolder.userList.stream().filter(user -> user.getUsername().equals(username)).findFirst();
    }
    public Optional<User> successfulLogin(String username, String password)
    {
        return DataHolder.userList.stream()
                .filter(user -> user.getUsername().equals(username) && user.getPassword().equals(password))
                .findFirst();
    }
    public User addUser(User user)
    {
        DataHolder.userList.add(user);
        return user;
    }
    public boolean ValidRegister(String username){
        return  DataHolder.userList.stream().noneMatch(user -> user.getUsername().equals(username));
    }
    public void addOrderToUser(Order o, String username)
    {
        User user = findUser(username).get();
        DataHolder.userList.removeIf(u -> u.getUsername().equals(user.getUsername()));
        //user.getShoppingCart().getOrders().add(o);
        DataHolder.userList.add(user);
    }



}
