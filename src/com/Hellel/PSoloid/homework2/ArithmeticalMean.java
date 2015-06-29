package com.Hellel.PSoloid.homework2;

import java.util.Scanner;

/**
 * Created by otk_prog on 25.06.2015.
 *
 * Программа, которая находит среднее арифметическое значение трёх чисел.
 */
public class ArithmeticalMean {


    public static void run() {
        double sum = 0;
        int i = 0;
        boolean flag = false;
        System.out.println("Please input numbers (To calculate input '=')");
        do {
            Scanner scanner = new Scanner(System.in);
            if (scanner.hasNextDouble()) {
                sum = sum + scanner.nextDouble();
                i++;
            } else if (scanner.next().equals("=")) {
                flag = true;
            } else {
                System.out.println("error, try again.");
            }
    }
        while (!flag);
        System.out.print("Arithmetical mean = " + sum/i);
    }
}



