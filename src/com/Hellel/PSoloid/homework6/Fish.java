package com.Hellel.PSoloid.homework6;


public class Fish extends SavageAnimal {


    public Fish(int id, int age, double weight, String color, boolean isHungry, boolean isSick, boolean isPredator) {
        super(id, age, weight, color, isHungry, isSick, isPredator);
    }


    public void bark(){
        super.bark();
        System.out.println("I am a fish");
    }
}
