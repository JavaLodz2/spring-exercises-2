package pl.sda.dao;

import pl.sda.model.User;

import java.util.List;

/**
 * Created by trot on 11.03.17.
 */
public class InMemoryUserDAO implements UserDAO {

    private List<User> usersList;

    @Override
    public List<User> getAllUsers() {
        return usersList;
    }

    @Override
    public User getUserByLogin(String login) {
        return usersList.stream().filter(u -> u.getLogin().equals(login)).findAny().get();
    }

    public void setUsersList(List usersList) {
        this.usersList = usersList;
    }

    public List getUsersList() {
        return usersList;
    }
}
