package com.Hellel.PSoloid.ColorsShape.Shape;

import com.Hellel.PSoloid.ColorsShape.Colour.Colour;
import com.Hellel.PSoloid.ColorsShape.Shape.Shape;

/**
 * Created by otk_prog on 20.07.2015.
 */
public class Square extends Shape {

    private double a;

    public double getA() {
        return a;
    }

    public void setA(double a) {
        this.a = a;
    }

    public Square(String nameShape, Colour colour, double a) {
        super(nameShape, colour);
        this.a = a;
    }

    @Override
    public double getSquare() {
        return Math.pow(a, 2);

    }
}
