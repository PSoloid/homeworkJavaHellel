package com.Hellel.PSoloid.homework6.observable;

import java.util.Date;

/**
 * Created by otk_prog on 03.08.2015.
 */
public interface Observer {
    void handle(int id, Date date, String state);
}
