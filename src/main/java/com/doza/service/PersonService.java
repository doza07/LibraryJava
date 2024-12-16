package com.doza.service;

import com.doza.dao.PersonDao;
import com.doza.dto.PersonDto;
import com.doza.exeption.ValidationException;
import com.doza.mapper.PersonDtoToPerson;
import com.doza.mapper.PersonToPersonDto;
import com.doza.validator.PersonValidator;

import java.util.Optional;

public class PersonService {

    private static final PersonService INSTANCE = new PersonService();
    private final PersonValidator personValidator = PersonValidator.getInstance();
    private final PersonDao personDao = PersonDao.getInstance();
    private final PersonDtoToPerson personDtoToPerson = PersonDtoToPerson.getInstance();
    private final PersonToPersonDto personToPersonDto = PersonToPersonDto.getInstance();

    public Long createPerson(PersonDto personDto) {
        var valid = personValidator.isValid(personDto);
        if (!valid.isValid()) {
            throw new ValidationException(valid.getErrors());
        }
        var personEntity = personDtoToPerson.mapFrom(personDto);
        personDao.save(personEntity);

        return personEntity.getId();
    }

    public Optional<PersonDto> login(String email, String password) {
        return personDao.findByEmailAndPassword(email, password)
                .map(personToPersonDto::mapFrom);
    }

    public static PersonService getInstance() {
        return INSTANCE;
    }
}

