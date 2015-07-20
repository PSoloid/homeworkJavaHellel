package com.Hellel.PSoloid.ColorsShape.Shape;

import com.Hellel.PSoloid.ColorsShape.Colour.Colour;

/**
 * Created by otk_prog on 20.07.2015.
 */
public abstract class Shape {

    protected String nameShape;
    protected Colour colour;

    public String getNameShape() {
        return nameShape;
    }

    public void setNameShape(String nameShape) {
        this.nameShape = nameShape;
    }


    public Shape(String nameShape, Colour colour) {
        this.nameShape = nameShape;
        this.colour = colour;
    }

    public double getQuantityColor() {

        return colour.getQuantity() * getSquare();
    }

    public double getCostColor() {
        return getQuantityColor()*colour.getCost();
    }


    public abstract double getSquare();



    public String toString() {
        return "\nShape: " + getNameShape() +
                "\nSqure: " + getSquare() +
                "\nColour: " + colour.getColorName() +
                "\nQuantity: " + getQuantityColor() +
                "\nCost: " +  getCostColor();
    }


    protected boolean equals(Shape o) {

        if (o instanceof Shape) {
            if ((o.colour.getColorName().equals(this.colour.getColorName())) &&
                    (o.colour.getCost() == this.colour.getCost()) &&
                    (o.colour.getQuantity() == this.colour.getQuantity()))  {
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }
    }




}
