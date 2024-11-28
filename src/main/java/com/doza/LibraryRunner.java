package com.doza;

import com.doza.util.ConnectionManager;

import java.sql.SQLException;

public class LibraryRunner {
    public static void main(String[] args) {

        String sql = """ 
        SELECT * FROM Person
        """;

        try (var connection = ConnectionManager.openConnection()) {
            var statement = connection.createStatement();
            var result = statement.executeQuery(sql);
            while (result.next()) {
                System.out.println(result.getLong("id"));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
