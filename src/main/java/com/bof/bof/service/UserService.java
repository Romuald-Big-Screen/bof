package com.bof.bof.service;

import com.bof.bof.model.User;
import com.bof.bof.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
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

    public Integer findAgeOfPatient(Long id) {
        Integer year = UserRepository.findById(id).get().getBirthdate().getYear();
        Integer actualYear = LocalDate.now().getYear();
        Integer age = actualYear - year;
        return age;
    }

}
