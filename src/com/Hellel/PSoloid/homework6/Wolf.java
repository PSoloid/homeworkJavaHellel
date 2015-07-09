package com.Hellel.PSoloid.homework6;

/**
 * Created by Morozov on 08.07.2015.
 */
public class Wolf extends SavageAnimal {

    public Wolf(int id, int age, float weight, String color, boolean isPredator) {
        this.id = id;
        this.age = age;
        this.weight = weight;
        this.color = color;
        this.isPredator = isPredator;
    }

    public void bark(){
        super.bark();

    }
}
