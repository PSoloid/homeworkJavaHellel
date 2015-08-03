package com.Hellel.PSoloid.homework6.observable;

/**
 * Created by otk_prog on 03.08.2015.
 */
public interface Observable {
    void addObserver(Observer observer);
    void notifyObservers();
}
