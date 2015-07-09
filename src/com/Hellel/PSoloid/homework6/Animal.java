package com.Hellel.PSoloid.homework6;

/**
 * Created by Morozov on 08.07.2015.
 */
public class Animal {
    protected int id;
    protected int age;
    protected float weight;
    protected String color;

    public void bark(){
        System.out.print("Hello, ");
    }

    public void print(){
        System.out.println("My id is " + id);
        System.out.println("My age is " + age);
        System.out.println("My weight is " + weight);
        System.out.println("My color is " + color);
    }

}
