package com.finalProject.travelAgency.service;


import com.finalProject.travelAgency.model.User;
import com.finalProject.travelAgency.repository.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {


    private final PasswordEncoder passwordEncoder;
    private final UserRepository userRepository;

    public UserService(PasswordEncoder passwordEncoder, UserRepository userRepository) {
        this.passwordEncoder = passwordEncoder;
        this.userRepository = userRepository;
    }

    public void save(User user) {
        User newUser = new User();
        newUser.setUsername(user.getUsername());
        newUser.setPassword(passwordEncoder.encode(user.getPassword()));
        newUser.setFirstName(user.getFirstName());
        newUser.setLastName(user.getLastName());
        newUser.setEmail(user.getEmail());
        newUser.setPhoneNumber(user.getPhoneNumber());
        if (userRepository.findAll().isEmpty()) {
            newUser.setRole("ROLE_ADMIN");
        } else {
            newUser.setRole("ROLE_USER");
        }
        userRepository.save(newUser);
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public User getUser(Long id) {
        return userRepository.getById(id);
    }
    public User getUser(String name){
        return userRepository.findByUsername(name).get();
    }
}