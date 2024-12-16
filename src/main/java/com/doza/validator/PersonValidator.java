package com.doza.validator;

import com.doza.dto.PersonDto;
import com.doza.util.LocalDateFormatter;

public class PersonValidator implements Validator<PersonDto> {

    public static final PersonValidator INSTANCE = new PersonValidator();

    @Override
    public ValidationResult isValid(PersonDto createPersonDto) {
        ValidationResult validationResult = new ValidationResult();
        if (createPersonDto.getEmail() == null || createPersonDto.getEmail().trim().isEmpty()) {
            validationResult.addError(new Error("3", "Email is required"));
        } else if (createPersonDto.getPass() == null || createPersonDto.getPass().trim().isEmpty()) {
            validationResult.addError(new Error("4", "Password is required"));
        }
        return validationResult;
    }

    public static PersonValidator getInstance() {
        return INSTANCE;
    }
}
