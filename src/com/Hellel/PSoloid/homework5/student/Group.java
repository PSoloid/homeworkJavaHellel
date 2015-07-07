package com.Hellel.PSoloid.homework5.student;

import java.lang.String;
import java.lang.System;
import java.util.Arrays;
import java.util.Comparator;

/**
 * Created by ITHILLEL7 on 03.07.2015.
 */
public class Group {
    private Student[] students =new Student[10];

    private int numOfStudents =0;


    public void setNumOfStudents(int numOfStudents) {
        this.numOfStudents = numOfStudents;
    }

    public void setStudents(Student[] students) {
        this.students = students;
    }

    public Student[] getStudents() {
        return students;
    }

    public int getNumOfStudents() {
        return numOfStudents;
    }

    public void addStudent(Student student) {
        if(numOfStudents<students.length-1){
            students[numOfStudents]=student;
            numOfStudents++;
        }else{
            Student[] newStudents = new Student[students.length*2];
            for(int i=0; i<students.length; i++){
                newStudents[i] = students[i];

                newStudents[numOfStudents]=student;
                numOfStudents++;
                students = newStudents;
            }
        }

    }

    public void addStudent(String surname) {
        Student student = new Student(numOfStudents,surname);
        addStudent(student);
    }

    public void delStudent(Student student) {

        Student[] newStudents = new Student[students.length-1];

        int num = numOfStudents;
        int j=0;
        for(int i=0; i<num; i++){
            if (!students[i].getSurname().equals(student.getSurname())){
                newStudents[j]=students[i];
                j++;
            }else
                numOfStudents--;
        }
        students=newStudents;
    }

    public void delStudent(String surname) {
        for (int i = 0; i < numOfStudents; i++) {
            if (students[i].getSurname().equals(surname))
                delStudent(students[i]);
        }
    }

    public void delStudent(int id) {
        for (int i = 0; i < numOfStudents; i++) {
            if (students[i].getId() == id)
                delStudent(students[i]);
        }
    }

    public  void containsStudent(Student student) {

        boolean flag = false;

        for(int i=0; i<numOfStudents; i++){
            if (students[i].getSurname().equals(student.getSurname())){
                System.out.println("Student " + students[i].getSurname() + " is in list id " + students[i].getId());
//                student.print();
                flag = true;
            }
        }
        if (flag == false) {
            System.out.println("Student " + student.getSurname() + " is not in the list");
        }
    }

    public void containsStudent(String surname) {
        boolean flag = false;
        for (int i = 0; i < numOfStudents; i++) {
            if (students[i].getSurname().equals(surname)) {
                containsStudent(students[i]);
                flag = true;
            }
        }
        if (flag == false) {
            System.out.println("Student " + surname + " is not in the list");
            }

    }

    public void clear() {
        int j = numOfStudents-1;
        for (int i = j; i >= 0; i--) {
            if (students[i] != null)
            delStudent(students[i]);
        }
        System.out.println("Massive is clear");

    }

    public void merge(Group group2){


        Group newGroup=new Group();

        System.arraycopy(students, 0, newGroup.students, 0, numOfStudents);
        System.arraycopy(group2.students, 0, newGroup.students, numOfStudents, group2.numOfStudents);

        students=newGroup.students;
        numOfStudents=numOfStudents+group2.numOfStudents;
    }

    public void trim () {

        int j=0;
//        for ( Student st : students ) {
//            if (!st.getSurname().equals("")) {
//                j++;
//            }
//        }

        Student [] newStudents =new Student [numOfStudents] ;
        j=0;
        for (int i = 0; i < numOfStudents; i++){
//            if (!st.equals("")){
                newStudents[j]=students[i];
                j++;
//            }

        }
        students=newStudents;
    }

    public void sort () {
        Arrays.sort(students);
    }


    public void containsAll (Group group2){

        Group newGroup=new Group();
        int j=0;
        for ( Student stud : students ) {
            for (int i = 0; i < group2.students.length; i++) {
                if (stud.equals(group2.students[i])) {
                    newGroup.students[j] = group2.students[i];
                    j++;
                }
            }
        }
        students=newGroup.students;
    }

    public boolean equals (Group group2){

        if (students.equals(group2.students))
            return true;
        else
            return false;
    }



    public void print() {
        for (int i=0;i<numOfStudents;i++)
            System.out.print(students[i].getId()+" "+ students[i].getSurname()+"\n");
    }
}
