package service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class TaskServisec {

    Connection connection;


    {

        try {
            connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/tix",
                    "postgres",
                    "1234");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }


    Statement statement;

    {
        try {
            statement = connection.createStatement();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

//    Task task = new Task();
    public static void createTask(Scanner scan) {

        System.out.print("Введите задачу: ");
        String name = scan.next();
        try {
            statement.execute(String.format("insert into tasks (description, status) values('%s', '%s')", name, "Назначено"));
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    public static void editTask(Scanner scan) {

        System.out.print("Введите задачу: ");
        String name = scan.next();
        try {
            statement.execute(String.format("insert into tasks (description, status) values('%s', '%s')", name, "Назначено"));
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    public static void deleteTask(Scanner scan) {

        System.out.print("Введите задачу: ");
        String name = scan.next();
        try {
            statement.execute(String.format("insert into tasks (description, status) values('%s', '%s')", name, "Назначено"));
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    public static void viewTask(Scanner scan) {

        System.out.print("Введите задачу: ");
        String name = scan.next();
        try {
            statement.execute(String.format("insert into tasks (description, status) values('%s', '%s')", name, "Назначено"));
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

}
