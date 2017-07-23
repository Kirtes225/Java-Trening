package com.company;


public class Square extends Figure implements Print {

    private double side;

    public Square() {
    }

    public Square(double side) {
        this.side = side;
    }

    public double getSide() {
        return side;
    }

    public void setSide(double side) {
        this.side = side;
    }

    @Override
    public void print() {
        System.out.println("Side: " + side);
        System.out.println(String.format("Area: %.2f", calculateArea()));
        System.out.println(String.format("Perimeter: %.2f", calculatePerimeter()));
    }

    @Override
    double calculateArea() {
        return side * side;
    }

    @Override
    double calculatePerimeter() {
        return 4 * side;
    }
}
