package com.Hellel.PSoloid.homework3;

import java.util.Scanner;

/**
 * Created by Morozov on 29.06.2015.
 */
public class Xor {


    public static String code(String inText, String inKey) {
        String result="";
        for (int i = 0; i < inText.length(); i++) {
           result = result + (char) (inText.charAt(i) ^ inKey.charAt(i % inKey.length()));
        }
        return result;
    }

    public static void run(){

        Scanner scanner = new Scanner(System.in);

        System.out.println("Input text");
        String text = scanner.nextLine();
        System.out.println("Input key");
        String key = scanner.nextLine();

        System.out.println(code(text, key));

    }

}
