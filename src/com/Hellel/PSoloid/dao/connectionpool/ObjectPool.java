package com.Hellel.PSoloid.dao.connectionpool;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by VSulevskiy on 04.09.2015.
 */
public abstract class ObjectPool<T> {
    private List<T> locked;
    private List<T> unlocked;


    public ObjectPool(){
        locked  = new ArrayList<T>();
        unlocked  = new ArrayList<T>();
    }


    protected abstract T create();

    public abstract boolean validate(T o);

    public abstract void expire(T o);

    public synchronized T checkOut(){
        T object;
        if(unlocked.size()>0){
            object = unlocked.remove(0);
        }else{
            object = create();
        }
        locked.add(object);
        System.out.println("Object: "+object+" checkouted");
        return object;
    }



    public synchronized void checkIn(T object) {
        locked.remove(object);
        unlocked.add(object);
        System.out.println("Object: " + object + " checkedin");
    }


}
