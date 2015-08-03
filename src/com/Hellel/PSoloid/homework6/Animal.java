package com.Hellel.PSoloid.homework6;

import com.Hellel.PSoloid.homework6.observable.Observable;
import com.Hellel.PSoloid.homework6.observable.Observer;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by Morozov on 08.07.2015.
 */
public class Animal  implements Observable {
    protected int id;
    protected int age;
    protected double weight;
    protected String color;
    protected boolean isHungry;
    protected boolean isSick;

    List<Observer> observers = new ArrayList<Observer>();


    public void bark(){
        System.out.print("Hello, ");
    }

    public void print(){
        System.out.println("My id is " + id);
        System.out.println("My age is " + age);
        System.out.println("My weight is " + weight);
        System.out.println("My color is " + color);
    }

    public Animal(int id, int age, double weight, String color, boolean isHungry, boolean isSick) {
        this.id = id;
        this.age = age;
        this.weight = weight;
        this.color = color;
        this.isHungry = isHungry;
        this.isSick = isSick;
    }

    public Animal() {
    }

    @Override
    public void addObserver(Observer observer) {
        observers.add(observer);

    }

    @Override
    public void notifyObservers() {
        String state;
        Date currentDate = new Date();
        if (isSick) {
            state = "is sick";
            observers.get(0).handle(id, currentDate, state);
            observers.get(3).handle(id, currentDate, state);
        }

        if (isHungry) {
            state = "is hungry";
            observers.get(0).handle(id, currentDate, state);
            observers.get(3).handle(id, currentDate, state);
        }
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

    public double getWeight() {
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
