package com.Hellel.PSoloid.homework3;

import java.util.Scanner;

/**
 * Created by Morozov on 29.06.2015.
 */
public class Main {
    public static double getInputDouble(){

        double num = 0;
        boolean flag = false;
        do {
            Scanner scanner = new Scanner(System.in);
            if (scanner.hasNextDouble()) {
                num = scanner.nextDouble();
                flag = true;
            }
            else {
                System.out.println("error, try again.");
            }
        }
        while  (!flag);

        return num;
    }

    public static int getInputInt(){
        int num = 0;
        boolean flag = false;
        do {
            Scanner scanner = new Scanner(System.in);
            if (scanner.hasNextInt()) {
                num = scanner.nextInt();
                flag = true;
            }
            else {
                System.out.println("error, try again.");
            }
        }
        while  (!flag);

        return num;
    }

    public static void main(String[] args) {

        System.out.println("0. Number sum");
        System.out.println("1. Long square");
        System.out.println("2. XOR");
        System.out.println("3. Students");
        System.out.println("4. Fibonacci");
        System.out.print("\n Input (0-4): ");

        boolean flag;
        do {
            flag =true;
            Scanner scanner = new Scanner(System.in);
            if (scanner.hasNextInt()) {
                switch (scanner.nextInt()) {
                    case 0:
                        SumNumber.run();
                        break;
                    case 1:
                        LongSquare.run();
                        break;
                    case 2:
                        Xor.run();
                        break;
                    case 3:
                        Students.run();
                        break;
                    case 4:
                        System.out.print("Iput index: ");
                        System.out.println(Fibonacci.run(getInputInt()));
                        break;
                    default:
                        System.out.println("error, try again.");
                        flag = false;
                        break;
                }
            } else {
                System.out.println("error, try again.");
                flag = false;
            }
        }
        while (!flag) ;
    }
}

