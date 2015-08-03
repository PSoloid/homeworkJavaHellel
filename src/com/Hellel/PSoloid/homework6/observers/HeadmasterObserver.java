package com.Hellel.PSoloid.homework6.observers;

import com.Hellel.PSoloid.homework6.observable.Observer;

import java.util.Date;

/**
 * Created by otk_prog on 03.08.2015.
 */
public class HeadmasterObserver implements Observer {
    @Override
    public void handle(int id, Date date, String state) {
        System.out.println("Headmaster: animal " + id +" " + state + " at " + date);
    }
}
