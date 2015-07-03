package com.Hellel.PSoloid.homework4;

import java.util.Scanner;

/**
 * Created by Morozov on 02.07.2015.
 */
public class Menu {

    static String [] students = {"Petrov","Ivanov","Sidorov","Kuznetcov","","Antonov" };

    static String [] students2 = {"Lebedenko","Kononov","Sinicin"};

    static String [] students3 = {"Ivanov","Sidorov","Kuznetcov"};


    public static void main(String[] args) {

        Student student = new Student();

        student.setStudents(students);
        student.setStudents2(students2);
        student.setStudents3(students3);

        student.print();

    boolean flag,flag1;
    do {
        flag1 = false;

        System.out.println("\n\n0. add");
        System.out.println("1. delete");
        System.out.println("2. contains");
        System.out.println("3. clear");
        System.out.println("4. trim");
        System.out.println("5. merge");
        System.out.println("6. sort");
        System.out.println("7. containsAll");
        System.out.println("8. equals");
        System.out.println("9. print");
        System.out.println("10. Exit");
        System.out.print("\n Input (0-10): ");


        do {
            flag = true;
            Scanner scanner = new Scanner(System.in);
            if (scanner.hasNextInt()) {
                switch (scanner.nextInt()) {
                    case 0:
                        student.add(inputSurname());
                        student.print();
                        break;
                    case 1:
                        student.delete(inputSurname());
                        student.print();
                        break;
                    case 2:
                        student.contains(inputSurname());
                        student.print();
                        break;
                    case 3:
                        student.clear();
                        student.print();
                        break;
                    case 4:
                        student.trim();
                        student.print();
                        break;
                    case 5:
                        student.merge();
                        student.print();
                        break;
                    case 6:
                        student.sort();
                        student.print();
                        break;
                    case 7:
                        student.containsAll();
                        student.print();
                        break;
                    case 8:
                        if (student.equals())
                            System.out.print("equal");
                        else
                            System.out.print("unequal");
                        break;
                    case 9:
                        student.print();
                        break;
                    case 10:
                        flag1 = true;
                        flag = true;
                        break;
                    default:
                        System.out.println("error, try again.");
                        flag = false;
                        break;
                }
            } else {
                System.out.println("error, try again.");
                flag = false;
            }
        }
        while (!flag);
    }
    while (!flag1) ;
}

    public static String inputSurname() {
        System.out.print("Input student`s surname: ");

        Scanner scanner = new Scanner(System.in);
        String inputSurmame=scanner.nextLine();

        return inputSurmame;
    }
}
