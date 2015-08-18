package com.Hellel.PSoloid.studentSave;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;

/**
 * Created by otk_prog on 17.08.2015.
 */
public class StudentForm extends JFrame {
    private JButton saveButton;
    private JButton readButton;
    private JTextPane textPane1;
    private JLabel id;
    private JTextField idField;
    private JLabel surname;
    private JTextField surnameField;
    private JList marks;
    private JPanel contentPane;

    private void createUIComponents() {
//        saveButton = new JButton();
//        readButton = new JButton();
//        textPane1 = new JTextPane();
//        id = new JLabel("id");
//        surname = new JLabel("surname");
//        idField = new JTextField();
//        surname = new JLabel();
//        surnameField = new JTextField();
//        marks = new JList();


        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        setBounds(100, 100, 450, 300);
//        contentPane = new JPanel();
//        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
//        setContentPane(contentPane);
//        contentPane.setLayout(null);
//
//
//        JLabel idLable = new JLabel("id");
//
//        idField = new JTextField();
//        idField.setBackground(Color.LIGHT_GRAY);
//        idField.setBounds(10, 11, 86, 20);
//        contentPane.add(idField);
//        idField.setColumns(4);
//
//        JLabel surnameLable = new JLabel("surname");
//
//        surnameField = new JTextField();
//        surnameField.setBackground(Color.LIGHT_GRAY);
//        surnameField.setBounds(10, 31, 86, 20);
//        contentPane.add(idField);
//        surnameField.setColumns(20);
//
//
//
//
//
//        JButton btnSave = new JButton("Save");
//        btnSave.setBounds(106, 10, 89, 23);
//        btnSave.addActionListener(new ActionListener() {
//
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                saveToFile(idField.getText());
//            }
//        });
//        contentPane.add(btnSave);
//
//        final JTextArea textArea = new JTextArea();
//        textArea.setBackground(Color.LIGHT_GRAY);
//        textArea.setBounds(205, 14, 219, 190);
//        contentPane.add(textArea);
//
//        JButton btnRead = new JButton("Read");
//        btnRead.setBounds(10, 42, 89, 23);
//        btnRead.addActionListener(new ActionListener() {
//
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                String str = readFromFile();
//                textArea.setText(str);
//            }
//        });
//        contentPane.add(btnRead);
//    }


//    public static void main(String[] args) {
//        EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                try {
//        StudentForm frame = new StudentForm();
//        frame.setVisible(true);
//                } catch (Exception e) {
//                    e.printStackTrace();
//                }
//            }
//        });
//    }

//    public WRStudent() {
//        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        setBounds(100, 100, 450, 300);
//        contentPane = new JPanel();
//        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
//        setContentPane(contentPane);
//        contentPane.setLayout(null);
//
//
//        JLabel idLable = new JLabel("id");
//
//        idField = new JTextField();
//        idField.setBackground(Color.LIGHT_GRAY);
//        idField.setBounds(10, 11, 86, 20);
//        contentPane.add(idField);
//        idField.setColumns(4);
//
//        JLabel surnameLable = new JLabel("surname");
//
//        surnameField = new JTextField();
//        surnameField.setBackground(Color.LIGHT_GRAY);
//        surnameField.setBounds(10, 31, 86, 20);
//        contentPane.add(idField);
//        surnameField.setColumns(20);
//
//
//
//
//
//        JButton btnSave = new JButton("Save");
//        btnSave.setBounds(106, 10, 89, 23);
//        btnSave.addActionListener(new ActionListener() {
//
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                saveToFile(idField.getText());
//            }
//        });
//        contentPane.add(btnSave);
//
//        final JTextArea textArea = new JTextArea();
//        textArea.setBackground(Color.LIGHT_GRAY);
//        textArea.setBounds(205, 14, 219, 190);
//        contentPane.add(textArea);
//
//        JButton btnRead = new JButton("Read");
//        btnRead.setBounds(10, 42, 89, 23);
//        btnRead.addActionListener(new ActionListener() {
//
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                String str = readFromFile();
//                textArea.setText(str);
//            }
//        });
//        contentPane.add(btnRead);
//    }
    }

    static String readFromFile() {
        ObjectInputStream in = null;
        try {
            in = new ObjectInputStream(new FileInputStream("text.txt"));
            return (String) in.readObject();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (in != null) {
                    in.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return "";
    }

    static void saveToFile(String text) {
        ObjectOutputStream out = null;
        try {
            out = new ObjectOutputStream(new FileOutputStream("text.txt"));
            out.writeObject(text);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (out != null) {
                    out.flush();
                    out.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }


}


