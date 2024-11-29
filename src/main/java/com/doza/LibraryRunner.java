package com.doza;

import com.doza.util.ConnectionManager;

import java.sql.SQLException;

public class LibraryRunner {
    public static void main(String[] args) {

        String sql = """ 
        SELECT * FROM Person
        """;

        try (var connection = ConnectionManager.getConnection()) {

            var prepareStatement = connection.prepareStatement(sql);
            prepareStatement.setFetchSize(50);
            prepareStatement.setMaxRows(100);
            prepareStatement.setQueryTimeout(10);

            var result = prepareStatement.executeQuery();
            System.out.println(result);

        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }
}
