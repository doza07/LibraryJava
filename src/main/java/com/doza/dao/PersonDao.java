package com.doza.dao;

import com.doza.entity.Person;
import com.doza.util.ConnectionManager;

import java.sql.*;
import java.util.List;
import java.util.Optional;

public class PersonDao implements Dao<Long, Person> {

    private static final PersonDao INSTANCE = new PersonDao();
    private static final String SAVE_SQL = """
            INSERT INTO person (email, pass, first_name, last_name, date_of_birth) VALUES  (?, ?, ?, ?, ?);
            """;
    private static final String GET_BY_EMAIL_AND_PASSWORD_SQL =
            "SELECT * FROM person WHERE email = ? AND pass = ?";

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
        try (Connection connection = ConnectionManager.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(SAVE_SQL, Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1, entity.getEmail());
            preparedStatement.setString(2, entity.getPass());
            preparedStatement.setString(3, entity.getFirstName());
            preparedStatement.setString(4, entity.getLastName());
            preparedStatement.setObject(5, entity.getDateOfBirth());

            preparedStatement.executeUpdate();
            ResultSet generatedKeys = preparedStatement.getGeneratedKeys();
            generatedKeys.next();
            entity.setId(generatedKeys.getObject("id", Long.class));


        } catch (SQLException e) {
            e.printStackTrace();
        }
        return entity;
    }

    @Override
    public Person update(Person entity) {
        return null;
    }

    @Override
    public boolean delete(Person entity) {
        return false;
    }

    public Optional<Person> findByEmailAndPassword(String email, String password) {
        try (var connection = ConnectionManager.getConnection();
             var preparedStatement = connection.prepareStatement(GET_BY_EMAIL_AND_PASSWORD_SQL)) {
            preparedStatement.setString(1, email);
            preparedStatement.setString(2, password);

            var resultSet = preparedStatement.executeQuery();
            Person person = null;
            if (resultSet.next()) {
                person = buildEntity(resultSet);
            }

            return Optional.ofNullable(person);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private Person buildEntity(ResultSet resultSet) throws java.sql.SQLException {
        return new Person(
                resultSet.getObject("id", Integer.class),
                resultSet.getObject("email", String.class),
                resultSet.getObject("password", String.class),
                resultSet.getObject("first_name", String.class),
                resultSet.getObject("last_name", String.class),
                resultSet.getObject("birthday", Date.class).toLocalDate()
        );
    }

    public static PersonDao getInstance() {
        return INSTANCE;
    }
}
