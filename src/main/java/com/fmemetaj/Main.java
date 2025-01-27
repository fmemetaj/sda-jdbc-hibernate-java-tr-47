package com.fmemetaj;


import com.fmemetaj.service.DatabaseOperations;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Please choose operation");
        System.out.println("1. Get all persons");
        System.out.println("2. Create book table");
        System.out.println("3. Add book");

        int operation = scanner.nextInt();

        switch (operation) {
            case 1:
                DatabaseOperations.getAllPersons();
                break;
            case 2:
                DatabaseOperations.createBookTable();
                break;
            case 3:
                System.out.println("Insert book id");
                int id = scanner.nextInt();

                System.out.println("Insert book title");
                String title = scanner.next();

                System.out.println("Insert book type");
                String type = scanner.next();

                System.out.println("Insert book description");
                String description = scanner.next();

                DatabaseOperations.addBook(id, title, type, description);
                break;

            default:
                System.out.println("Invalid operation");
        }
    }
}