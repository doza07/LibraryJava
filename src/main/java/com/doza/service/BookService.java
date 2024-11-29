package com.doza.service;

import com.doza.dao.BookDao;
import com.doza.dto.BookDto;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class BookService {

    private static final BookService INSTANCE = new BookService();

    private final BookDao bookDao = BookDao.getInstance();

    private BookService() {
    }

    public List<BookDto> findAllBooks() {
        return bookDao.findAll().stream()
                .map(book -> new BookDto(
                        book.getId(),
                        """
                                %s - %s - %s - %s
                                """.formatted(
                                book.getTitle(), book.getAuthor(), book.getDescription(), book.getPublication().toString())
                ))
                .collect(Collectors.toList());
    }

    public Optional<BookDto> findBookById(Long id) {
        return bookDao.findById(id).map(book -> new BookDto(
                        book.getId(),
                        """
                                %s - %s - %s - %s
                                """.formatted(
                                book.getTitle(), book.getAuthor(), book.getDescription(), book.getPublication().toString())
                ));
    }

    public static BookService getInstance() {
        return INSTANCE;
    }
}
