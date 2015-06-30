package com.Hellel.PSoloid.homework3;

/**
 * Created by Morozov on 29.06.2015.
 */
public class SumNumber {

    public static void run(){
        System.out.println("Input integer number");
        int num =  Main.getInputInt();
        String stringNum =Integer.toString(num);
        char [] arrayNum = stringNum.toCharArray ();
        int sum = 0;
        for ( char symbol : arrayNum ) {
                sum = sum + Character.getNumericValue ( symbol );
        }
            System.out.println ( "\nsum = " + sum );
    }

}

