package com.KSTech.learnmicroserviceswithspringboot.user;

import org.omg.PortableServer.POA;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.swing.text.html.Option;
import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
public class UserControllerJPA {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PostRepository postRepository;

    @GetMapping("/jpa/users/{userId}")
    public Optional getUser(@PathVariable Long userId) {
        Optional savedUser = userRepository.findById(userId);
        if (!savedUser.isPresent())
            throw new UserNotFoundException("id-" + userId);
        return savedUser;
    }
    @GetMapping ("/jpa/users")
    public List<User> getUsers() {
        return userRepository.findAll();
    }

    @PostMapping("/jpa/users")
    public ResponseEntity<Object> createUser(@RequestBody User user) {
        User newUser = (User) userRepository.save(user);

        //Created with proper status
        URI location = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{userId}").buildAndExpand(newUser.getUserId()).toUri();
        return ResponseEntity.created(location).build();
    }
    @DeleteMapping("/jpa/users/{userId}")
    public void deleteUser(@PathVariable Long userId) {
        userRepository.deleteById(userId);
    }

    //MARK- User Posts endpoints

    @GetMapping("/jpa/users/{userId}/posts")
    public List<Post> getPosts(@PathVariable Long userId) {
        Optional<User> user = userRepository.findById(userId);
        if (!user.isPresent())
            throw new UserNotFoundException("id-" + userId);
        return user.get().getPosts();
    }
    @PostMapping("/jpa/users/{userId}/posts")
    public ResponseEntity<Object> createUser(@PathVariable Long userId, @RequestBody Post post) {
        Optional<User> savedUser = userRepository.findById(userId);
        if (!savedUser.isPresent())
            throw new UserNotFoundException("id-" + userId);
        post.setUser(savedUser.get());
        postRepository.save(post);

        //Created post with proper status
        URI location = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{postId}").buildAndExpand(post.getId()).toUri();
        return ResponseEntity.created(location).build();
    }
}