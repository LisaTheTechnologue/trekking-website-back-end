package com.ngantcb.trekking.controller;

import com.ngantcb.trekking.entity.User;
import com.ngantcb.trekking.repository.UserRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api/users")
public class UserController {

    // standard constructors

    private final UserRepository userRepository;

    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping("")
    public List<User> getUsers() {
        return (List<User>) userRepository.findAll();
    }

    @PostMapping("/create")
    void addUser(@RequestBody User user) {
        userRepository.save(user);
    }
}
