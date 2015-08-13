package com.Hellel.PSoloid.homework7.MyCollection;


import java.util.Collection;
import java.util.NoSuchElementException;

/**
 * Created by Morozov on 12.07.2015.
 */

    public class MyCollection {
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
        try {
            for (int i = 0; i < size(); i++) {
                if (o.equals(elements[i])) {
                    flag = true;
                }
            }
        } catch (NullPointerException e) {
            System.err.println(e.getMessage());
            e.printStackTrace();
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
        try {
            Object[] newElements = new Object[elements.length * 2];

            for (int i = 0; i < elements.length; i++) {
                newElements[i] = elements[i];
            }
            elements = newElements;

        } catch (ArrayIndexOutOfBoundsException e) {
            System.err.println(e.getMessage());
            e.printStackTrace();
        } catch (NullPointerException e) {
            System.err.println(e.getMessage());
            e.printStackTrace();
        }

    }

    public boolean remove(Object o) {
        boolean flag = false;
        try {
            for (int i = 0; i < size; i++) {
                if (o.equals(elements[i])) {
                    for (int j = i; j < size - 1; j++) {
                        elements[j] = elements[j + 1];
                    }
                    size--;
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


    public boolean addAll(Collection c) {
        boolean flag = false;
        try {
            for (Object object : c)
                if (add(object)) {
                    flag = true;
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

    public void clear() {
        try {
            for (int i = 0; i < size; i++) {
                elements[i] = null;
            }
            size = 0;
        } catch (NullPointerException e) {
            System.err.println(e.getMessage());
            e.printStackTrace();
        }
    }

    public boolean retainAll(MyCollection c) {
        boolean flag = false;
        try {
            for (int i = 0; i < size(); i++) {
                boolean rem = true;
                for (int j = 0; j < c.size(); j++) {
                    if (elements[i].equals(c.elements[j])) {
                        flag = true;
                        rem = false;
                    }
                }
                if (rem) {
                    remove(elements[i]);
                    i--;
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


    public boolean removeAll(MyCollection c) {
        boolean flag = false;
        for (int i = 0; i < c.size(); i++){
            if (contains(c.elements[i])) {
                remove(c.elements[i]);
                flag = true;
            }
        }

        return flag;
    }


    public boolean containsAll(MyCollection c) {
        try {
            for (int i = 0; i < c.size(); i++) {
                if (!contains(c.elements[i])) {
                    return false;
                }
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

    public void print(){
        if (size==0){
            throw new NoSuchElementException("List is empty");
        }

        System.out.println("MyCollection: ");

        for(int i=0;i<size;i++){
            System.out.println(elements[i] + ", ");
        }
        System.out.println();
    }


}


