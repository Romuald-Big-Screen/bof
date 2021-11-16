package com.bof.bof.repository;

import com.bof.bof.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;


public interface UserRepository extends JpaRepository<User, Long> {


    }




