package com.Hellel.PSoloid.jdbc;


import com.Hellel.PSoloid.homework5.student.Student;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by otk_prog on 14.09.2015.
 */
public class JdbcStudent {

    private static Connection getDBConnection() {
        Connection dbConnection = null;
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }
        try {
            dbConnection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/Hillel", "postgres", "552230");
            return dbConnection;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return dbConnection;
    }


    private static void createStudentsTable() {
        Connection dbConnection = null;
        Statement statement = null;

        String dropStudents = "DROP TABLE IF EXISTS STUDENTS";

        String createStudents = "CREATE TABLE STUDENTS("
                + "ID INT PRIMARY KEY NOT NULL, "
                + "SURNAME VARCHAR(20) NOT NULL "
                + ")";


        try {
            dbConnection = getDBConnection();
            statement = dbConnection.createStatement();


            statement.execute(dropStudents);
            statement.execute(createStudents);


            System.out.println("Table \"Students\" is created!");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                if (statement != null) {
                    statement.close();
                }
                if (dbConnection != null) {
                    dbConnection.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    private static void createMarksTable() {
        Connection dbConnection = null;
        Statement statement = null;

        String dropMarks = "DROP TABLE IF EXISTS MARKS";

        String createMarks = "CREATE TABLE MARKS("
                + "ID INT, "
                + "MARKS INT"
                + ")";

        try {
            dbConnection = getDBConnection();
            statement = dbConnection.createStatement();

            statement.execute(dropMarks);
            statement.execute(createMarks);

            System.out.println("Table \"Marks\" is created!");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                if (statement != null) {
                    statement.close();
                }
                if (dbConnection != null) {
                    dbConnection.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }


    private static void printStudents() {
        Statement statement = null;
        Connection dbConnection = null;

        try {
            dbConnection = getDBConnection();
            statement = dbConnection.createStatement();

            ResultSet result1 = statement.executeQuery(
                    "SELECT s.ID, s.SURNAME, m.MARKS FROM STUDENTS s INNER JOIN MARKS m USING(id) ORDER BY s.ID");

            System.out.println("\nSTUDENTS\n");
            while (result1.next()) {
                System.out.println("#" + result1.getRow()
                        + "\t ID " + result1.getInt("ID")
                        + "\t" + result1.getString("SURNAME")
                        + "\t" + result1.getString("MARKS"));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                if (statement != null) {
                    statement.close();
                }
                if (dbConnection != null) {
                    dbConnection.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }


    private static void insertStudent(Student student) {
        Statement statement = null;
        Connection dbConnection = null;

        try {
            dbConnection = getDBConnection();
            statement = dbConnection.createStatement();

            String insertStudent = "INSERT INTO STUDENTS (ID, SURNAME) VALUES (" + student.getId() + ",'" + student.getSurname() + "')";

            statement.executeUpdate(insertStudent);

            for (int i : student.getMarks()) {
                if (i != 0) {
                    String insertMarks = "INSERT INTO MARKS (ID, MARKS) VALUES (" + student.getId() + "," + i + ")";

                    statement.executeUpdate(insertMarks);
                }
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                if (statement != null) {
                    statement.close();
                }
                if (dbConnection != null) {
                    dbConnection.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }


    private static void deleteStudent(Student student) {
        Statement statement = null;
        Connection dbConnection = null;

        try {
            dbConnection = getDBConnection();
            statement = dbConnection.createStatement();

            String deleteStudent = "DELETE FROM STUDENTS WHERE ID = " + student.getId();

            statement.executeUpdate(deleteStudent);

            String deleteMarks = "DELETE FROM MARKS WHERE ID = " + student.getId();

            statement.executeUpdate(deleteMarks);


        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                if (statement != null) {
                    statement.close();
                }
                if (dbConnection != null) {
                    dbConnection.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    private static void updateStudent(Student student) {
        Statement statement = null;
        Connection dbConnection = null;

        try {
            dbConnection = getDBConnection();
            statement = dbConnection.createStatement();

            String updateStudent = "UPDATE STUDENTS SET SURNAME = '" + student.getSurname() + "' WHERE ID = " + student.getId();
            statement.executeUpdate(updateStudent);

            String deleteMarks = "DELETE FROM MARKS WHERE ID = " + student.getId();
            statement.executeUpdate(deleteMarks);

            for (int i : student.getMarks()) {
                if (i != 0) {
                    String insertMarks = "INSERT INTO MARKS (ID, MARKS) VALUES (" + student.getId() + "," + i + ")";

                    statement.executeUpdate(insertMarks);

                }
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                if (statement != null) {
                    statement.close();
                }
                if (dbConnection != null) {
                    dbConnection.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }


    public static void main(String[] args) {

        createStudentsTable();
        createMarksTable();

        Student student1 = new Student(0, "Ivanov");
        Student student2 = new Student(1, "Petrov");
        Student student3 = new Student(2, "Sidorova");
        Student student4 = new Student(4, "Kuznetcov");
        Student student5 = new Student(5, "Antonov");
        Student student6 = new Student(6, "Sinicin");

        student1.setMark(2, 3);
        student1.setMark(5, 2);
        student1.setMark(3, 5);
        student2.setMark(6, 4);
        student3.setMark(2, 3);
        student3.setMark(6, 5);
        student3.setMark(3, 4);
        student4.setMark(5, 5);
        student5.setMark(4, 5);
        student6.setMark(6, 3);

        insertStudent(student1);
        insertStudent(student2);
        insertStudent(student3);
        insertStudent(student4);
        insertStudent(student5);
        insertStudent(student6);

        printStudents();

        deleteStudent(student5);
        deleteStudent(student1);

        printStudents();

        student3.setSurname("Ivanova");
        updateStudent(student3);

        printStudents();


    }

}
