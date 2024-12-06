package com.doza.mapper;

public interface Mapper<F, T> {

    T mapFrom(F obj);
}
