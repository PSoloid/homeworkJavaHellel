package com.Hellel.PSoloid.homework2;

import java.util.Scanner;

/**
 * Created by otk_prog on 24.06.2015.
 *
 * Ќовое требование от заказчика калькул€тора - переделать калькул€тор,
 * чтобы при неправильном вводе чисел программа запрашивала число заново и
 * пользователь сам вводил операцию (+-/*)
*/

public class Calculator {

    public static void run() {

        System.out.print("Please input first number: ");
        double firstNum = Main.getInputDouble();
        System.out.println("Your input " + firstNum + " as a first number \n");


        System.out.print("Please input second number: ");
        double secondNum = Main.getInputDouble();
        System.out.println("Your input " + secondNum + " as a second number \n");

        System.out.print("Please input sign (+-:/): ");

        boolean flag = true;
        do {
            Scanner scanner = new Scanner(System.in);

            switch (scanner.nextLine()) {
                case "+":
                    System.out.println("\n Result: " + firstNum + " + " + secondNum + " = " + (firstNum + secondNum));
                    break;
                case "-":
                    System.out.println("\n Result: " + firstNum + " - " + secondNum + " = " + (firstNum - secondNum));
                    break;
                case "*":
                    System.out.println("\n Result: " + firstNum + " * " + secondNum + " = " + (firstNum * secondNum));
                    break;
                case "/":
                    if (secondNum == 0) {
                        System.out.println("Division by zero, try again");
                        flag = false;
                    }else
                        System.out.println("\n Result: " + firstNum + " / " + secondNum + " = " + (firstNum / secondNum));
                    break;
                default:
                    System.out.println("error, try again.");
                    flag = false;
                    break;
            }
        }
        while (!flag);
    }
}