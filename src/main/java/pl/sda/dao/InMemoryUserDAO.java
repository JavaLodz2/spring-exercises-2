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

    @Override
    public void addUser(User user) {
        usersList.add(user);
    }

    @Override
    public void removeUser(User user) {
        usersList.remove(user);
    }

    @Override
    public void updateUser(User user) {
        removeUser(user);
        addUser(user);
    }

    public List getUsersList() {
        return usersList;
    }

    public void setUsersList(List usersList) {
        this.usersList = usersList;
    }
}
