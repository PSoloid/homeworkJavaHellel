package com.Hellel.PSoloid.homework6;

import com.Hellel.PSoloid.homework6.observable.Observable;
import com.Hellel.PSoloid.homework6.observable.Observer;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by Morozov on 08.07.2015.
 */
public class SavageAnimal extends Animal{

   protected boolean isPredator;

    public SavageAnimal(int id, int age, double weight, String color, boolean isHungry, boolean isSick, boolean isPredator) {
        super(id, age, weight, color, isHungry, isSick);
        this.isPredator = isPredator;
    }

    @Override
    public void notifyObservers() {
        super.notifyObservers();
        Date currentDate = new Date();
        String state;

        if (isHungry){
            state ="is hungry";
            observers.get(1).handle(id, currentDate, state);
        }
    }


    public void bark(){
      super.bark();
      System.out.println("I am wild animal ");
      if (isPredator)
         System.out.println("and I am angry ");
   }

   public void print(){
      super.print();
      if (isPredator)
         System.out.println("I am a predator ");
      else
         System.out.println("I am not a predator ");
   }
}





