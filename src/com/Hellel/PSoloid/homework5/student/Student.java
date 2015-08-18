package com.Hellel.PSoloid.homework5.student;

import java.io.Serializable;
import java.util.Arrays;

/**
 * Created by ITHILLEL7 on 30.06.2015.
 */
public class Student implements Comparable<Student>, Serializable {

    private int id;
    private String surname =null;
    private int[] marks;

    @Override
    public int compareTo(Student st)
    {

        if(this.getSurname().charAt(0) < st.getSurname().charAt(0))
        {

            return -1;
        }
        else if(this.getSurname().charAt(0) > st.getSurname().charAt(0))
        {

            return 1;
        }

        return 0;
    }

    public Student(){
        id=0;
        surname = "N/A";
        marks = new int[34];
    }
    public Student(int i, String s, int[] m){
        id=i;
        surname = s;
        marks = m;
    }
    public Student(int id, String surname){
        this.id = id;
        this.surname = surname;
        marks = new int[34];
    }

    public Student(Student st){
        this.id = st.id;
        surname = new String(st.surname);
        marks = new int[st.marks.length];
        for(int i=0; i<marks.length; i++){
            marks[i] = st.marks[i];
        }
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", surname='" + surname + '\'' +
                ", marks=" + Arrays.toString(marks) +
                '}';
    }

    public void print() {
        System.out.println(getId() + " " + getSurname() + "\n");
        for (int i=0;i<getMarks().length;i++)
            System.out.print(getMarks()[i]+", ");
    }

    public int getId(){
        return id;
    }

    public void setId(int id){
        this.id=id;
    }
    public void setId(long id){
        this.id=(int)id;
    }

    public int[] getMarks() {
        return marks;
    }

    public void setMarks(int[] marks) {
        this.marks = marks;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setMark(int lessonNum, int mark){
        this.marks[lessonNum]=mark;
    }

    public int getMark(int lessonNum){
        return this.marks[lessonNum];
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Student student = (Student) o;

        if (id != student.id) return false;
        if (surname != null ? !surname.equals(student.surname) : student.surname != null) return false;
//        return Arrays.equals(marks, student.marks);
        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (surname != null ? surname.hashCode() : 0);
//        result = 31 * result + (marks != null ? Arrays.hashCode(marks) : 0);
        return result;
    }
}
