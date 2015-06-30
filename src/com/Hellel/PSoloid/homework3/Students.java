package com.Hellel.PSoloid.homework3;

import java.util.Scanner;

/**
 * Created by Morozov on 30.06.2015.
 */
public class Students {

    public static void print(String [] students) {
        System.out.println("\nList of students:\n");
        for (String list : students) {
            System.out.println(list);
        }
    }



    public static String[] add(String [] students) {


        System.out.println("Input surname of the student");

        Scanner scanner = new Scanner(System.in);
        students[students.length + 1] = scanner.nextLine();

        print(students);

        return students;
    }

    public static String[] delete(String [] students) {

        System.out.println("Input surname of the student");

        Scanner scanner = new Scanner(System.in);

        String [] newStudents =new String [students.length-1] ;
        String inputSurmame=scanner.nextLine();
        int j=0;
        for ( String str : students ){
            if (!str.equals(inputSurmame)){
                newStudents[j]=str;
                j++;
            }

        }
        print( newStudents);
        return newStudents;
        }









    public static void run(){

        String [] students = {"Petrov","Ivanov","Sidorov","Kuznetcov","Antonov" };

        System.out.println("0. add");
        System.out.println("1. delete");
        System.out.println("2. contains");
        System.out.println("3. clear");
        System.out.println("4. trim");
        System.out.println("5. merge");
        System.out.println("6. sort");
        System.out.println("7. containsAll");
        System.out.println("8. equals");
        System.out.println("9. print");
        System.out.print("\n Input (0-4): ");

        boolean flag;
        do {
            flag =true;
            Scanner scanner = new Scanner(System.in);
            if (scanner.hasNextInt()) {
                switch (scanner.nextInt()) {
                    case 0:
                        students=add(students);
                        break;
                    case 1:
                        students =delete(students);
                        break;
                    case 2:
                        Xor.run();
                        break;
                    case 3:
//                        Grafika.run();
                        break;
                    case 4:
//                        Properties.run();
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
        while (!flag) ;
    }

}
