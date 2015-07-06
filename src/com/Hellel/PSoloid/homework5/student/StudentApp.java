package com.Hellel.PSoloid.homework5.student;

import java.lang.String;import java.lang.System; /**
 * Created by ITHILLEL7 on 30.06.2015.
 */
public class StudentApp {
    public static void main(String[] args){


        Student student1 = new Student(0, "Ivanov");
        Student student2 = new Student(1, "Petrov");
        Student student3 = new Student(2, "Sidorov");
//        Student student4 = new Student(4, "Kuznetcov");
//        Student student5 = new Student(5, "Antonov");
//        Student student6 = new Student(6, "Sinicin");

        student1.setMark(2,5);
        student2.setMark(6,4);
        student3.setMark(2,4);
//        student4.setMark(5,5);
//        student5.setMark(4,5);
//        student6.setMark(6,3);


        Group group = new Group();

        group.addStudent(student1);
        group.addStudent(student2);
        group.addStudent(student3);
        group.addStudent("Kuznetcov");
        group.addStudent("Antonov");
        group.addStudent("Sinicin");

        System.out.println("New group");
        group.print();


        group.delStudent(student1);
        group.delStudent(3);
        group.delStudent("Antonov");

        System.out.println("Deleted Students");
        group.print();

        group.containsStudent(student2);
        group.containsStudent(student3);
        group.containsStudent("Sinicin");
        group.containsStudent("Antonov");

        Group group2 = new Group();

        group2.addStudent("Horstman");
        group2.addStudent("Ted");
        group2.addStudent("John");

        System.out.println("Group second");
        group2.print();

        group.merge(group2);

        System.out.println("Merged groups");
        group.print();

//        group.sort();
//
//        System.out.println("Sorted group");
//        group.print();

        if (group.equals(group2))
            System.out.println("equal");
        else
            System.out.println("unequal");

        group.clear();

        group.print();
    }
}
