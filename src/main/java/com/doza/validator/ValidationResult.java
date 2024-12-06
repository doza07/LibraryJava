package com.doza.validator;

import java.util.ArrayList;
import java.util.List;

public class ValidationResult {
    private List<Error> errors = new ArrayList<Error>();

    public void addError(Error error) {
        errors.add(error);
    }

    public boolean isValid() {
        return errors.isEmpty();
    }

    public List<Error> getErrors() {
        return errors;
    }
}
