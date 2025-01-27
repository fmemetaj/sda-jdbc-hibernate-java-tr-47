package com.fmemetaj.service;

import com.fmemetaj.configuration.DatabaseConfiguration;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseOperations {

    public static void getAllPersons() {
        try (Connection connection = DatabaseConfiguration.getConnection();
             Statement statement = connection.createStatement()) {

            ResultSet resultSet = statement.executeQuery("SELECT * FROM Persons");
            while (resultSet.next()) {
                System.out.println("PersonID " + resultSet.getInt(1));
                System.out.println("LastName " + resultSet.getString(1));
                System.out.println("FirstName " + resultSet.getString(2));
                System.out.println("Address " + resultSet.getString(3));
                System.out.println("City " + resultSet.getString(4));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void createBookTable() {
        try (Connection connection = DatabaseConfiguration.getConnection();
             Statement statement = connection.createStatement()) {

            boolean isResultSetReturned = statement.execute("create table Book (Id INT PRIMARY KEY, Title VARCHAR(32) NOT NULL, Type VARCHAR(32), Description VARCHAR(50))");
            System.out.println(isResultSetReturned);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void addBook(int id, String title, String type, String description) {
        try (Connection connection = DatabaseConfiguration.getConnection();
             Statement statement = connection.createStatement()){

            int rowCount = statement.executeUpdate(String.format("insert into Book values (%d, '%s', '%s', '%s')", id, title, type, description));
            System.out.println(rowCount);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
