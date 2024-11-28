package com.doza;

import com.doza.util.ConnectionManager;

import java.sql.SQLException;

public class LibraryRunner {
    public static void main(String[] args) {

        try (var connection = ConnectionManager.openConnection()) {
            System.out.println(connection.getTransactionIsolation());
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
