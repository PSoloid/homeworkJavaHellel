package com.Hellel.PSoloid.homework6;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by NewClass8 on 04.08.2015.
 */
public class Zoo {
    List animals;
    public Zoo(){
        animals = new  ArrayList();
    }

    public void add(Animal animal){
        animals.add(animal);
    }

    public Animal get(int index){
        return (Animal)animals.get(index);
    }

    public Animal remove (int index){
       return (Animal)animals.remove(index);
    }

}
