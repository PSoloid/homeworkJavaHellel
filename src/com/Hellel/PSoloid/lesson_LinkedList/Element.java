package com.Hellel.PSoloid.lesson_LinkedList;

import java.util.Objects;

/**
 * Created by ITHILLEL7 on 17.07.2015.
 */
public class Element {
    private Element next;
    private Object data;

    public Element() {


    }

    public Element getNext() {
        return next;
    }

    public void setNext(Element next) {
        this.next = next;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
