package com.Hellel.PSoloid.md5;


import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class HashTest {
    public static void main(String[] args) {
       SyncStackText syncStack = new SyncStackText();

        Producer producer1 = new Producer(syncStack,4);
        Thread prodOneThread = new Thread(producer1);
        prodOneThread.start();

        Consumer consumer1 = new Consumer(syncStack,"f016441d00c16c9b912d05e9d81d894d");
        Thread consOneThread = new Thread(consumer1);
        consOneThread.start();

    }

}
