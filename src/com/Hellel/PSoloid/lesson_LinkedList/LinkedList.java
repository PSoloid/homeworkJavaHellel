package com.Hellel.PSoloid.lesson_LinkedList;

import java.util.Collection;
import java.util.Iterator;

/**
 * Created by ITHILLEL7 on 17.07.2015.
 */
public class LinkedList implements Collection {
    private Element first;

//TODO optimize
    @Override
    public int size() {

        int size=0;
        Element currentElement = first;

        while (currentElement!=null){
            currentElement=currentElement.getNext();
            size++;
        }
        return size;
    }

    public Element getFirst(){
        return first;
    }



    @Override
    public boolean isEmpty() {

        return first==null;
    }

    @Override
    public boolean contains(Object o) {
        boolean result =false;
        Element currentElement =first;
        while (currentElement!=null){
            if(currentElement.getData().equals(o)){
                return true;
            }
            currentElement = currentElement.getNext();
        }

        return false;
    }

    @Override
    public Iterator iterator() {

        return new LinkedListIterator(iterator().next());
    }






    @Override
    public Object[] toArray() {
        return new Object[0];
    }

    @Override
    public boolean add(Object o) {

        Element toAdd = new Element(null,o);
        Element lastElement = first;

        return false;
    }

    private Element getLastElement() {
        Element lastElement = first;
        if (lastElement == null) {
            return lastElement;
        }

        while (lastElement.getNext() != null) {
            lastElement = lastElement.getNext();

        }
        return lastElement;
    }


    @Override
    public boolean remove(Object o) {
        return false;
    }

    @Override
    public boolean addAll(Collection c) {
        if (c==null || (c.isEmpty())){
            return false;
        }
        for(Object o : c){
            add(o);

        }

        return true;
    }

    @Override
    public void clear() {

    }

    @Override
    public boolean retainAll(Collection c) {
        return false;
    }

    @Override
    public boolean removeAll(Collection c) {
        return false;
    }

    @Override
    public boolean containsAll(Collection c) {
        return false;
    }

    @Override
    public Object[] toArray(Object[] a) {
        return new Object[0];
    }

    @Override
    public String toString(){
        String result = "";

        Element currentElement = first;

        if (currentElement==null){
            return result;
        }

        while (currentElement.getNext() != null) {
            result+=currentElement.getData() + ", ";
            currentElement = currentElement.getNext();

        }
        return result;
    }



    public static void main(String[] args) {

        LinkedList list1 = new LinkedList();

        System.out.println(list1);
        System.out.println(list1.size());
        list1.add(2.5);

        System.out.println(list1);
        System.out.println(list1.size());
        list1.add(Double.valueOf(2.5D));

        double d=3.5;
        list1.add(d);

        System.out.println(Integer.parseInt("123"));

        System.out.println(list1);
        System.out.println(list1.size());
        list1.add(2.5);

        System.out.println(list1);
        System.out.println(list1.size());
        list1.add(2.5);


        Iterator iterator = list1.iterator();
        while ();


//        System.out.println(1==1);
//        System.out.println('a' == 'a');
//
//        Element firstElement = new Element(null,2.5);
//        Element secondElement = new Element(null,2.5);
//        System.out.println(firstElement==secondElement);
//        System.out.println(secondElement==secondElement);


    }


}
