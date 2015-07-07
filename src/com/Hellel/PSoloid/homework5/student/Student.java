package com.Hellel.PSoloid.homework5.student;

/**
 * Created by ITHILLEL7 on 30.06.2015.
 */
public class Student implements Comparable {

    private int id;
    private String surname =null;
    private int[] marks;

    @Override
    public int compareTo(Object obj)
    {
        Student tmp = (Student)obj;
        if(this.id < tmp.id)
        {
      /* текущее меньше полученного */
            return -1;
        }
        else if(this.id > tmp.id)
        {
      /* текущее больше полученного */
            return 1;
        }
    /* текущее равно полученному */
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
}
