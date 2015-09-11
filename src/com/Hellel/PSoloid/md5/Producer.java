package com.Hellel.PSoloid.md5;

public class Producer implements Runnable {

    final static String ALPHABET = "abcdefghijklmnopqrstuvwxyz";

    private SyncStackText syncStackText;
    private int lenght;
    private static boolean producer;


    public static boolean isProducer() {
        return producer;
    }

    public Producer(SyncStackText syncStackText, int lenght) {
        this.syncStackText = syncStackText;
        this.lenght = lenght;
    }

    @Override
    public void run() {
        producer=true;
        int len = lenght;

        String threadName = Thread.currentThread().getName();
        System.out.println("Thread " + threadName + " lenght " + len);


        while (len <= lenght) {
//            Thread.yield();
            int pow[] = new int[len + 1];
            pow[0] = 1;
            for (int i = 1; i <= len; i++) {
                pow[i] = pow[i - 1] * ALPHABET.length();
            }
            StringBuffer resultBuf = new StringBuffer();

            for (int i = 0; i < pow[len]; i++) {
                char arr[] = new char[len];

                for (int j = 0; j < len; j++) {
                    arr[j] = ALPHABET.charAt((i / pow[j]) % ALPHABET.length());
                }

                resultBuf.setLength(0);
                for (char ch : arr) {
                    resultBuf.append(ch);
                }
                syncStackText.push(resultBuf.toString());

                System.out.println("Producer " + resultBuf.toString());

//            System.out.println("Producer " + number + " " + sb.toString() );

                try {
                    Thread.sleep((int) (Math.random() * 400));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
        Thread.currentThread().interrupt();
        producer=false;
    }
}