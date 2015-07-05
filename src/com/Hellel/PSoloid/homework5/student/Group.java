package com.Hellel.PSoloid.homework5.student;

import java.lang.String;import java.lang.System; /**
 * Created by ITHILLEL7 on 03.07.2015.
 */
public class Group {

    private Student[] students =new Student[10];

    private int numOfStudents =0;

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

//        int j=0;
//        for(int i=0; i<students.length; i++){
//            if (students[i].getSurname().equals(student.getSurname()))
//                j++;
//        }

        Student[] newStudents = new Student[students.length-1];

//        j=0;
        for(int i=0; i<students.length; i++){
            if (!students[i].getSurname().equals(student.getSurname())){
                newStudents[i]=students[i];
                numOfStudents--;
            }
        }
        students=newStudents;
    }

    public void delStudent(String surname) {
        for (int i = 0; i < students.length; i++) {
            if (students[i].getSurname().equals(surname))
                delStudent(students[i]);
        }
    }

    public void delStudent(int id) {
        for (int i = 0; i < students.length; i++) {
            if (students[i].getId() == id)
                delStudent(students[i]);
        }
    }





    public void print() {
        for (int i=0;i<numOfStudents;i++)
            System.out.println(students[i].getId()+" "+ students[i].getSurname()+"\n");
    }
}
