package com.Hellel.PSoloid.homework6;

import com.Hellel.PSoloid.homework6.observable.Observer;
import com.Hellel.PSoloid.homework6.observers.GroomerObserver;
import com.Hellel.PSoloid.homework6.observers.HeadmasterObserver;
import com.Hellel.PSoloid.homework6.observers.HungryObserver;
import com.Hellel.PSoloid.homework6.observers.SicknessObserver;

import java.util.ArrayList;
import java.util.List;


public class ZooApp {

    public static Zoo init() {

        Giraffe giraffe;

        Zoo zoo = new Zoo();

        Cat cat = new Cat(1, 3, 3.4, "Grey", true, false, "Murka", true, true);
        zoo.add(cat);
        Leon lion = new Leon(2, 10, 90, "Yellow", true, false, true);
        zoo.add(lion);
        Dog dog = new Dog(3, 3, 3.4, "Black", true, false, "Tuzik", true, true);
        zoo.add(dog);
        Fish fish = new Fish(4, 3, 0.2, "Gold", true, false, false);
        zoo.add(fish);
        Hamster hamster = new Hamster(5, 3, 0.2, "white", true, true, "Homiak", true, false);
        zoo.add(fish);
        GuideDog cleverDog = new GuideDog(6, 10, 10, "White", false, true, "Sharik", true, true, true);
        zoo.add(cleverDog);
        GuideDog notCleverDog = new GuideDog(7, 1, 3, "Grey", true, false, "Muhtar", true, false, false);
        zoo.add(notCleverDog);
        giraffe = new Giraffe(8, 33, 36, "Spot", false, true, false);
        zoo.add(giraffe);
        return zoo;

    }


    public static void main(String[] args) {

        Zoo zoo = init();
        System.out.println(zoo.remove(1000));
        addGirafe(zoo);
        System.out.println(zoo.get(6));
    }


public static void addGirafe(Zoo zoo){
    zoo.add("giraffe");
}


//        List<Animal> zoo = init();
//
//        Observer doctor = new SicknessObserver();
//        Observer feederWild = new HungryObserver();
//        Observer feederPet = new HungryObserver();
//        Observer groomer = new GroomerObserver();
//        Observer headmaster = new HeadmasterObserver();
//
//        for ( Animal o : zoo) {
//            o.addObserver(doctor);
//            o.addObserver(feederWild);
//            o.addObserver(groomer);
//            o.addObserver(headmaster);
//            o.addObserver(feederPet);
//        }
//
//        for ( Animal o : zoo) {
//            o.notifyObservers();
//            System.out.println();
//        }
//    }
//}










