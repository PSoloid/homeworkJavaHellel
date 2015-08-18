package com.Hellel.PSoloid.studentSave;

import com.Hellel.PSoloid.homework5.student.Student;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class WRStudent extends JFrame {

    private JPanel contentPane;
    private JTextField idField;
    private JTextField surnameField;

    private static ObjectOutputStream out = null;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    WRStudent frame = new WRStudent();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public WRStudent() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(400, 200, 550, 200);
        contentPane = new JPanel();
        setContentPane(contentPane);

        GridBagLayout gridbag=new GridBagLayout();
        contentPane.setLayout(gridbag);
        contentPane.setBorder(BorderFactory.createLineBorder(Color.yellow));

        GridBagConstraints GrBgCnstr = new GridBagConstraints();

        GrBgCnstr.fill = GridBagConstraints.BOTH;


        JLabel idLable = new JLabel("id");
        GrBgCnstr.gridx = 0;
        GrBgCnstr.gridy = 0;
        gridbag.setConstraints(idLable, GrBgCnstr);
        contentPane.add(idLable);


        idField = new JTextField();
        GrBgCnstr.gridx = 1;
        GrBgCnstr.gridy = 0;
        gridbag.setConstraints(idField, GrBgCnstr);
        contentPane.add(idField);
        idField.setColumns(4);

        JLabel surnameLable = new JLabel("surname");
        GrBgCnstr.gridx = 0;
        GrBgCnstr.gridy = 1;
        gridbag.setConstraints(surnameLable, GrBgCnstr);
        contentPane.add(surnameLable);


        surnameField = new JTextField();
        GrBgCnstr.gridx = 1;
        GrBgCnstr.gridy = 1;
        gridbag.setConstraints(surnameField, GrBgCnstr);
        contentPane.add(surnameField);
        surnameField.setColumns(20);


        JLabel marksLable = new JLabel("marks");
        GrBgCnstr.gridx = 0;
        GrBgCnstr.gridy = 2;
        gridbag.setConstraints(marksLable, GrBgCnstr);
        contentPane.add(marksLable);

        JTextField marksField = new JTextField();
        GrBgCnstr.gridx = 1;
        GrBgCnstr.gridy = 2;
        gridbag.setConstraints(marksField, GrBgCnstr);
        contentPane.add(marksField);


        final JTextArea textArea = new JTextArea();

        GrBgCnstr.gridx = 1;
        GrBgCnstr.gridy = 4;
        gridbag.setConstraints(textArea, GrBgCnstr);
        textArea.setBackground(Color.LIGHT_GRAY);
        textArea.setSize(219, 190);
        contentPane.add(textArea);




        JButton btnSave = new JButton("Save");
        GrBgCnstr.gridx = 0;
        GrBgCnstr.gridy = 3;
        gridbag.setConstraints(btnSave, GrBgCnstr);
        btnSave.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                int id = Integer.parseInt(idField.getText().trim());
                String surname = surnameField.getText();

                char [] charArr = marksField.getText().toCharArray();
                int [] marks = new int[charArr.length];
                for (int i=0; i<charArr.length; i++){
                marks[i]=(int) charArr[i];
                }

                saveToFile(id, surname , marks);
            }
        });
        contentPane.add(btnSave);

        JButton btnRead = new JButton("Read");
        GrBgCnstr.gridx = 1;
        GrBgCnstr.gridy = 3;
        gridbag.setConstraints(btnRead, GrBgCnstr);
        btnRead.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                Student student = readFromFile();

//                Integer idInt = student.getId();
//                String id = idInt.toString();
//                String surname = student.getSurname();
//                String marks = null;
//                Integer mark;
//                for (int i = 0; i < student.getMarks().length; i++){
//                    mark = student.getMarks()[i];
//                    marks = mark +" ";
//                }

                textArea.setText(student.toString());
//                textArea.setText(id + " " + surname + " " + marks);

                } catch (NullPointerException ex) {
                    ex.printStackTrace();
                }
            }
        });
        contentPane.add(btnRead);
    }


    static Student readFromFile() {
        ObjectInputStream in = null;

        try {
            in = new ObjectInputStream(new FileInputStream("resourses/student.dat"));

            Student student = (Student) in.readObject();
            return student;

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
        return null;
    }

    static void saveToFile(int id, String surname, int [] marks) {

        try {

            Student student = new Student(id, surname, marks);

                out = new ObjectOutputStream(new FileOutputStream("resourses/student.dat"));

            out.writeObject(student);

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
