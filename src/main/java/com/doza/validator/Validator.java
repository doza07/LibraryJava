package com.doza.validator;

public interface Validator<T> {

    ValidationResult isValid(T t);
}
