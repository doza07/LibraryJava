package com.doza.mapper;

import com.doza.dto.PersonDto;
import com.doza.entity.Person;

public class CreatePersonMapper implements Mapper<PersonDto, Person>{

    public static final CreatePersonMapper INSTANCE = new CreatePersonMapper();

    @Override
    public Person mapFrom(PersonDto obj) {
        return new Person(
                obj.getEmail(),
                obj.getPass(),
                obj.getFirstName(),
                obj.getLastName(),
                obj.getDateOfBirth()
        );
    }

    public static CreatePersonMapper getInstance() {
        return INSTANCE;
    }
}
