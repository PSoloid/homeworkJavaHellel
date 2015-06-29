package com.Hellel.PSoloid.homework3;

/**
 * Created by Morozov on 29.06.2015.
 */
public class LongSquare {
    public static void run(){
        System.out.println("Input x1 square");
        int x1 = Main.getInputInt();
        System.out.println("Input y1 square");
        int y1 = Main.getInputInt();
        System.out.println("Input x2 square");
        int x2 = Main.getInputInt();
        System.out.println("Input y2 square");
        int y2 = Main.getInputInt();
        System.out.println("Input x point");
        int x = Main.getInputInt();
        System.out.println("Input y point");
        int y = Main.getInputInt();

        if ((x>x1)&&(x<x2)&&(y>y1)&&(y<y2)){
            System.out.println("Point in square");
        }else{
            System.out.println("Point out of square");
        }
    }
}
