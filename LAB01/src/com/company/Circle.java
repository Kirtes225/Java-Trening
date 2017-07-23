package com.company;


public class Circle extends Figure implements Print {

    private double radius;

    public Circle(double radius) {

        this.radius = radius;
    }

    public Circle() {
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    @Override
    public void print() {
        System.out.println("Radius: " + radius);
        System.out.println(String.format("Area: %.2f", calculateArea()));
        System.out.println(String.format("Perimeter: %.2f", calculatePerimeter()));
    }

    @Override
    double calculateArea() {
        return Math.PI * Math.pow(radius, 2);
    }

    @Override
    double calculatePerimeter() {
        return 2 * Math.PI * radius;
    }
}
