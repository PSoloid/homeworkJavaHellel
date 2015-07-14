package com.Hellel.PSoloid.homework7.MyLinkedList;

/**
 * Created by otk_prog on 14.07.2015.
 */
public class MyLinkedListApp {
    public static void main(String[] args) {
        Node elem1 = new Node(1);
        Node elem2 = new Node(2);
        Node elem3 = new Node(3);
        Node elem4 = new Node(4);
        Node elem5 = new Node(5);

        MyLinkedList myList = new MyLinkedList();

        myList.Add(elem1);
        myList.Add(elem2);
        myList.Add(elem3);
        myList.Add(elem4);
        myList.Add(elem5);

        myList.Print();
        myList.ReversePrint();


        if (myList.isEmpty()) {
            System.out.println("MyCollection is empty");
        } else {
            System.out.println("MyCollection is not empty");
        }

        if (myList.contains(elem2)) {
            System.out.println("MyCollection contains student2");
        } else {
            System.out.println("MyCollection does not contains student2");
        }

        if (myList.remove(elem2)) {
            System.out.println("student2 removed");
        } else {
            System.out.println("student2 didn't remove");
        }

        myList.Print();
    }
}
