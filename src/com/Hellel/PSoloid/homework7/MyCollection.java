package com.Hellel.PSoloid.homework7;


import java.util.Collection;

/**
 * Created by Morozov on 12.07.2015.
 */

    public class MyCollection {
//        private int capacity = 1000;
        private Object[] elements = new Object[10];
        private int size = 0;


    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    public boolean contains(Object o) {
        boolean flag = false;
        for (int i = 0; i < size(); i++) {
            if (o.equals(elements[i])) {
                flag = true;
            }
        }
        return flag;
    }

    public boolean add(Object o) {
        boolean flag = false;
        if (size() < elements.length) {
            elements[size] = o;
            size++;
            flag = true;
        } else {
            resize();
            elements[size] = o;
            size++;
            flag = true;



        }
        return flag;
    }

    public void resize() {
        Object[] newElements = new Object[elements.length*2];
        for(int i=0; i<elements.length; i++) {
            newElements[i] = elements[i];
        }
        elements=newElements;
    }

    public boolean remove(Object o) {
        boolean flag = false;
        for (int i = 0; i < size; i++) {
            if (o.equals(elements[i])) {
                for(int j = i;j<size-1;j++) {
                    elements[j] = elements[j + 1];
                }
                size--;
                flag = true;
            }
        }
        return flag;
    }


    public boolean addAll(Collection c) {
        boolean flag = false;
        for (Object object : c)
            if (add(object)) {
                flag = true;
            }
        return flag;
    }

    public void clear() {
        for (int i = 0; i < size; i++) {
            elements[i] = null;
        }
        size = 0;
    }

    public boolean retainAll(MyCollection c) {
        boolean flag = false;
        for (Object object : c.elements)
            for (int i = 0; i < size(); i++) {
                if (!object.equals(this.elements[i])) {
                    remove(this.elements[i]);
                    flag = true;
                }
            }
        return flag;
    }


    public boolean removeAll(MyCollection c) {
        boolean flag = false;
        for (Object object : c.elements)
            if (contains(object)) {
                remove(object);
                return true;
            }
        return flag;
    }


    public boolean containsAll(MyCollection c) {
        for (Object object : c.elements)
            if (!contains(object)) {
                return false;
            }
        return true;
    }

    public void print(){
        System.out.println("MyCollection: ");
        for(int i=0;i<size;i++){
            System.out.println(elements[i] + ", ");
        }
        System.out.println();
    }


}


