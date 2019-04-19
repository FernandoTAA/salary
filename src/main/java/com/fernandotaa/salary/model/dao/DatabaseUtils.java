package com.fernandotaa.salary.model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Utility class for common actions for database
 */
final public class DatabaseUtils {

    private DatabaseUtils() {
    }

    /**
     * Get the configured database connection
     *
     * @return Database connection
     * @throws SQLException - Database error
     */
    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection("jdbc:h2:./database");
    }
}
