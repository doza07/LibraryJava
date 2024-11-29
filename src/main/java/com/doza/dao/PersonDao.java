package com.doza.dao;

import com.doza.entity.Person;

import java.util.List;
import java.util.Optional;

public class PersonDao implements Dao<Long, Person> {

    @Override
    public List<Person> findAll() {
        return List.of();
    }

    @Override
    public Optional<Person> findById(Long id) {
        return Optional.empty();
    }

    @Override
    public Person save(Person entity) {
        return null;
    }

    @Override
    public Person update(Person entity) {
        return null;
    }

    @Override
    public boolean delete(Person entity) {
        return false;
    }
}
