package com.spring.jmep.service;

import com.spring.jmep.model.User;

import java.util.List;

public interface UserService {

    void addUser(User user);
    void updateUser(User user);
    void deleteUser(Long id);
    List<User> getAllUsers();
    User getUserById(Long id);

}
