package com.bof.bof.model;

import javax.persistence.*;

@Entity
@Table(name = "patient")
public class User {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;
    private String firstName;
    private String lastName;
    private String gender;
    private String address;
    private int birthdate;

    public User() {
    }

    public User(Long id, String firstName, String lastName, String gender, String address, int birthdate) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
        this.address = address;
        this.birthdate = birthdate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(int birthdate) {
        this.birthdate = birthdate;
    }
}
