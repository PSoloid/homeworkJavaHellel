package com.Hellel.PSoloid;

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

    public static void run() {

        System.out.print("Please input horizontal size: ");
        int horSize = Main.getInputInt();
        System.out.println("Your input " + horSize + " as a vertical size \n");

        System.out.print("Please input vertical size: ");
        int verSize = Main.getInputInt();
        System.out.println("Your input " + verSize + " as a horizontal size \n");

//        �. ������� �������������

        for (int i = 1 ;i <= verSize; i++) {
            for (int j = 1; j <= horSize; j++) {
                if ((i==verSize) || (j==1) || (j==horSize) || (i==1)) {
                    System.out.print("*");
                }else {
                    System.out.print(" ");
                }
            }

            System.out.print("\n");
        }

//        �. �������

        for (int i = 1 ;i <= verSize; i++) {
            for (int j = 1; j <= horSize; j++) {
                if ((i==verSize) || (j==1) ||
                    (j==horSize) || (i==1) ||
                    (j==i) || (i+j==1+verSize)){
                    System.out.print("*");
                }else {
                    System.out.print(" ");
                }
            }

            System.out.print("\n");
        }

    }
}






















