package com.Hellel.PSoloid.homework7;

import com.Hellel.PSoloid.homework5.student.Student;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

/**
 * Created by Morozov on 12.07.2015.
 */
public class MyCollectionApp {

    public static void main(String[] args) {

        Student student1 = new Student(0, "Ivanov");
        Student student2 = new Student(1, "Petrov");
        Student student3 = new Student(2, "Sidorov");
        Student student4 = new Student(4, "Kuznetcov");
        Student student5 = new Student(5, "Antonov");
        Student student6 = new Student(6, "Sinicin");

        student1.setMark(2, 5);
        student2.setMark(6, 4);
        student3.setMark(2, 4);
        student4.setMark(5, 5);
        student5.setMark(4, 5);
        student6.setMark(6, 3);


        MyCollection group = new MyCollection();


        System.out.println(group.size());

        group.add(student1);
        group.add(student2);
        group.add(student3);
        group.add(student4);
        group.add(student5);
        group.add(student6);

        group.print();

        if (group.isEmpty()) {
            System.out.println("MyCollection is empty");
        } else {
            System.out.println("MyCollection is not empty");
        }

        if (group.contains(student2)) {
            System.out.println("MyCollection contains student2");
        } else {
            System.out.println("MyCollection does not contains student2");
        }

        if (group.remove(student2)) {
            System.out.println("student2 removed");
        } else {
            System.out.println("student2 didn't remove");
        }

        group.print();

        List<String> stringList = Arrays.asList("1", "2", "3", "4");

        if (group.addAll(stringList)) {
            System.out.println("stringList added");
        } else {
            System.out.println("stringList did not add");
        }

        group.print();


        MyCollection group1 = new MyCollection();

        Student student7 = new Student(7, "Fedya");
        Student student8 = new Student(8, "Vasya");

        group1.add(student3);
        group1.add(student4);
        group1.add(student7);
        group1.add(student8);


        group1.print();

        if (group.retainAll(group1)) {
            System.out.println("group1 retained");
        } else {
            System.out.println("group1 did not retain");
        }

        group.print();


        group.add(student1);
        group.add(student2);
        group.add(student5);
        group.add(student6);
        group.add(student7);
        group.add(student8);

        group.print();


        if (group.containsAll(group1)) {
            System.out.println("group1 contained");
        } else {
            System.out.println("group1 did not contain");
        }

        group.print();

        if (group.removeAll(group1)) {
            System.out.println("removed All");
        } else {
            System.out.println("did not remove All");
        }

        group.print();

        group.clear();

        System.out.println("MyCollection is clear");
        group.print();


    }

}
