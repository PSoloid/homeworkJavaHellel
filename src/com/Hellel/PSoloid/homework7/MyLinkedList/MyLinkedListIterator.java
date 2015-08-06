package com.Hellel.PSoloid.homework7.MyLinkedList;

import java.util.Iterator;

/**
 * Created by otk_prog on 15.07.2015.
 */

    public class MyLinkedListIterator<T> implements Iterator<Object> {
        private Node current;

        public MyLinkedListIterator(Node element) {
            this.current= element;
        }

        @Override
        public boolean hasNext() {
            return current!=null;
        }

        @Override
        public T next() {
            T toReturn = (T) current.getNode();
            current = current.getNext();
            return toReturn;
        }

        public T prev() {
            T toReturn = (T) current.getNode();
            current = current.getPrev();
            return toReturn;
        }
    }

