package com.Hellel.PSoloid.homework6;

/**
 * Created by Morozov on 08.07.2015.
 */
public class Cat extends Pet {

    public Cat() {
    }

    public Cat(int id, int age, float weight, String color, String name, boolean isVactinated) {
        this.id = id;
        this.age = age;
        this.weight = weight;
        this.color = color;
        this.name = name;
        this.isVactinated = isVactinated;
    }

    public void bark(){
        super.bark();
        System.out.println("Meow");
    }


}
