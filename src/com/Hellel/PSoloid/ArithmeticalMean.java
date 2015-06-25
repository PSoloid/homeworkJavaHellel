package com.Hellel.PSoloid;

import java.util.Scanner;

/**
 * Created by otk_prog on 25.06.2015.
 *
 * Программа, которая находит среднее арифметическое значение трёх чисел.
 */
public class ArithmeticalMean {




    public static void run() {
        System.out.print("Please input first number: ");
        double firstNum = Main.getInputDouble();
        System.out.println("Your input " + firstNum + " as a first number \n");


        System.out.print("Please input second number: ");
        double secondNum = Main.getInputDouble();
        System.out.println("Your input " + secondNum + " as a second number \n");

        System.out.print("Please input third number: ");
        double thirdNum = Main.getInputDouble();
        System.out.println("Your input " + thirdNum + " as a third number \n");

        System.out.println("ArithmeticalMean = " + ((firstNum+secondNum+thirdNum)/3));
    }

}
