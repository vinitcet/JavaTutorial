package com.vinit.example.service;

import com.vinit.example.model.Users;
import com.vinit.example.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public List<Users> getAllUsers() {
        return userRepository.findAll();
    }

    public Users addUser(Users u) {
        return userRepository.save(u);
    }
}
