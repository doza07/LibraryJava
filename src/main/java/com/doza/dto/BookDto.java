package com.doza.dto;

public class BookDto {
    private final Long id;
    private final String description;

    public BookDto(Long id, String description) {
        this.id = id;
        this.description = description;
    }

    public Long getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    @Override
    public String toString() {
        return "BookDto{" +
               "id=" + id +
               ", description='" + description + '\'' +
               '}';
    }
}
