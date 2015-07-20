package com.Hellel.PSoloid.homework6;

/**
 * Created by Morozov on 20.07.2015.
 */
public class Fish extends Animal {
    public Fish(int id, int age, float weight, String color) {
        this.id = id;
        this.age = age;
        this.weight = weight;
        this.color = color;
    }
    public void bark(){
        super.bark();
        System.out.println("I am a fish");
    }
}
