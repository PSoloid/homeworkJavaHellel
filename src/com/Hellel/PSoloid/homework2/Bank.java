package com.Hellel.PSoloid.homework2;

import java.text.NumberFormat;

/**
 * Created by otk_prog on 25.06.2015.
 *
 * Программу, которая предлагает пользователю ввести сумму денежного вклада в гривнах,
 * процент годовых, которые выплачивает банк, длительность вклада (лет).
 * Вывести накопленную сумму денег за каждый год и начисленные проценты.
 */
public class Bank {

    public static void run() {

        NumberFormat formatterCurrency = NumberFormat.getCurrencyInstance();

        System.out.print("Please input bank deposit sum: ");
        double sum = Main.getInputDouble();
        System.out.println("Your input " + formatterCurrency.format(sum) + " as a bank deposit sum \n");

        NumberFormat formatterPercent = NumberFormat.getPercentInstance();
        System.out.print("Please input percent: ");
        double percent = Main.getInputDouble();
        percent = percent/100;
        System.out.println("Your input " + formatterPercent.format(percent) + " as a percent \n");

        NumberFormat formatterNumber = NumberFormat.getNumberInstance();
        System.out.print("Please input years: ");
        int years = Main.getInputInt();
        System.out.println("Your input " + formatterNumber.format(years) + " years \n");


        for (int i=1;i<=years;i++) {
            System.out.println(i + " year:");
            double sumPercent = sum*percent;
            sum =sum+sum*percent;
            System.out.println("\t\t Deposit sum: " + formatterCurrency.format(sum) + "\t percent: " +formatterCurrency.format(sumPercent));

        }

    }


}
