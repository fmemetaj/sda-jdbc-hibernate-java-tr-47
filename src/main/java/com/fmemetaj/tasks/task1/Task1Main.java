package com.fmemetaj.tasks.task1;

import java.util.Scanner;

public class Task1Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        boolean continueLoop = true;

        while (continueLoop) {

            System.out.println("Please enter operation number: ");
            System.out.println("1. Create Movie Table ");
            System.out.println("2. Add Movie");
            System.out.println("3. Update Movie");
            System.out.println("4. Delete Movie by ID");
            System.out.println("5. Display all Movies");
            System.out.println("6. Close application");

            int operation = scanner.nextInt();

            switch (operation) {
                case 1:
                    createMovieTable();
                    break;
                case 2:
                    addMovie(scanner);
                    break;
                case 3:
                    updateMovie(scanner);
                    break;
                case 4:
                    deleteMovie(scanner);
                    break;
                case 5:
                    Task1Operations.getAllMovies();
                    break;
                case 6:
                    System.out.println("Thank you for using our application");
                    continueLoop = false;
                    break;
                default:
                    System.out.println("Invalid operation");
            }
        }
    }

    private static void createMovieTable() {
        if (Task1Operations.existMovieTable()) {
            Task1Operations.deleteMovieTable();
        }

        Task1Operations.createMovieTable();
    }

    private static void addMovie(Scanner scanner) {
        System.out.println("Please enter movie title: ");
        String title = scanner.next();

        System.out.println("Please enter movie genre: ");
        String genre = scanner.next();

        System.out.println("Please enter movie year: ");
        int year = scanner.nextInt();

        Task1Operations.addMovie(title, genre, year);
    }

    private static void updateMovie(Scanner scanner) {
        System.out.println("Please enter movie id: ");
        int id = scanner.nextInt();

        System.out.println("Please enter movie title: ");
        String title = scanner.next();

        System.out.println("Please enter movie genre: ");
        String genre = scanner.next();

        System.out.println("Please enter movie year: ");
        int year = scanner.nextInt();

        Task1Operations.updateMovie(id, title, genre, year);
    }

    private static void deleteMovie(Scanner scanner) {
        System.out.println("Please enter movie id: ");
        int id = scanner.nextInt();

        Task1Operations.deleteMovieById(id);
    }
}
