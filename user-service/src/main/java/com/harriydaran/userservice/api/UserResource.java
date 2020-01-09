package com.harriydaran.userservice.api;

import com.harriydaran.userservice.model.User;
import com.harriydaran.userservice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/users")
public class UserResource {

    private UserService userService;

    @Autowired
    public UserResource(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public List<User> getAllUsers(){
        return null;
    }

    @GetMapping("/{id}")
    public User findUserById(@PathVariable("id") int id){
        System.out.println(id);
        return null;
    }

    @PostMapping
    public User createUser(@RequestBody User user){
        System.out.println(user);
        return null;
    }

    @PutMapping("/{id}")
    public User updateUser(@PathVariable("id") int id ,@RequestBody User user){
        System.out.println(user);
        return null;
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable("id") int id){
        System.out.println(id);
    }

}
