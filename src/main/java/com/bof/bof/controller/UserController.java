package com.bof.bof.controller;

import com.bof.bof.model.User;
import com.bof.bof.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/patient")
public class UserController {
    @Autowired
    private UserService userService;



    @PostMapping("/createUser")
    public void createUser(@RequestBody User user) {
        userService.createUser(user);
    }

    @GetMapping("/readUser={id}")
    public Optional<User> readUser(@PathVariable Long id) {
        return userService.readUser(id);
    }

    @RequestMapping("/ageOfPatient={id}")
    public Integer getPatientAge(@PathVariable Long id) {
        return userService.findAgeOfPatient(id);
    }

    @PutMapping("/updatePatient")
    public void updatePatient(@RequestBody User user) { userService.updatePatient(user);}

    @DeleteMapping("/deletePatient={id}")
    public void deletePatient(@PathVariable Long id) { userService.deletePatient(userService.readUser(id).get());}

    @GetMapping("/allPatients")
    public List<User> getUsers() {
        List<User> users = userService.findAllPatients();
        return users;
    }

    @GetMapping("/patientsWithSameName={name}")
    public List<User> getListOfPatientsWithSameName(@PathVariable String name) {
        return userService.findAllPatientsWithSameName(name);
    }

}
