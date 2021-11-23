package com.bof.bof.service;

import com.bof.bof.model.User;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;

@SpringBootTest
public class UserServiceTest {
    @Autowired
    private UserService userService;
    User user = new User("firstName","lastName","Male","address", LocalDate.of(2010,05,05));

    @Test
    void createPatientTest() {
        userService.createUser(user);
        Assertions.assertEquals("lastName", userService.readUser(user.getId()).get().getLastName());
        userService.deletePatient(user);
    }

    @Test
    void updatePatientTest() {
        userService.createUser(user);
        user.setLastName("lastName updated");
        userService.updatePatient(user);
        Assertions.assertEquals("lastName updated", userService.readUser(user.getId()).get().getLastName());
        userService.deletePatient(user);
    }

    @Test
    void deletePatientTest() {
        userService.createUser(user);
        Long id = user.getId();
        userService.deletePatient(user);
        Assertions.assertFalse(userService.readUser(id).isPresent());
    }

    @Test
    void findPatientByIdTest() {
        userService.createUser(user);
        Assertions.assertEquals("lastName", userService.readUser(user.getId()).get().getLastName());
        userService.deletePatient(user);
    }

    @Test
    void findAllPatientsTest() {
        userService.createUser(user);
        Assertions.assertTrue(userService.findAllPatients().size() > 0);
        userService.deletePatient(user);
    }

    @Test
    void findAgeOfPatientTest() {
        userService.createUser(user);
        Assertions.assertEquals(21, userService.findAgeOfPatient(user.getId()));
        userService.deletePatient(user);
    }

    @Test
    void findAllPatientsWithSameNameTest() {
        userService.createUser(user);
        userService.createUser(new User("lastName", "second","Female", "address", LocalDate.of(2000, 01, 01) ));
        User secondPatient = userService.findAllPatients().stream().filter(patient1 -> patient1.getFirstName().equals("second")).findFirst().get();
        userService.findAllPatientsWithSameName("lastName");
        Assertions.assertTrue(userService.findAllPatientsWithSameName("lastName").size() > 0);
        userService.deletePatient(user);
        userService.deletePatient(secondPatient);

    }

}
