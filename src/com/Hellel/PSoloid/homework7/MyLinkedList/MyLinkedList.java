package com.Hellel.PSoloid.homework7.MyLinkedList;

import java.util.*;


/**
 * Created by otk_prog on 13.07.2015.
 */
public class MyLinkedList implements Iterable<Object> {
    private Node first;
    private Node last;
    private int size;


    public MyLinkedList() {
        size = 0;
        first = last = null;
    }

    @Override
    public Iterator<Object> iterator() {
        return new MyLinkedListIterator(this.first);
    }

    public boolean isEmpty() {
        return size == 0;
    }


    public void add(Object o) {

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


    public void print() {
        MyLinkedListIterator itr = new MyLinkedListIterator(first);

        if (isEmpty()) {
            System.out.println("List is empty");
            return;
        }

        int count = 0;

        while (itr.hasNext()) {
            System.out.println("Element " + count + " : " + itr.next().toString());
            count++;
        }
    }

    public void reversePrint(){
        MyLinkedListIterator itr = new MyLinkedListIterator(last);

        if (isEmpty()) {
            System.out.println("List is empty");
            return;
        }

        int count = 0;

        while (itr.hasNext()) {
            System.out.println("Element " + count + " : " + itr.prev().toString());
            count++;

        }
    }

    public void clear() {
        first = null;
    }


    public boolean remove(Object o) {
            for (Node x = first; x != null; x = x.getNext()) {
                if (o.equals(x.getNode())) {
                    unlink(x);
                    return true;
                }
            }
        return false;
        }

//    }

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

    public int findIndex(Object o) {

        if (first == null) {
            return -1;
        }
        MyLinkedListIterator itr = new MyLinkedListIterator(first);
        int index=0;
        while (itr.hasNext()){
            if (itr.next().equals(o)) {
                return index;
            }
            index++;
        }
        return -1;
    }

    public boolean contains(Object o) {
        if (first == null) {
            return false;
        }
        MyLinkedListIterator itr = new MyLinkedListIterator(first);

        while (itr.hasNext()){
            if (itr.next().equals(o)) {
                return true;
            }
        }
        return false;
    }


    public boolean containsAll(Collection c) {
        for (Object o : c) {
            if (!contains(o)) {
                return false;
            }
        }
        return true;
    }

    public boolean addAll(Collection c){
        for (Object o : c) {
            add(o);
        }
        return true;
    }

    public boolean retainAll(Collection c){

        boolean flag = false;

        MyLinkedListIterator itr = new MyLinkedListIterator(first);
        MyLinkedList newList = new MyLinkedList();
        Object tempNode=first;

        do{
            tempNode=itr.next();
            if (c.contains(tempNode)) {
                newList.add(tempNode);
                flag = true;
            }

        }while (itr.hasNext());
        this.first = newList.first;
        return flag;
    }

    public boolean removeAll(Collection c){
        boolean flag = false;

        for (Object o : c) {
            if (remove(o)) {
                flag = true;
            }
        }
        return flag;
    }

}
