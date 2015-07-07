package com.Hellel.PSoloid.homework5.intArray;


/**
 * Created by Morozov on 04.07.2015.
 */
public class MyIntArrayApp {

    public static void main(String[] args) {

        MyIntArray intArray = new MyIntArray();

        MyIntElement value1 = new MyIntElement(90);
        MyIntElement value2 = new MyIntElement(43);
        MyIntElement value3 = new MyIntElement(105);

        intArray.addInt(value1);
        intArray.addInt(value2);
        intArray.addInt(value3);
        intArray.addInt(58);
        intArray.addInt(1);

        intArray.print();

        System.out.println("\nShow get");
        MyIntElement value4 = intArray.get(4);
        intArray.addInt(value3);
        intArray.print();

        System.out.println("\nSize: " + intArray.getSize());

        System.out.println("\nDelete elements ");
        intArray.delInt(value3);
        intArray.delInt(54);
        intArray.print();

        System.out.println("\nSort ");
        intArray.sort();
        intArray.print();
    }
}
