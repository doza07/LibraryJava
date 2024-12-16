package com.doza.mapper;

import com.doza.dto.PersonDto;
import com.doza.entity.Person;

public class PersonToPersonDto implements Mapper<Person, PersonDto>{

    private static final PersonToPersonDto INSTANCE = new PersonToPersonDto();


    @Override
    public PersonDto mapFrom(Person obj) {
        return new PersonDto(
                obj.getEmail(),
                obj.getPass()
        );
    }
    public static PersonToPersonDto getInstance() {
        return INSTANCE;
    }

}
