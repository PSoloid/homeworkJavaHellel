package com.Hellel.PSoloid.homework2;

/**
 * Created by otk_prog on 25.06.2015.
 *
 * ������� �� ������� ������� (������ � ������ ������ ������������) ����:
 �. ������� �������������
 **************
 *            *
 *            *
 *            *
 *            *
 **************
 �. ������� (���������� ������� ���������� ���� ���������, � ����� ������)
 *******
 **   **
 * * * *
 *  *  *
 * * * *
 **   **
 *******
 �. � ��������� �������
 * * * *
  * * * *
 * * * *
  * * * *
 * * * *
  * * * *
 * * * *
  * * * *
 * * * *
  * * * *
 */

public class Grafika {

//        �. ������� �������������
    public static void square(int horSize, int verSize) {
        for (int i = 1; i <= verSize; i++) {
            for (int j = 1; j <= horSize; j++) {
                if ((i == verSize) || (j == 1) || (j == horSize) || (i == 1)) {
                    System.out.print("*");
                } else {
                    System.out.print(" ");
                }
            }
            System.out.print("\n");
        }
    }

    //        Konvert
    public static void cross(int horSize, int verSize) {
        for (int i = 1; i <= verSize; i++) {
            for (int j = 1; j <= horSize; j++) {
                if ((i == verSize) || (j == 1) ||
                    (j == horSize) || (i == 1) ||
                   /* (10*(j-1)/(horSize-1) == 10*(i-1)/(verSize-1)) ||*/         // уравнение прямой
                    (i==(j*(1-verSize)/(1-horSize))+(verSize-horSize*(1-verSize)/(1-horSize))) ||
                    (i==(j*(verSize-1)/(1-horSize))+(1-horSize*(verSize-1)/(1-horSize)))){

                    System.out.print("*");
                } else {
                    System.out.print(" ");
                }
            }
            System.out.print("\n");
        }
    }

//          CHESS
    public static void chess(int horSize, int verSize) {
        for (int i = 1; i <= verSize; i++) {
            for (int j = 1; j <= horSize; j++) {
                if ((i + j) % 2 == 0) {
                    System.out.print("*");
                } else {
                    System.out.print(" ");
                }
            }
            System.out.print("\n");
        }
    }


    public static void run() {

        System.out.print("Please input horizontal size: ");
        int horSize = Main.getInputInt();
        System.out.println("Your input " + horSize + " as a horizontal size \n");

        System.out.print("Please input vertical size: ");
        int verSize = Main.getInputInt();
        System.out.println("Your input " + verSize + " as a vertical size \n");

        square(horSize, verSize);
        System.out.println("\n\n");
        cross(horSize, verSize);
        System.out.println("\n\n");
        chess(horSize, verSize);
    }
}
























