package com.Hellel.PSoloid.md5;

import java.io.*;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * Created by Morozov on 31.08.2015.
 */
public class Password {

    final static String ALPHABET = "abcdefghijklmnopqrstuvwxyz";


    public static void main(String[] args) {

        Runnable task1 = () -> {
            System.out.println("\nThread 1 : " + searchPassword(7, "13d70e09909669272b19647c2a55dacb"));
            System.out.println("Thread 1 finished");
        };
        Thread thread1 = new Thread(task1);
        thread1.start();

        Runnable task2 = () -> {
            System.out.println("\nThread 2 : " + searchPassword(8, "13d70e09909669272b19647c2a55dacb"));
            System.out.println("Thread 2 finished");
        };
        Thread thread2 = new Thread(task2);
        thread2.start();

        Runnable task3 = () -> {
            System.out.println("\nThread 3 : " + searchPassword(9, "13d70e09909669272b19647c2a55dacb"));
            System.out.println("Thread 3 finished");
        };
        Thread thread3 = new Thread(task3);
        thread3.start();


        System.out.println("\nAll permutation Hash 1 : " + searchPassword("f016441d00c16c9b912d05e9d81d894d"));

        System.out.println("\nHash 1: " + searchPassword(4, "f016441d00c16c9b912d05e9d81d894d"));

        System.out.println("\nHash 2 from file: " + slovar("5ebe2294ecd0e0f08eab7690d2a6ee69"));




        System.out.println("\nHash 3: " + searchPassword(10, "13d70e09909669272b19647c2a55dacb"));
        System.out.println("\nAll permutation Hash 3 : " + searchPassword("13d70e09909669272b19647c2a55dacb"));

    }


    static String slovar(String hash) {

        String line;
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new FileReader("resourses/allwords"));

            while ((line = reader.readLine()) != null) {
                if (hash.equals(getHash(line.trim()))) {
                    return line;
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } finally {
            try {
                if (reader != null) {
                    reader.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return "Password not find";
    }


    public static String searchPassword(int lenght, String hash) {

        int len = lenght;

        String threadName = Thread.currentThread().getName();
        System.out.println("Thread "+ threadName + " lenght " + len);

        while (len <= lenght) {
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
                try {
                    if (hash.equals(getHash(resultBuf.toString()))) {
                        return resultBuf.toString();
                    }
                } catch (NoSuchAlgorithmException e) {
                    e.printStackTrace();
                }
            }
            }
            return "Password not found";
        }


    public static String searchPassword(String hash) {
        int len = 1;

        while (len <= 15) {
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
                try {
                    if (hash.equals(getHash(resultBuf.toString()))) {
                        return resultBuf.toString();
                    }
                } catch (NoSuchAlgorithmException e) {
                    e.printStackTrace();
                }
            }
            len ++;
        }
        return "Password not found";
    }

    public static long permutationCount(int len) {
        int result = 0;
        for (int i = 1; i <= len; i++) {
            result += Math.pow(len, i);
        }
        return result;
    }


    public static String getHash(String text) throws NoSuchAlgorithmException {

        MessageDigest md = MessageDigest.getInstance("MD5");
        md.update(text.getBytes());

        byte byteData[] = md.digest();

        StringBuffer sb = new StringBuffer();
        for (byte aByteData : byteData) {
            sb.append(Integer.toString((aByteData & 0xff) + 0x100, 16).substring(1));
        }
        return sb.toString();
    }
}
