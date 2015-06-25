package com.Hellel.PSoloid;

import java.math.*;
/**
 * Created by otk_prog on 25.06.2015.
 *
 * ¬вести число, определить чЄтное или нет.
 * ¬вести число, определить простое ли оно.
 * ¬вести число, определить каким числам оно кратно.
 */


public class EvenOdd {

    public static void run() {
        System.out.print("Please input integer value: ");
        int num = Main.getInputInt();
        System.out.println("Your input " + num + "\n");

//        ¬вести число, определить чЄтное или нет.

        if (num % 2 == 0)
            System.out.println("The number is even");
        else
            System.out.println("The number is odd");

//        * ¬вести число, определить простое ли оно.

        boolean simple = true;
        for (int i=2; i<num; i++)
            if ((num % i == 0) && (num > 0)) {
                simple = false;
            }
        if (simple) {
            System.out.println("\nThe number is simple");
        }else {
            System.out.println("\nThe number is not simple");
              }

//         * ¬вести число, определить каким числам оно кратно.

        System.out.println("\nThe number is division by :");
        for (int i=1; i<=num; i++)
            if (num % i == 0) {
               System.out.print(i + ", ");
            }
    }
}
