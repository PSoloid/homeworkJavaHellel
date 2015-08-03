package com.Hellel.PSoloid.homework6;

/**
 * Created by Morozov on 08.07.2015.
 */
public class Dog extends Pet {


    public Dog(int id, int age, double weight, String color, boolean isHungry, boolean isSick, String name, boolean isVactinated, boolean isHaircut) {
        super(id, age, weight, color, isHungry, isSick, name, isVactinated, isHaircut);
    }

    public void bark(){
        super.bark();
        System.out.println("Woof");
    }
}
