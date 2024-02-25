import service.TaskServices;

import java.sql.SQLException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws SQLException {
        //SHA256:csDczTXAXEmwcsNs/1LmdEWmi8fsK3Ck+o7ZzGPlotw

        TaskServices taskServisec = new TaskServices();

        Scanner in = new Scanner(System.in);


        while (true) {
            System.out.println("Выберите действие:");
            System.out.println("1. Создать задачу");
            System.out.println("2. Редактировать задачу");
            System.out.println("3. Удалить задачу");
            System.out.println("4. Показать задачи");
            System.out.println("5. Выход");
            System.out.print("Ваш выбор: ");

            int choice = in.nextInt();
            in.nextLine(); // очистка буфера

            switch (choice) {
                case 1:
                    taskServisec.createTask(in);
                    break;
                case 2:
                    taskServisec.editTask(in);
                    break;
                case 3:
                    taskServisec.deleteTask(in);
                    break;
                case 4:
                    taskServisec.viewTask();
                    break;
                case 5:
                    System.out.println("Завершение программы.");
                    System.exit(0);
                default:
                    System.out.println("Некорректный выбор. Попробуйте снова.");
            }
        }
    }
}