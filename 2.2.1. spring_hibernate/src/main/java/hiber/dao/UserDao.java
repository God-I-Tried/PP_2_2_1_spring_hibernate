package hiber.dao;

import hiber.model.User;

import java.util.List;

public interface UserDao {
    void addUser(User user);

    List<User> getListOfUsers();

    List<User> getUserByCar(String model, int series);
}
