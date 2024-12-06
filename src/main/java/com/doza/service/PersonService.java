package com.doza.service;

import com.doza.dao.PersonDao;
import com.doza.dto.CreatePersonDto;
import com.doza.entity.Person;
import com.doza.exeption.ValidationException;
import com.doza.mapper.CreatePersonMapper;
import com.doza.validator.CreatePersonValidator;
import com.doza.validator.ValidationResult;

import java.sql.SQLException;

public class PersonService {

    private static final PersonService INSTANCE = new PersonService();
    private final CreatePersonValidator createPersonValidator = CreatePersonValidator.getInstance();
    private final PersonDao personDao = PersonDao.getInstance();
    private final CreatePersonMapper createPersonMapper = CreatePersonMapper.getInstance();

    public Long createPerson(CreatePersonDto createPersonDto) {
        ValidationResult valid = createPersonValidator.isValid(createPersonDto);
        if (!valid.isValid()) {
            throw new ValidationException(valid.getErrors());
        }
        Person person = createPersonMapper.mapFrom(createPersonDto);
        personDao.save(person);

        return person.getId();
    }

    public static PersonService getInstance() {
        return INSTANCE;
    }
}

