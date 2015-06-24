package com.Hellel.PSoloid;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Created by otk_prog on 24.06.2015.
 */
public class Calculator {

    public static double getInput(){

        while (true){
            Scanner scanner = new Scanner(System.in);
            try {
                return scanner.nextDouble();
            } catch (InputMismatchException e){
                System.out.println("error, try again.");
            }
        }
    }


    public static void main(String[] args) {

        System.out.print("Please input first number: ");
        double firstNum = getInput();
        System.out.println("Your input " + firstNum + " as a first number");
        System.out.println();

        System.out.print("Please input second number: ");
        double secondNum = getInput();
        System.out.println("Your input " + secondNum + " as a second number");
        System.out.println();

        System.out.println("Sum is " + (firstNum + secondNum));
        System.out.println("Difference is " + (firstNum - secondNum));
        System.out.println("Multiplication is " + (firstNum * secondNum));
        System.out.println("Division is " + (firstNum / secondNum));

    }
}