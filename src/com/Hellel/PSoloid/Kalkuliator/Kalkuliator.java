package com.Hellel.PSoloid.Kalkuliator;

import javax.swing.*;


/**
 * Created by otk_prog on 10.08.2015.
 */
public class Kalkuliator {


    public static void main(String[] args) {

        JFrame kalkFrame = new JFrame("Kalkuliator");


        KalkuliatorModel kalkModel = new KalkuliatorModel();

        KalkuliatorPanel kalkPanel = new KalkuliatorPanel(kalkModel);

        kalkPanel.init();


        kalkFrame.setContentPane(kalkPanel);

        kalkFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        kalkFrame.pack();

        kalkFrame.setVisible(true);
    }
}
