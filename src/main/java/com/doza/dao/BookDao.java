package com.doza.dao;

import com.doza.entity.Book;
import com.doza.util.ConnectionManager;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class BookDao implements Dao<Long, Book> {

    private static final BookDao INSTANCE = new BookDao();

    private static final String FIND_ALL_SQL = """
            SELECT * FROM book
            """;

    private static final String FIND_BOOK_BY_ID = FIND_ALL_SQL + """
            WHERE id = ?
            """;

    private BookDao() {
    }

    @Override
    public List<Book> findAll() {
        try(var connection = ConnectionManager.getConnection()){
            PreparedStatement prepareStatement = connection.prepareStatement(FIND_ALL_SQL);
            ResultSet resultSet = prepareStatement.executeQuery();
            List<Book> books = new ArrayList<>();
            while (resultSet.next()) {
                books.add(buildBook(resultSet));
            }
            return books;
        }catch (SQLException e){
            e.printStackTrace();
        }
        return null;
    }


    @Override
    public Optional<Book> findById(Long id) {
        try(var connection = ConnectionManager.getConnection()){
            PreparedStatement prepareStatement = connection.prepareStatement(FIND_BOOK_BY_ID);
            prepareStatement.setLong(1, id);
            ResultSet resultSet = prepareStatement.executeQuery();
            Book book = buildBook(resultSet);
            return Optional.of(book);
        }catch (SQLException e){
            e.printStackTrace();
        }
        return Optional.empty();
    }

    @Override
    public Book save(Book entity) {
        return null;
    }

    @Override
    public Book update(Book entity) {
        return null;
    }

    @Override
    public boolean delete(Book entity) {
        return false;
    }

    public static BookDao getInstance() {
        return INSTANCE;
    }

    private Book buildBook(ResultSet resultSet) {
        try {
            return new Book(
                    resultSet.getString("id"),
                    resultSet.getString("author"),
                    resultSet.getString("description"),
                    resultSet.getDate("publication").toLocalDate()
            );
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
