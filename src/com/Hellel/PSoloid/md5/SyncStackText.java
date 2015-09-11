package com.Hellel.PSoloid.md5;

import java.util.Vector;

public class SyncStackText {
    private Vector buffer = new Vector(400, 200);


    public int getSize() {
        return buffer.size();
    }

    public synchronized void push(String c) {
        while (buffer.size() >= 10) {
            try {
                System.out.println("Produser is waiting " + buffer.size());
                Thread.yield();
                this.wait(1000);

            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }

        this.notify();
        System.out.println("Produser buffer size " + buffer.size());

        buffer.addElement(c);

    }

    public synchronized String pop() {
        while (buffer.size() == 0) {
            try {
                System.out.println("Consumer is waiting " + buffer.size());

                this.wait(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        this.notify();
        System.out.println("Consumer buffer size: " + buffer.size());

        return (String) (buffer.remove(buffer.size() - 1));
    }
}
