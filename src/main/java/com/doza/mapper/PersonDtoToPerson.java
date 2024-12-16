package com.doza.mapper;

import com.doza.dto.PersonDto;
import com.doza.entity.Person;

public class PersonDtoToPerson implements Mapper<PersonDto, Person> {

    public static final PersonDtoToPerson INSTANCE = new PersonDtoToPerson();

    @Override
    public Person mapFrom(PersonDto obj) {
        return new Person(
                obj.getEmail(),
                obj.getPass()
        );
    }


    public static PersonDtoToPerson getInstance() {
        return INSTANCE;
    }
}