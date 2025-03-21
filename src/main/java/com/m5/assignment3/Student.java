package com.m5.assignment3;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Student {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        try {
            // Load the PostgreSQL driver
            Class.forName("org.postgresql.Driver");
            String url = "jdbc:postgresql://localhost:5432/m5_jdbc";
            String username = "postgres";
            String password = "KARRIHARISHRAO@780";

            // Create the connection (outside the loop)
            Connection connection = DriverManager.getConnection(url, username, password);

            while (true) {
                System.out.println("1. Add data");
                System.out.println("2. Update data");
                System.out.println("3. Delete data");
                System.out.println("4. Exit");
                System.out.println("Enter Your choice");
                int choice = sc.nextInt();

                // Create a new Statement for each operation
                Statement s = connection.createStatement();
                String query = "";

                switch (choice) {
                    case 1:
                        query = "INSERT INTO students (first_name, last_name, date_of_birth, email, phone_number) " +
                                "VALUES ('Harish', 'Karri', '2004-05-15', 'Harish.karri09@example.com', '9090903210')";
                        s.execute(query);
                        System.out.println("Data is inserted successfully....");
                        System.out.println();
                        break;

                    case 2:
                        query = "UPDATE students SET email='rohan@gmail.com' WHERE first_name='Harish'";
                        s.execute(query);
                        System.out.println("Data is updated successfully....");
                        System.out.println();
                        break;

                    case 3:
                        query = "DELETE FROM students WHERE first_name='Harish'";
                        s.execute(query);
                        System.out.println("Data is deleted successfully....");
                        System.out.println();
                        break;

                    case 4:
                        System.out.println("Exit From Programme..........");
                        // Close the Statement and Connection before exiting
                        s.close();
                        connection.close();
                        sc.close();
                        return;

                    default:
                        System.out.println("Invalid choice..........");
                        System.out.println();
                }

                // Close the Statement after each operation (but not the Connection)
                s.close();
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}