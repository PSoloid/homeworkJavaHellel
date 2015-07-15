package com.Hellel.PSoloid.homework7.MyLinkedList;

import java.util.Iterator;

/**
 * Created by otk_prog on 15.07.2015.
 */

    public class MyLinkedListIterator implements Iterator<Object> {
        private Node current;

        public MyLinkedListIterator(Node element) {
            this.current= element;
        }

        @Override
        public boolean hasNext() {
            return current!=null;
        }

        @Override
        public Object next() {
            Object toReturn = current.getNode();
            current = current.getNext();
            return toReturn;
        }

        public Object prev() {
            Object toReturn = current.getNode();
            current = current.getPrev();
            return toReturn;
        }
    }

