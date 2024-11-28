package com.doza.entity;

import java.time.LocalDate;

public class Person {

    private long id;
    private String email;
    private String pass;
    private String first_name;
    private String last_name;
    private LocalDate date_of_birth;

    public Person(String email, String pass, String first_name, String last_name, LocalDate date_of_birth) {
        this.email = email;
        this.pass = pass;
        this.first_name = first_name;
        this.last_name = last_name;
        this.date_of_birth = date_of_birth;
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

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public LocalDate getDate_of_birth() {
        return date_of_birth;
    }

    public void setDate_of_birth(LocalDate date_of_birth) {
        this.date_of_birth = date_of_birth;
    }

    @Override
    public String toString() {
        return "Person{" +
               "id=" + id +
               ", email='" + email + '\'' +
               ", pass='" + pass + '\'' +
               ", first_name='" + first_name + '\'' +
               ", last_name='" + last_name + '\'' +
               ", date_of_birth=" + date_of_birth +
               '}';
    }
}
