package com.bof.bof.service;

import com.bof.bof.model.User;
import com.bof.bof.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public void createUser(User user) {
        userRepository.save(user);
    }

    public Optional<User> readUser(Long id) {
        return userRepository.findById(id);
    }

}
