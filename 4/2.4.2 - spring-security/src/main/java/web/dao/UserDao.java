package web.dao;

import web.model.User;

import java.util.List;

public interface UserDao {

    void addUser(User user);
    User getUserById(Long id);
    void updateUser(User user);
    void deleteUserById(Long id);
    List<User> getAllUsers();
    User getUserByUsername(String username);

}
