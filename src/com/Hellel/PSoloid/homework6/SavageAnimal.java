package com.Hellel.PSoloid.homework6;

/**
 * Created by Morozov on 08.07.2015.
 */
public class SavageAnimal extends Animal {

   protected boolean isPredator;

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
