package com.doza.dto;

public class PersonDto {

    private long id;
    private String email;

    public PersonDto(long id, String email) {
        this.id = id;
        this.email = email;
    }

    public long getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    @Override
    public String toString() {
        return "PersonDto{" +
               "id=" + id +
               ", email='" + email + '\'' +
               '}';
    }
}
