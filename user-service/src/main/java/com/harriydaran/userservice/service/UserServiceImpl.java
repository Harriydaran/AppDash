package com.harriydaran.userservice.service;

import com.harriydaran.userservice.dao.UserRepository;
import com.harriydaran.userservice.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User createUser(User user){
        return userRepository.save(user);
    }

    public Optional<User> findById(int id){
        return userRepository.findById(id);
    }

    public List<User> getUsers(){
        return userRepository.findAll();
    }

    public User updateUser(User newUser){
        Optional<User> user = userRepository.findById(newUser.getId());
        if (user.isPresent()){
            userRepository.save(newUser);
        }else {
            System.out.println("User does not exist");
        }
        return newUser;
    }

    public void deleteUser(User user){
        userRepository.delete(user);
    }
}
