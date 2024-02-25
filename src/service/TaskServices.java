package service;

import enums.TaskEnum;

import java.sql.*;
import java.util.Scanner;

public class TaskServices {

    Connection connection;


    {

        try {
            connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres",
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

    public void createTask(Scanner scan) {

        System.out.print("Введите задачу: ");
        String name = scan.nextLine();
        try {
            statement.execute(String.format("insert into tasks (description, status) values('%s', '%s')", name, TaskEnum.Status.IN_PROGRES));
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Задача успешно добавлена !!!");

    }

    public void editTask(Scanner scan) {

        try {
            viewTask();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        System.out.print("Введите идентификатор задачи: ");
        int id = scan.nextInt();
        System.out.print("Введите новое описание задачи: ");
        String аname = scan.nextLine();
        String name = scan.nextLine();
        try {
            statement.execute(String.format("update tasks set description = '"+ name + "' where id = '"+id+"'"));
        } catch (SQLException e) {

            throw new RuntimeException(e);

        }

        System.out.println("Задача успешно изменена !");

    }

    public void deleteTask(Scanner scan) {

        try {
            viewTask();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        System.out.print("Введите идентификатор задачи который вы хотите удалить: ");
        int id = scan.nextInt();

        try {
            statement.execute(String.format("update tasks set status = '"+ TaskEnum.Status.DELETED + "' where id = '"+id+"'"));
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    public void viewTask() throws SQLException {

        PreparedStatement ps;
        ResultSet rs;

        try {
            String sql = "select * from tasks where status = '"+ TaskEnum.Status.IN_PROGRES +"'";
            ps = connection.prepareStatement(sql);
            rs = ps.executeQuery();

            System.out.println("id\t\tdescription\t\tstatus");

            while (rs.next()) {

                int id = rs.getInt("id");
                String name = rs.getString("description");
                String email = rs.getString("status");
                System.out.println(id + "\t\t" + name
                        + "\t\t" + email);
            }

        } catch (SQLException e) {

            throw new RuntimeException(e);

        }

    }

}
