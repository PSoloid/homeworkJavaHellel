package com.Hellel.PSoloid.homework6;

/**
 * Created by Morozov on 08.07.2015.
 */
public class GuideDog extends Dog {

    private boolean isTrained;


    public GuideDog(int id, int age, float weight, String color, String name, boolean isVactinated, boolean isTrained) {
        super(id, age, weight, color, name, isVactinated);

        this.isTrained = isTrained;
    }

    public void bark(){
        super.bark();
        if (isTrained)
        System.out.println("I can take you home.");
    }

    public void print(){
        super.print();
        if (isTrained)
            System.out.println("I am trained ");
        else
            System.out.println("I am not trained ");

    }
}
