package com.Hellel.PSoloid.homework6;

import com.Hellel.PSoloid.homework6.observable.Observable;
import com.Hellel.PSoloid.homework6.observable.Observer;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by Morozov on 08.07.2015.
 */
public class Pet extends Animal {

    protected String name;
    protected boolean isVactinated;
    protected boolean isHaircut;


    public Pet(int id, int age, double weight, String color, boolean isHungry, boolean isSick, String name, boolean isVactinated, boolean isHaircut) {
        super(id, age, weight, color, isHungry, isSick);
        this.name = name;
        this.isVactinated = isVactinated;
        this.isHaircut = isHaircut;
    }

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

    @Override
    public void notifyObservers() {
        super.notifyObservers();
        Date currentDate = new Date();
        String state;

        if (isHungry){
            state ="is hungry";
            observers.get(4).handle(id, currentDate, state);
        }

        if (isHaircut){
            state ="need haircut";
            observers.get(2).handle(id, currentDate, state);
            observers.get(3).handle(id, currentDate, state);
        }
    }

}
