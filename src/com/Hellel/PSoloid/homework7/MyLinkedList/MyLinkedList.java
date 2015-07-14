package com.Hellel.PSoloid.homework7.MyLinkedList;

import java.awt.dnd.InvalidDnDOperationException;

/**
 * Created by otk_prog on 13.07.2015.
 */
public class MyLinkedList {
    private Node first;
    private Node current;
    private Node last;
    private int size;

    public MyLinkedList() {
        size = 0;
        first = current = last = null;
    }

    public boolean isEmpty() {
        return size == 0;
    }


    public void Add(Object o) {

        Node newNode = new Node(o);

        if (first == null) {
            first = last = newNode;
        } else {
            last.setNext(newNode);
            newNode.setPrev(last);
            last = newNode;
        }
        size++;
    }


    public void Print() //вывести в прямом порядке
    {
        if (first == null) {
            System.out.println("List is empty");
            return;
        }
        current = first;
        int count = 0;
        while (current != null) {
            System.out.println("Element " + count + " : " + current.getNode().toString());
            count++;
            current = current.getNext();
        }
    }

    public void ReversePrint() //вывести в обратном порядке
    {
        if (last == null) {
            System.out.print("Doubly Linked List is empty");
            return;
        }
        current = last;
        int count = 0;

        System.out.println("\nReverse list\n");

        while (current != null) {
            System.out.println("Element " + count + " : " + current.getNode().toString());
            count++;
            current = current.getPrev();
        }
    }

    public boolean remove(Object o) {

        if (o == null) {
            for (Node x = first; x != null; x = x.getNext()) {
                if (x.getNode() == null) {
                    unlink(x);
                    return true;
                }
            }
        } else {
            for (Node x = first; x != null; x = x.getNext()) {
                if (o.equals(x.getNode())) {
                    unlink(x);
                    return true;
                }
            }
        }
        return false;
    }

    public void unlink(Node o) {

        if (o.getPrev() == null) {
            first = o.getNext();
        } else {
            o.getPrev().setNext(o.getNext());
            o.setPrev(null);
        }

        if (o.getNext() == null) {
            last = o.getPrev();
        } else {
            o.getNext().setPrev(o.getPrev());
            o.setNext(null);
        }

        o.setNode(null);
        size--;
    }


    public Node FindNode(Object o) {
        current = first;
        while (current != null) {
            current = current.getNext();
        }
        return current;
    }

    public boolean contains(Object o) {
        for (Node x = first; x != null; x = x.getNext()) {
            if (o.equals(x.getNode())) {
                return true;
            }
        }
        return false;
    }


}
