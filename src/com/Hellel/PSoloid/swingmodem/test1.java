package com.Hellel.PSoloid.swingmodem;

import javax.swing.*;

/**
 * Created by NewClass8 on 07.08.2015.
 */
public class test1 extends JFrame {


    private JPanel panel1;
    private JTextField textField1;
    private JPasswordField passwordField1;

    public JPanel getPanel1() {
        return panel1;
    }


    public  void setPanel1(JPanel panel1){
        this.panel1=panel1;
    }

    public static void main(String[] args) {
        test1  frame = new test1();
        frame.setContentPane(frame.getPanel1());
    }
}
