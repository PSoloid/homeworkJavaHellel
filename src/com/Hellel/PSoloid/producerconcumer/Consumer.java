package com.Hellel.PSoloid.producerconcumer;

public class Consumer implements Runnable {
    private SyncStack syncStack;
    private int number;

    public Consumer(SyncStack syncStack, int number) {
        this.syncStack = syncStack;
        this.number = number;
    }

    @Override
    public void run() {
        char c;
        for (int i = 0; i < Producer.NUM_OF_ITERATIONS; i++) {
            c = syncStack.pop();
            System.out.println("Consumer " + number + " " + c);
            try {
                Thread.sleep((int)(Math.random()*800));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
