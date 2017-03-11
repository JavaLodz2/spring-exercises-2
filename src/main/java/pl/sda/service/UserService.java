package pl.sda.service;

import pl.sda.model.User;

import java.util.List;

/**
 * Created by trot on 11.03.17.
 */
public interface UserService {
    public List<User> getAllUsers();

    public User getUserByLogin(String login);
}
