package com.Hellel.PSoloid.homework5.student;

import java.lang.String;import java.lang.System; /**
 * Created by ITHILLEL7 on 30.06.2015.
 */
public class StudentApp {
    public static void main(String[] args){


        Student student1 = new Student(1, "Ivanov");
        Student student2 = new Student(2, "Petrov");

        student1.setMark(2,5);
        student2.setMark(6,4);

        System.out.println(student1.getMark(2));

        Group group = new Group();
        group.addStudent(student1);
        group.addStudent(student2);
        group.addStudent("Sidorov");
        group.print();
    }
}
