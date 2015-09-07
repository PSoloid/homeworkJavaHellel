package com.Hellel.PSoloid.producerconcumer;

import java.util.Vector;

public class SyncStack {
    private Vector buffer = new Vector(400, 200);

    public synchronized void push(char c) {
        while (buffer.size() >= 10) {
            try {
                this.wait();
                System.out.println("Produser is waiting " + buffer.size());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }

        buffer.addElement(c);
        this.notify();
    }

    public synchronized char pop() {
        while (buffer.size() == 0) {
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Consumer is waiting " + buffer.size());
        }
        this.notify();
        return (char) (buffer.remove(buffer.size() - 1));
    }
}
