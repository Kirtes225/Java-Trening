package com.company;

public class Triangle extends Figure implements Print {

    private double basis;
    private double height;

    public Triangle() {
    }

    public Triangle(double basis, double height) {
        this.basis = basis;
        this.height = height;
    }

    public double getHeight() {

        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public double getBasis() {
        return basis;
    }

    public void setBasis(double basis) {
        this.basis = basis;
    }

    @Override
    public void print() {
        System.out.println("Basis: " + basis);
        System.out.println("Height: " + height);
        System.out.println(String.format("Area: %.2f", calculateArea()));
        System.out.println(String.format("Perimeter: %.2f", calculatePerimeter()));
    }

    @Override
    double calculateArea() {
        return 0.5 * basis * height;
    }

    @Override
    double calculatePerimeter() {
        return basis + 2 * Math.sqrt(Math.pow(0.5 * basis, 2) + Math.pow(height, 2));
    }
}
