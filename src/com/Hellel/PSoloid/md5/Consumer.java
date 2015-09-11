package com.Hellel.PSoloid.md5;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Consumer implements Runnable {

    private SyncStackText syncStackText;
    String hash;

    public Consumer(SyncStackText syncStackText, String hash) {
        this.syncStackText = syncStackText;
        this.hash = hash;
    }

    @Override
    public void run() {

        String threadName = Thread.currentThread().getName();
        System.out.println("Thread " + threadName + " Hash: " + hash);


        while (Producer.isProducer()) {

            String text = syncStackText.pop();

            MessageDigest md = null;
            try {
                md = MessageDigest.getInstance("MD5");
            } catch (NoSuchAlgorithmException e) {
                e.printStackTrace();
            }

            md.update(text.getBytes());

            byte byteData[] = md.digest();

            StringBuffer sb = new StringBuffer();

            for (byte aByteData : byteData) {
                sb.append(Integer.toString((aByteData & 0xff) + 0x100, 16).substring(1));
            }
            syncStackText.push(sb.toString());


            if (hash.equals(sb.toString())) {
                System.out.println("Password: " + text);

                Thread.currentThread().interrupt();
//                prodOneThread.interrupt();
            }

            System.out.println("Consumer " + text);

            try {
                Thread.sleep((int) (Math.random() * 400));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

//        System.out.println("Password not found");
//        Thread.currentThread().interrupt();
//        prodOneThread.interrupt();


    }
}






