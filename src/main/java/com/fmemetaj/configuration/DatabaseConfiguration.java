package com.fmemetaj.configuration;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConfiguration {

    private final static String JDBC_URL = "jdbc:mysql://localhost:3306/sqldb";
    private final static String USERNAME = "root";
    private final static String PASSWORD = "Federico!1";

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(JDBC_URL, USERNAME, PASSWORD);
    }
}
