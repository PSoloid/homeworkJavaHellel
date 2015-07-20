package com.Hellel.PSoloid.ColorsShape.Shape;

import com.Hellel.PSoloid.ColorsShape.Colour.Colour;

/**
 * Created by otk_prog on 20.07.2015.
 */
public class Parallelogram extends Shape {

    private double a;
    private double b;

    public double getA() {
        return a;
    }

    public void setA(double a) {
        this.a = a;
    }

    public double getB() {
        return b;
    }

    public void setB(double b) {
        this.b = b;
    }

    public Parallelogram(String nameShape, Colour colour, double a, double b) {
        super(nameShape, colour);
        this.a = a;
        this.b = b;
    }

    @Override
    public double getSquare() {
        return a*b;

    }

}
