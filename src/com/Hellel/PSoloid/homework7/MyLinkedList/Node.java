package com.Hellel.PSoloid.homework7.MyLinkedList;

/**
 * Created by otk_prog on 13.07.2015.
 */
public class Node {

    private Object node;
    private Node next;
    private Node prev;


    public Node(Object node) {
        this.node = node;
    }

    public Object getNode() {
        return node;
    }

    public void setNode(Object node) {
        this.node = node;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }

    public Node getPrev() {
        return prev;
    }

    public void setPrev(Node prev) {
        this.prev = prev;
    }




}
