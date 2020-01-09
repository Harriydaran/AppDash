package com.harriydaran.userservice.service;

import com.harriydaran.userservice.model.User;

import java.util.List;
import java.util.Optional;

public interface UserService {

    User createUser(User user);
    Optional<User> findById(int id);
    List<User> getUsers();
    User updateUser(User newUser);
    void deleteUser(User user);

}
