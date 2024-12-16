package com.doza.entity;

import java.time.LocalDate;

public class Person {

    private long id;
    private String email;
    private String pass;
    private String firstName;
    private String lastName;
    private LocalDate dateOfBirth;
    private Role role;

    public Person(long id, String email, String pass, String firstName, String lastName, LocalDate dateOfBirth) {
        this.id = id;
        this.email = email;
        this.pass = pass;
        this.firstName = firstName;
        this.lastName = lastName;
        this.dateOfBirth = dateOfBirth;
    }

    public Person(String email, String pass, String first_name, String last_name, LocalDate date_of_birth) {
        this.email = email;
        this.pass = pass;
        this.firstName = first_name;
        this.lastName = last_name;
        this.dateOfBirth = date_of_birth;
    }

    public Person(String email, String pass) {
        this.email = email;
        this.pass = pass;
    }


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirst_name(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDate_of_birth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return "Person{" +
               "id=" + id +
               ", email='" + email + '\'' +
               ", pass='" + pass + '\'' +
               ", first_name='" + firstName + '\'' +
               ", last_name='" + lastName + '\'' +
               ", date_of_birth=" + dateOfBirth +
               '}';
    }
}
