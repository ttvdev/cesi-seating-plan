package com.cesi.seatingplan.controller;

import com.cesi.seatingplan.entity.User;
import com.cesi.seatingplan.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path="/user")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @PostMapping(path = "/add")
    public User addNewUser(@RequestBody User newUser) {
        return userRepository.save(newUser);
    }

    @GetMapping(path="/{id}")
    public User getUser(@PathVariable Integer id) {
        return userRepository.findById(id).get();
    }

    @GetMapping(path="/all")
    public Iterable<User> getAllUsers() { return userRepository.findAll(); }

    @PutMapping(path = "/edit/{id}")
    public User editUser(@RequestBody User newUser, @PathVariable Integer id) {
        return userRepository.findById(id).map(
                user -> {
                    user.setId(newUser.getId());
                    user.setName(newUser.getName());
                    user.setEmail(newUser.getEmail());
                    user.setEntryDate(newUser.getEntryDate());
                    user.setExitDate(newUser.getExitDate());
                    return userRepository.save(user);
                }).orElseGet(() -> {
            newUser.setId(id);
            return userRepository.save(newUser);
        });
    }

    @DeleteMapping("/delete/{id}")
    public String deleteUser(@PathVariable Integer id) {
        userRepository.deleteById(id);
        return "Deleled";
    }
}
