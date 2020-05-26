package com.KSTech.learnmicroserviceswithspringboot.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping ("/users/{userId}")
    public User getUser(@PathVariable Long userId) {
        User savedUser = userService.find(userId);
        if (savedUser==null)
            throw new UserNotFoundException("id-" + userId);
        return savedUser;
    }
    @GetMapping ("/users")
    public List<User> getUsers() {
        return userService.findAll();
    }

    @PostMapping ("/users")
    public ResponseEntity<Object> createUser(@RequestBody User user) {
        User newUser = userService.save(user);

        //Created with proper status
        URI location = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{userId}").buildAndExpand(newUser.getUserId()).toUri();
        return ResponseEntity.created(location).build();
    }
    @DeleteMapping ("/users/{userId}")
    public User deleteUser(@PathVariable Long userId) {
        User deletedUser = userService.delete(userId);
        if (deletedUser==null)
            throw new UserNotFoundException("id-" + userId);
        return deletedUser;
    }
}
