package com.doza.mapper;

import com.doza.dto.CreatePersonDto;
import com.doza.entity.Person;
import com.doza.util.LocalDateFormatter;

public class CreatePersonMapper implements Mapper<CreatePersonDto, Person>{

    public static final CreatePersonMapper INSTANCE = new CreatePersonMapper();

    @Override
    public Person mapFrom(CreatePersonDto obj) {
        return new Person(
                obj.getEmail(),
                obj.getPass(),
                obj.getFirstName(),
                obj.getLastName(),
                LocalDateFormatter.format(obj.getDateOfBirth())
        );
    }

    public static CreatePersonMapper getInstance() {
        return INSTANCE;
    }
}
