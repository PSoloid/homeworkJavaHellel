package com.Hellel.PSoloid.ColorsShape.Shape;

import com.Hellel.PSoloid.ColorsShape.Colour.Colour;
import com.Hellel.PSoloid.ColorsShape.Shape.Shape;

/**
 * Created by otk_prog on 20.07.2015.
 */
public class Triangle extends Shape {

    private double h;
    private double b;

    public double getH() {
        return h;
    }

    public void setH(double h) {
        this.h = h;
    }

    public double getB() {
        return b;
    }

    public void setB(double b) {
        this.b = b;
    }

    public Triangle(String nameShape, Colour colour, double h, double b) {
        super(nameShape, colour);
        this.h = h;
        this.b = b;
    }

    @Override
    public double getSquare() {
        return h*b/2;

    }
}
