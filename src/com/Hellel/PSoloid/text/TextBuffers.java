package com.Hellel.PSoloid.text;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;


public class TextBuffers {

    public static void main(String[] args) {
        try {
            stringTestDel(stringTestAdd(bufferedReader()), 'a');
            stringBufferTestDel(stringBufferTestAdd(bufferedReader()), 'a');
            stringBuilderTestDel(stringBuilderTestAdd(bufferedReader()), 'a');
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static String[] bufferedReader() throws FileNotFoundException, IOException {

        BufferedReader reader = new BufferedReader(new FileReader("resourses/wap1.txt"));

        StringBuilder sb = new StringBuilder();
        String line = null;
        while ((line = reader.readLine()) != null) {
            sb.append(line).append("\n");
        }
        reader.close();
        String[] words = sb.toString().split("\\s+");
        System.out.println("Total words:" + words.length);

        return words;
    }


    public static String stringTestAdd(String[] words) {
        long ts = System.nanoTime();

        String buff = "";

        for (String word : words) {
            buff += word + " ";
        }

        long te = System.nanoTime();

        System.out.println("Complete stringTestAdd, lenght:" + buff.length() + " elapsed time:" + (te - ts) / 1e6 + "ms");

        return buff;
    }


    public static void stringTestDel(String buff, char ch) {
        long ts = System.nanoTime();

        int k = 0;
        int len = buff.length();

        for (int i = 0; i < len; i++) {
            if (buff.charAt(i) != ch) {
                buff += buff.charAt(i);

            } else {
                k++;
            }
        }
        long te = System.nanoTime();

        System.out.println("Complete stringTestDel, deleted signs " + ch + " quantity: " + k + " elapsed time:" + (te - ts) / 1e6 + "ms");
    }


    public static StringBuffer stringBufferTestAdd(String[] words) {
        long ts = System.nanoTime();

        StringBuffer buff = new StringBuffer();

        for (String word : words) {
            buff.append(word).append(" ");
        }

        long te = System.nanoTime();

        System.out.println("Complete stringBufferTest, lenght:" + buff.length() + " elapsed time:" + (te - ts) / 1e6 + "ms");

        return buff;
    }


    public static void stringBufferTestDel(StringBuffer buff, char ch) {
        long ts = System.nanoTime();

        int k = 0;


        for (int i = 0; i < buff.length(); i++) {
            if(i==9000){
                System.out.println();
            }
            if (buff.charAt(i) != ch) {
                buff.deleteCharAt(i);

            } else {
                k++;
            }
        }

        long te = System.nanoTime();

        System.out.println("Complete stringBufferTestDel, deleted signs " + ch + " quantity: " + k + " elapsed time:" + (te - ts) / 1e6 + "ms");
    }


    public static StringBuilder stringBuilderTestAdd(String[] words) {
        long ts = System.nanoTime();

        StringBuilder buff = new StringBuilder();

        for (String word : words) {

            buff.append(word).append(" ");
        }

        long te = System.nanoTime();

        System.out.println("Complete stringBuilderTest, lenght:" + buff.length() + " elapsed time:" + (te - ts) / 1e6 + "ms");

        return buff;
    }

    public static void stringBuilderTestDel(StringBuilder buff, char ch) {
        long ts = System.nanoTime();

        int k = 0;


        for (int i = 0; i < buff.length(); i++) {
            if (buff.charAt(i) != ch) {
                buff.deleteCharAt(i);

            } else {
                k++;
            }
        }

        long te = System.nanoTime();

        System.out.println("Complete stringBuilderTestDel, deleted signs " + ch + " quantity: " + k + " elapsed time:" + (te - ts) / 1e6 + "ms");
    }
}

