package com.bof.bof.service;

import com.bof.bof.model.User;
import com.bof.bof.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

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
        Integer year = userRepository.findById(id).get().getBirthdate().getYear();
        Integer actualYear = LocalDate.now().getYear();
        Integer age = actualYear - year;
        return age;
    }

    public void updatePatient(User user) {
        User patientSelected = userRepository.findById(user.getId()).orElseThrow(() -> new RuntimeException("Patient not found"));
        patientSelected.setLastName(user.getLastName());
        patientSelected.setFirstName(user.getFirstName());
        patientSelected.setBirthdate(user.getBirthdate());
        patientSelected.setAddress(user.getAddress());
        patientSelected.setGender(user.getGender());
        userRepository.save(patientSelected);
        System.out.println("Patient updated");
    }

    public void deletePatient(User user) {
        userRepository.delete(user);
        System.out.println("Patient deleted");
    }

    public List<User> findAllPatients() {
        return userRepository.findAll();
    }

    public List<User> findAllPatientsWithSameName(String name) {
        return userRepository.findAll().stream()
                .filter(patient -> patient.getLastName().equalsIgnoreCase(name))
                .collect(Collectors.toList());
    }

}
