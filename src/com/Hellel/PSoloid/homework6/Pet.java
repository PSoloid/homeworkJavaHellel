package com.Hellel.PSoloid.homework6;

/**
 * Created by Morozov on 08.07.2015.
 */
public class Pet extends Animal  {

    protected String name;
    protected boolean isVactinated;

    public void bark(){
        super.bark();
        System.out.println("my name is " + name);
    }

    public void print(){
        super.print();
        System.out.println("My name is " + name);
        if (isVactinated)
            System.out.println("I am vactinated ");
        else
            System.out.println("I am not vactinated ");

    }

}
