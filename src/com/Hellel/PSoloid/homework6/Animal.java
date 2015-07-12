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

    public Animal() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public float getWeight() {
        return weight;
    }

    public void setWeight(float weight) {
        this.weight = weight;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}
