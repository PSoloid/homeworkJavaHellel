package com.Hellel.PSoloid.ColorsShape.Shape;

import com.Hellel.PSoloid.ColorsShape.Colour.Colour;

/**
 * Created by otk_prog on 20.07.2015.
 */
public class Circle extends Shape {

    private double r;

    public double getR() {
        return r;
    }

    public void setR(double r) {
        this.r = r;
    }

    public Circle(String nameShape, Colour colour, double r) {
        super(nameShape, colour);
        this.r = r;
    }

    @Override
   public double getSquare() {
        return Math.PI*Math.sqrt(r);

    }
}
