package com.Hellel.PSoloid.homework4;

import java.util.Arrays;


public class Student {


    static String [] students;

    static String [] students2;

    static String [] students3;

    public void setStudents(String[] students) {
        this.students = students;
    }

    public void setStudents2(String[] students2) {
        this.students2 = students2;
    }

    public void setStudents3(String[] students3) {
        this.students3 = students3;
    }

    public String[] getStudents() {

        return students;
    }

    public String[] getStudents2() {
        return students2;
    }

    public String[] getStudents3() {
        return students3;
    }



    public static void print() {
        System.out.println("\nList of students:\n");
        for (String list : students) {
            System.out.println(list);
        }
    }


    public static void add(String Surmame) {

        String [] newStudents = new String [students.length+1];
            for(int i=0; i<students.length;i++) {
               newStudents[i] = students[i];
         }

        students=newStudents;
        students[students.length-1] = Surmame;
    }

    public static void delete(String Surmame) {

        int j=0;
        for ( String str : students ){
            if (str.equals(Surmame))
                j++;
            }

        String [] newStudents =new String [students.length-j] ;

        j=0;
        for ( String str : students ){
            if (!str.equals(Surmame)){
                newStudents[j]=str;
                j++;
            }
        }
        students=newStudents;
        }


        public static void contains(String Surmame) {

            boolean flag = false;

            for (int i = 0; i < students.length; i++) {
                if (students[i].equals(Surmame)) {
                    System.out.println("Student " + Surmame + "is in list ¹ " + i);
                    flag = true;
                }
            }
            if (flag == false) {
                System.out.println("Student is not in the list");
            }
        }


        public static  void clear() {
            for (int i = 0; i < students.length; i++) {
                students[i]="";
            }
            System.out.println("Massive is clear");

        }

        public static void trim () {

            int j=0;
            for ( String str : students ) {
                if (!str.equals("")) {
                    j++;
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
            students=newStudents;
    }


    public static void merge(){


       System.out.print("union");

        String[] newStudents=new String[students.length+students2.length];

        System.arraycopy(students, 0, newStudents, 0, students.length);
        System.arraycopy(students2, 0, newStudents, students.length, students2.length);

        students=newStudents;

    }

    public static void sort () {
        Arrays.sort(students);
    }


    public static void containsAll (){

        String [] rez = new String[students3.length];
        int j=0;
        for ( String str : students ) {
            for (int i = 0; i < students3.length; i++) {
                if (str.equals(students3[i])) {
                    rez[j] = students3[i];
                    j++;
                }
            }
        }
        students=rez;
    }

    public static boolean equals (){

                  if (students.equals(students2))
                      return true;
                  else
                      return false;
                }
}
