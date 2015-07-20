package com.Hellel.PSoloid.homework6;

import com.Hellel.PSoloid.homework5.Fish;

/**
 * Created by Morozov on 08.07.2015.
 */
public class ZooApp {

    public static void main(String[] args) {
//        Animal animal = new Animal();
        Cat cat = new Cat(1,2,3.5f,"black","Barsik",true);

        Crocodile crocodile = new Crocodile(2,1,20,"green",true);

        Dog dog = new Dog(3,5,15,"grey","Barbos",true);

        Fish fish = new Fish(4,1,0.2f,"gold");

        Giraffe giraffe = new Giraffe(5,8,120,"yellow",false);

        GuideDog guideDog = new GuideDog(6,3,20f,"black","Helper",true,true);

        Hamster hamster = new Hamster(7,1,0.2f,"red","Hamster",false);

        Leon leon = new Leon(8,6,130,"yellow",true);
//        Pet pet = new Pet();
//        SavageAnimal savageAnimal = new SavageAnimal();
        Wolf wolf = new Wolf(9,4,50,"grey",true);


//        animal.bark();
//        pet.bark();
//        savageAnimal.bark();
        cat.bark();
        cat.print();
        System.out.println();

        crocodile.bark();
        crocodile.print();
        System.out.println();

        dog.bark();
        dog.print();
        System.out.println();

        fish.bark();
        fish.print();
        System.out.println();

        giraffe.bark();
        giraffe.print();
        System.out.println();

        guideDog.bark();
        guideDog.print();
        System.out.println();

        hamster.bark();
        hamster.print();
        System.out.println();

        leon.bark();
        leon.print();
        System.out.println();

        wolf.bark();
        wolf.print();
        System.out.println();
    }


}
