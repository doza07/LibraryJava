package com.doza.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionManager {

    private static final String URL = "db.url";
    private static final String USER = "db.username";
    private static final String PASSWORD = "db.password";

    static {
        loadDriver();
    }

    public ConnectionManager() {
    }

    public  static Connection openConnection() {
        try {
            return DriverManager.getConnection(
                    PropertiesUtil.getProperty(URL),
                    PropertiesUtil.getProperty(USER),
                    PropertiesUtil.getProperty(PASSWORD)
            );
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private static void loadDriver() {
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

}
