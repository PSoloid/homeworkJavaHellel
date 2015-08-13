package com.Hellel.PSoloid.homework7.MyLinkedList;

import java.util.*;


/**
 * Created by otk_prog on 13.07.2015.
 */
public class MyLinkedList<T> implements Iterable<Object> {
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

    public int getSize() {
        return size;
    }

    public void add(T o) {

        Node newNode = null;
        try {
            newNode = new Node(o);


            if (first == null) {
                first = last = newNode;
            } else {
                last.setNext(newNode);
                newNode.setPrev(last);
                last = newNode;
            }
            size++;
        } catch (Exception e) {
            System.err.println("(1): " + e.getMessage());
            e.printStackTrace();
        }
    }


    public void print() {
        MyLinkedListIterator itr = new MyLinkedListIterator(first);

//        if (isEmpty()) {
//            throw new NoSuchElementException("List is empty");
////            System.out.println("List is empty");
////            return;
//        }

        int count = 0;

        try {
            while (itr.hasNext()) {
                System.out.println("Element " + count + " : " + itr.next().toString());
                count++;
            }
        } catch (NoSuchElementException e) {
            System.err.println("(2): " + e.getMessage());
            e.printStackTrace();
        }
        System.out.println("Size = " +getSize());
    }

    public void reversePrint() throws NoSuchElementException{
        MyLinkedListIterator itr = new MyLinkedListIterator(last);

        if (isEmpty()) {
            throw new NoSuchElementException("List is empty");
//            System.out.println("List is empty");
//            return;
        }

        int count = 0;

        while (itr.hasNext()) {
            System.out.println("Element " + count + " : " + itr.prev().toString());
            count++;
        }
        System.out.println("Size = " +getSize());
    }

    public void clear() {
        first = null;
    }


    public boolean remove(T o) {
        try {
            for (Node x = first; x != null; x = x.getNext()) {
                if (o.equals(x.getNode())) {
                    unlink(x);
                    return true;
                }
            }
        } catch (ClassCastException e) {
            System.err.println("(3): " + e.getMessage());
            e.printStackTrace();
        }
        return false;
        }

//    }

    public void unlink(Node o) {

        try {
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
        } catch (ClassCastException e) {
            System.err.println("(4): " + e.getMessage());
            e.printStackTrace();
        }
    }

    public boolean contains(T o) {
        if (first == null) {
            return false;
        }
        MyLinkedListIterator itr = new MyLinkedListIterator(first);

        try {
            while (itr.hasNext()){
                if (itr.next().equals(o)) {
                    return true;
                }
            }
        } catch (ClassCastException e) {
            System.err.println("(5): " + e.getMessage());
            e.printStackTrace();
        } catch (NullPointerException e) {
            System.err.println("(6): " + e.getMessage());
            e.printStackTrace();
        }
        return false;
    }


    public boolean containsAll(Collection c) {
        try {
            for (Object o : c) {
                if (!contains((T)o)) {
                    return false;
                }
            }
        } catch (ClassCastException e) {
            System.err.println("(7): " + e.getMessage());
            e.printStackTrace();
        } catch (NullPointerException e) {
            System.err.println("(8): " + e.getMessage());
            e.printStackTrace();
        }
        return true;
    }

    public boolean addAll(Collection c) {
        try {
            for (Object o : c) {
                add((T) o);
            }
        } catch (ClassCastException e) {
            System.err.println(e.getMessage());
            e.printStackTrace();
        } catch (NullPointerException e) {
            System.err.println(e.getMessage());
            e.printStackTrace();
        }
        return true;
    }

    public boolean retainAll(Collection c) {

        boolean flag = false;

        MyLinkedListIterator itr = new MyLinkedListIterator(first);
        MyLinkedList newList = new MyLinkedList();
        Object tempNode = first;

        try {
            do {
                tempNode = itr.next();
                if (c.contains(tempNode)) {
                    newList.add(tempNode);
                    flag = true;
                }

            } while (itr.hasNext());
        } catch (ClassCastException e) {
            System.err.println(e.getMessage());
            e.printStackTrace();
        } catch (NullPointerException e) {
            System.err.println(e.getMessage());
            e.printStackTrace();
        }
        this.first = newList.first;
        this.size = newList.size;


        return flag;
    }

    public boolean removeAll(Collection c){
        boolean flag = false;

        try {
        for (Object o : c) {
            if (remove((T)o)) {
                flag = true;
            }
        }
    } catch (ClassCastException e) {
        System.err.println(e.getMessage());
        e.printStackTrace();
    } catch (NullPointerException e) {
        System.err.println(e.getMessage());
        e.printStackTrace();
    }
        return flag;
    }

}
