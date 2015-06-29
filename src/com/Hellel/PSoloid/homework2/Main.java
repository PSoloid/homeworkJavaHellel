package com.Hellel.PSoloid.homework2;

import java.util.Scanner;

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

        System.out.println("0. Calculator");
        System.out.println("1. Arithmetical mean");
        System.out.println("2. Bank");
        System.out.println("3. Grafika");
        System.out.println("4. Number properties");
        System.out.print("\n Input (0-4): ");

        boolean flag;
        do {
            flag =true;
            Scanner scanner = new Scanner(System.in);
            if (scanner.hasNextInt()) {
                switch (scanner.nextInt()) {
                    case 0:
                        Calculator.run();
                       break;
                    case 1:
                        ArithmeticalMean.run();
                        break;
                    case 2:
                        Bank.run();
                        break;
                    case 3:
                        Grafika.run();
                        break;
                    case 4:
                        Properties.run();
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
