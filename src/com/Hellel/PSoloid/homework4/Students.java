package com.Hellel.PSoloid.homework4;

import java.util.Arrays;
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


        System.out.println("Input student`s surname");

        Scanner scanner = new Scanner(System.in);
        String inputSurmame=scanner.nextLine();

        String [] newStudents = new String [students.length+1];
        for(int i=0; i<students.length;i++) {
            newStudents[i] = students[i];

        }

        newStudents[newStudents.length-1] = inputSurmame;
        print(newStudents);

        return newStudents;
    }

    public static String[] delete(String [] students) {

        System.out.println("Input  student`s surname");

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


        public static void contains(String [] students) {

            System.out.println("Input  student`s surname");

            Scanner scanner = new Scanner(System.in);
            String inputSurmame = scanner.nextLine();
            boolean flag = false;

            for (int i = 0; i < students.length; i++) {
                if (students[i] == inputSurmame) {
                    System.out.println("Student " + inputSurmame + "is in list ¹ " + i);
                    flag = true;
                }
            }
            if (flag == false) {
                System.out.println("Student is not in the list");
            }
        }


        public static  String[] clear(String [] students) {
            for (int i = 0; i < students.length; i++) {
                students[i]="";
            }
            System.out.println("Massive is clear");
            return students;
        }

        public static String[] trim (String [] students) {

            int j=0;
            for ( String str : students ) {
                if (!str.equals("")) {
                    j += 1;
                }
            }

            String [] newStudents =new String [j] ;
            j=0;
            for ( String str : students ){
                if (!str.equals("")){
                    newStudents[j]=str;
                    j++;
                }

            }
            print( newStudents);
            return newStudents;
    }


    public static String[] merge(String [] students, String [] students2){


       System.out.print("union");
       String [] rezStudents = new String[students.length+students2.length];

       if(students==null)return students2;
       if(students2==null)return students;

        String[] newStudents=new String[students.length+students2.length];

        System.arraycopy(students, 0, newStudents, 0, students.length);
        System.arraycopy(students2, 0, newStudents, students.length, students2.length);

        print(newStudents);

        return newStudents;
    }

    public static String[] sort (String [] students) {
        Arrays.sort(students);
        print(students);

        return students;
    }


    public static String[] containsAll (String [] students, String [] students2){

        String [] rez = new String[students2.length];
        int j=0;
        for ( String str : students ) {
            for (int i = 0; i < students2.length; i++) {
                if (str == students2[i]) {
                    rez[j] = students2[i];
                    j++;
                }
            }
        }
        print(rez);
        return rez;
    }

    public static void equals (String [] students, String [] students2){

                  if (students.equals(students2))
                      System.out.print("equal");
                  else
                      System.out.print("unequal");
                }




    public static void run(){

        String [] students = {"Petrov","Ivanov","Sidorov","Kuznetcov","","Antonov" };
        for ( String str : students ) {
            System.out.print(str + ",");
        }

        String [] students2 = {"Lebedenko","Kononov","Sinicin"};

        String [] students3 = {"Ivanov","Sidorov","Kuznetcov"};

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
                    students = add(students);
                    break;
                case 1:
                    students = delete(students);
                    break;
                case 2:
                    contains(students);
                    break;
                case 3:
                    students = clear(students);
                    break;
                case 4:
                    students = trim(students);
                    break;
                case 5:
                    students = merge(students, students2);
                    break;
                case 6:
                    students = sort(students);
                    break;
                case 7:
                    containsAll(students, students3);
                    break;
                case 8:
                    equals(students, students2);
                    ;
                    break;
                case 9:
                    print(students);
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

}
