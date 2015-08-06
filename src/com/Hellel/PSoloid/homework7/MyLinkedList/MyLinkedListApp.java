package com.Hellel.PSoloid.homework7.MyLinkedList;

import java.util.Arrays;
import java.util.List;

/**
 * Created by otk_prog on 14.07.2015.
 */
public class MyLinkedListApp<T> {
    public static void main(String[] args) {
        Node elem1 = new Node("11");
        Node elem2 = new Node("22");
        Node elem3 = new Node("33");
        Node elem4 = new Node("44");
        Node elem5 = new Node("55");

        MyLinkedList myList = new MyLinkedList();

        myList.add(elem1);
        myList.add(elem2);
        myList.add(elem3);
        myList.add(elem4);
        myList.add(elem5);

        myList.print();
        System.out.println("\nReverse print\n");
        myList.reversePrint();

        if (myList.isEmpty()) {
            System.out.println("MyLinkedList is empty");
        } else {
            System.out.println("MyLinkedList is not empty");
        }

        if (myList.contains(elem2)) {
            System.out.println("MyLinkedList contains elem2");
        } else {
            System.out.println("MyLinkedList does not contains elem2");
        }

        if (myList.remove(elem2)) {
            System.out.println("elem2 removed");
        } else {
            System.out.println("elem2 didn't remove");
        }

        myList.print();



        List list =  Arrays.asList(1, 2, 3, 4, 5);


        if (myList.addAll(list)) {
            System.out.println("stringList added");
        } else {
            System.out.println("stringList did not add");
        }

        myList.print();


//        MyCollection group1 = new MyCollection();
//
//        Student student7 = new Student(7, "Fedya");
//        Student student8 = new Student(8, "Vasya");
//
//        group1.add(student3);
//        group1.add(student4);
//        group1.add(student7);
//        group1.add(student8);
//
//
//        group1.print();
        if (myList.containsAll(list)) {
            System.out.println("group1 contained");
        } else {
            System.out.println("group1 did not contain");
        }

        myList.print();


        if (myList.retainAll(list)) {
            System.out.println("group1 retained");
        } else {
            System.out.println("group1 did not retain");
        }

        myList.print();


//        myList.add(student1);
//        myList.add(student2);
//        myList.add(student5);
//        myList.add(student6);
//        myList.add(student7);
//        myList.add(student8);
//
//        myList.print();




        if (myList.removeAll(list)) {
            System.out.println("removed All");
        } else {
            System.out.println("did not remove All");
        }

        myList.print();

        myList.clear();

        System.out.println("MyLinkedList is clear");
        myList.print();
    }
}
