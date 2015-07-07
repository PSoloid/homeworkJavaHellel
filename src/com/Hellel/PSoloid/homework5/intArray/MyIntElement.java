package com.Hellel.PSoloid.homework5.intArray;

/**
 * Created by Morozov on 07.07.2015.
 */
public class MyIntElement implements Comparable<MyIntElement> {

    private int value=0;
//    private int index=0;

        public void setValue(int value) {
        this.value = value;
    }

//    public void setIndex(int index) {
//        this.index = index;
//    }

    public int getValue() {

        return value;
    }

//    public int getIndex() {
//        return index;
//    }

   public MyIntElement(/*int index,*/ int value){
        this.value=value;
//        this.index=index;

}
    @Override
    public int compareTo(MyIntElement elem)
    {
        if(this.getValue() < elem.getValue())
        {
            return -1;
        }
        else if(this.getValue() > elem.getValue())
        {
            return 1;
        }
        return 0;
    }
}
