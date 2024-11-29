package com.doza.dao;

import java.util.List;
import java.util.Optional;

public interface Dao <K, T> {

    List<T> findAll();

    Optional<T> findById(K id);

    T save(T entity);

    T update(T entity);

    boolean delete(T entity);
}
