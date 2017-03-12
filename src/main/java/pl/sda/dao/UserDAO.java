package pl.sda.dao;

import pl.sda.model.User;

import java.util.List;

/**
 * Created by trot on 11.03.17.
 */
public interface UserDAO {

    List<User> getAllUsers();

    User getUserByLogin(String login);

    void addUser(User user);

    void removeUser(User user);

    void updateUser(User user);
}
