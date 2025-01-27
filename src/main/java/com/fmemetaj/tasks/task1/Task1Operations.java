package com.fmemetaj.tasks.task1;

import com.fmemetaj.configuration.DatabaseConfiguration;

import java.sql.*;

public class Task1Operations {

    public static void createMovieTable() {
        try (Connection connection = DatabaseConfiguration.getConnection();
             Statement statement = connection.createStatement()) {

            boolean result = statement.execute("CREATE TABLE movies (id INTEGER AUTO_INCREMENT PRIMARY KEY, title VARCHAR(255), genre VARCHAR(255), yearOfRelease INTEGER)");
            System.out.println("Table created: " + !result);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static boolean existMovieTable() {
        try (Connection connection = DatabaseConfiguration.getConnection();
             Statement statement = connection.createStatement()) {

            boolean result = statement.execute("SELECT * FROM movies");
            return result;
        } catch (SQLException e) {
            return false;
        }
    }

    public static void deleteMovieTable() {
        try (Connection connection = DatabaseConfiguration.getConnection();
             Statement statement = connection.createStatement()) {

            boolean result = statement.execute("DROP TABLE movies");
            System.out.println("Table deleted: " + !result);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void addMovie(String title, String genre, int year) {
        try (Connection connection = DatabaseConfiguration.getConnection();
             Statement statement = connection.createStatement()) {

            boolean result = statement.execute(String.format("INSERT INTO movies (title, genre, yearOfRelease) VALUES ('%s', '%s', %d)", title, genre, year));
            System.out.println("Movie created: " + !result);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void updateMovie(int id, String title, String genre, int year) {
        try (Connection connection = DatabaseConfiguration.getConnection()) {

            PreparedStatement preparedStatement = connection.prepareStatement("UPDATE movies SET title = ?, genre = ?, yearOfRelease = ? WHERE id = ?");
            preparedStatement.setString(1, title);
            preparedStatement.setString(2, genre);
            preparedStatement.setInt(3, year);
            preparedStatement.setInt(4, id);
            boolean result = preparedStatement.execute();

            System.out.println("Movie updated: " + !result);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void deleteMovieById(int id) {
        try (Connection connection = DatabaseConfiguration.getConnection();
             Statement statement = connection.createStatement()) {

            boolean result = statement.execute("DELETE FROM movies WHERE id = " + id);
            System.out.println("Movie deleted: " + !result);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void getAllMovies() {
        try (Connection connection = DatabaseConfiguration.getConnection();
             Statement statement = connection.createStatement()) {

            ResultSet resultSet = statement.executeQuery("SELECT * FROM movies");
            while (resultSet.next()) {
                System.out.println("Title: " + resultSet.getString("title"));
                System.out.println("Genre: " + resultSet.getString("genre"));
                System.out.println("Year of Release: " + resultSet.getInt("yearOfRelease"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
