package com.doza.validator;

import com.doza.dto.PersonDto;

public class CreatePersonValidator implements Validator<PersonDto>{

    public static final CreatePersonValidator INSTANCE = new CreatePersonValidator();

    @Override
    public ValidationResult isValid(PersonDto createPersonDto) {
        ValidationResult validationResult = new ValidationResult();
        if (createPersonDto.getFirstName() == null || createPersonDto.getFirstName().trim().equals("")) {
            validationResult.addError(new Error("1", "First name is required"));
        } else if (createPersonDto.getLastName() == null || createPersonDto.getLastName().trim().equals("")) {
            validationResult.addError(new Error("2", "Last name is required"));
        } else if (createPersonDto.getEmail() == null || createPersonDto.getEmail().trim().equals("")) {
            validationResult.addError(new Error("3", "Email is required"));
        } else if (createPersonDto.getPass() == null || createPersonDto.getPass().trim().equals("")) {
            validationResult.addError(new Error("4", "Password is required"));
//        } else if (!LocalDateFormatter.format(createPersonDto.getDateOfBirth()) ) {
//            validationResult.addError(new Error("5", "Date of birth is invalid"));
        }
        return validationResult;
    }

    public static CreatePersonValidator getInstance() {
        return INSTANCE;
    }
}
