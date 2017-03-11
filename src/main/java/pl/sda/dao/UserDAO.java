package pl.sda.dao;

import pl.sda.model.User;

import java.util.List;

/**
 * Created by trot on 11.03.17.
 */
public interface UserDAO {

    public List<User> getAllUsers();

    public User getUserByLogin(String login);
}
