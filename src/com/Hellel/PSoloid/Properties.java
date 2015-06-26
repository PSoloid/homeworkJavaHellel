package com.Hellel.PSoloid;

import java.math.*;
/**
 * Created by otk_prog on 25.06.2015.
 *
 * ������ �����, ���������� ������ ��� ���.
 * ������ �����, ���������� ������� �� ���.
 * ������ �����, ���������� ����� ������ ��� ������.
 */


public class Properties {

//        ������ �����, ���������� ������ ��� ���.
    public static void even(int num){
        if (num % 2 == 0)
            System.out.println("The number is even");
        else
            System.out.println("The number is odd");
    }

//        * ������ �����, ���������� ������� �� ���.
public static void simple (int num){
    boolean simple = true;
    if (((num % 2==0) && (num !=2)) || (num < 0) ) {
        simple = false;
    }else{
        for (int i=3; i<Math.round(Math.sqrt(num))+1; i++)
            if ((num % i == 0)) {
                simple = false;
                break;
            }
    }
    if (simple) {
        System.out.println("\nThe number is simple");
    }else {
        System.out.println("\nThe number is not simple");
    }
}

//         * ������ �����, ���������� ����� ������ ��� ������.
    public static void division (int num) {
        System.out.println("\nThe number is division by :");
        for (int i=1; i<=Math.abs(num); i++)
            if (num % i == 0) {
                System.out.print(i + ", ");
            }
    }

    public static void run() {
        System.out.print("Please input integer value: ");
        int num = Main.getInputInt();
        System.out.println("Your input " + num + "\n");

        even(num);
        simple (num);
        division (num);
    }
}
