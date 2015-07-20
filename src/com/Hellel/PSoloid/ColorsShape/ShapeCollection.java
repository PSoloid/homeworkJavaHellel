package com.Hellel.PSoloid.ColorsShape;

import com.Hellel.PSoloid.ColorsShape.Colour.*;
import com.Hellel.PSoloid.ColorsShape.Shape.*;

/**
 * Created by otk_prog on 20.07.2015.
 */
public class ShapeCollection {

    private Shape[] shapes = new Shape[10];
    private int size = 0;


    public int size() {
        return size;
    }

    public boolean add(Shape o) {
        boolean flag = false;
        if (size() < shapes.length) {
            shapes[size] = o;
            size++;
            flag = true;
        } else {
            resize();
            shapes[size] = o;
            size++;
            flag = true;
        }
        return flag;
    }

    public void resize() {
        Shape[] newElements = new Shape[shapes.length * 2];
        for (int i = 0; i < shapes.length; i++) {
            newElements[i] = shapes[i];
        }
        shapes = newElements;
    }

    public boolean remove(Shape o) {
        boolean flag = false;
        for (int i = 0; i < size; i++) {
            if (o.equals(shapes[i])) {
                for (int j = i; j < size - 1; j++) {
                    shapes[j] = shapes[j + 1];
                }
                size--;
                flag = true;
            }
        }
        return flag;
    }

    public double generalCost() {
        double rezult = 0;
        for (int i = 0; i < size; i++) {

            rezult = rezult + shapes[i].getCostColor();
        }
        return rezult;
    }

    public double generalSquare() {
        double rezult = 0;
        for (int i = 0; i < size; i++) {

            rezult = rezult + shapes[i].getSquare();
        }
        return rezult;

    }

    public double generalQuantity() {
        double rezult = 0;
        for (int i = 0; i < size; i++) {

            rezult = rezult + shapes[i].getQuantityColor();
        }
        return rezult;

    }

    public void print(){
        System.out.println("Shapes collection: ");
        for(int i=0;i<size;i++){
            System.out.println(shapes[i] + "\n");
        }
        System.out.println();
    }



    public static void main(String[] args) {

        Red red = new Red("Red",4,3);
        Blue blue = new Blue("Blue",2,1);
        Green green = new Green("Green",2,4);
        Yellow yellow = new Yellow("Yellow",3,5);

        Circle circle = new Circle("Circle",red,7);
        Parallelogram parallelogram = new Parallelogram("Parallelogram",green,4,3);
        Square square = new Square("Square",blue,4);
        Triangle triangle = new Triangle("Triangle",yellow,4,3);

        ShapeCollection shapes = new ShapeCollection();

        shapes.add(circle);
        shapes.add(parallelogram);
        shapes.add(square);
        shapes.add(triangle);

        shapes.print();




        System.out.println("General cost: " + shapes.generalCost());
        System.out.println("General quantity: " + shapes.generalQuantity());
        System.out.println("General squre: " + shapes.generalSquare());


    }
}