package com.Hellel.PSoloid.homework6;

import com.Hellel.PSoloid.homework6.observable.Observable;
import com.Hellel.PSoloid.homework6.observable.Observer;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by Morozov on 08.07.2015.
 */
public class Hamster extends Pet {


    public Hamster(int id, int age, double weight, String color, boolean isHungry, boolean isSick, String name, boolean isVactinated, boolean isHaircut) {
        super(id, age, weight, color, isHungry, isSick, name, isVactinated, isHaircut);
    }

    public void bark(){
        super.bark();
        System.out.println("my name is " + name);
    }


}
