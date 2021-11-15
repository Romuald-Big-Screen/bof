package com.bof.bof.repository;

import com.bof.bof.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;


public interface UserRepository extends JpaRepository<User, Long> {




        public static int calculatorAge(String birthdate) {

            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");

            LocalDate birthDay = LocalDate.parse(birthdate, formatter);
            LocalDate currentDate = LocalDate.now();

            if ((birthDay != null) && (currentDate != null)) {
                return Period.between(birthDay, currentDate).getYears();
            } else {
                return 0;
            }

        }
    }




