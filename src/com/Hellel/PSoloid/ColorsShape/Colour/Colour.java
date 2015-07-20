package com.Hellel.PSoloid.ColorsShape.Colour;

/**
 * Created by otk_prog on 20.07.2015.
 */
public abstract class Colour {
    protected String colorName;
    protected double quantity;
    protected double cost;

    public Colour(String colorName, double quantity, double cost) {
        this.colorName = colorName;
        this.quantity = quantity;
        this.cost = cost;

    }

    public Colour() {
    }


    public String getColorName() {
        return colorName;
    }

    public void setColorName(String colorName) {
        this.colorName = colorName;
    }

    public double getQuantity() {
        return quantity;
    }

    public void setQuantity(double quantity) {
        this.quantity = quantity;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }




}

