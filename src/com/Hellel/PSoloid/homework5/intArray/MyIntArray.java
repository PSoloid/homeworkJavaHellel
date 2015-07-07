package com.Hellel.PSoloid.homework5.intArray;


import java.util.Arrays;

/**
 * Created by Morozov on 04.07.2015.
 */
public class MyIntArray {

    private MyIntElement[] intArray = new MyIntElement[10];
    private int size = 0;


    public MyIntElement[] getIntArray() {
        return intArray;
    }

    public int getSize() {
        return size;
    }

    public boolean isEmpty() {
        return getSize() == 0;
    }


    public void addInt(MyIntElement element) {
        if(size<intArray.length-1){
            intArray[size]=element;
            size++;
        }else{
            MyIntElement[] newIntArray = new MyIntElement[intArray.length^2];
            for(int i=0; i<intArray.length; i++){
                newIntArray[i] = intArray[i];

                newIntArray[size]=element;
                size++;
                intArray = newIntArray;
            }
        }
    }

    public void addInt(/*int index,*/ int value) {
        MyIntElement intElement = new MyIntElement(/*index,*/ value);
        addInt(intElement);
    }

//    public void addInt(int value) {
//        MyIntElement intElement = new MyIntElement(size, value);
//        addInt(intElement);
//    }

    public MyIntElement get(int index) {
        return intArray[index];
    }

    public void delInt(MyIntElement element) {

        MyIntElement[] newIntArray = new MyIntElement[intArray.length-1];

        int num = size;
        int j=0;
        for(int i=0; i<num; i++){
            if (intArray[i].getValue()!=element.getValue()){
                newIntArray[j]=intArray[i];
                j++;
            }else
                size--;
        }
        intArray=newIntArray;
    }

    public void delInt(int value) {
        for (int i = 0; i < size; i++) {
            if (intArray[i].getValue() == value)
                delInt(intArray[i]);
        }
    }

    public void trim () {

        int j=0;
        MyIntElement [] newIntArray =new MyIntElement[size] ;
        j=0;
        for (int i = 0; i < size; i++){
            newIntArray[j]=intArray[i];
            j++;
        }
        intArray=newIntArray;
    }


    public void sort () {
        trim();
        Arrays.sort(intArray);
    }


    public void print() {
        for (int i=0;i<size;i++)
            System.out.print("Index: " + i+", " + "Value: " + intArray[i].getValue()+"\n");
    }










}
