package com.company;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choice;
        char looping = 'n';

        System.out.println("-----Simple calculator-----");
        System.out.println("1 - Triangle");
        System.out.println("2 - Square");
        System.out.println("3 - Circle");
        do {
            System.out.println("Triangle, square or circle?");
            choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    Triangle triangle = new Triangle();
                    System.out.println("Please put in numbers");
                    try {
                        System.out.print("Basis: ");
                        triangle.setBasis(scanner.nextDouble());
                        System.out.print("Height: ");
                        triangle.setHeight(scanner.nextDouble());
                    } catch (InputMismatchException e) {
                        System.out.println("ERROR: Invalid input.");
                        break;
                    }
                    System.out.println("");
                    triangle.print();
                    System.out.println("Do you want to continue - put in y or Y");
                    looping = scanner.next().trim().charAt(0);
                    break;
                case 2:
                    Square square = new Square();
                    System.out.println("Please put in a number");
                    try {
                        System.out.print("Side: ");
                        square.setSide(scanner.nextDouble());
                    } catch (InputMismatchException e) {
                        System.out.println("ERROR: Invalid input.");
                        break;
                    }
                    System.out.println("");
                    square.print();
                    System.out.println("Do you want to continue - put in y or Y");
                    looping = scanner.next().trim().charAt(0);
                    break;
                case 3:
                    Circle circle = new Circle();
                    System.out.println("Please put in a number");
                    try {
                        System.out.print("Radius: ");
                        circle.setRadius(scanner.nextDouble());
                    } catch (InputMismatchException e) {
                        System.out.println("ERROR: Invalid input.");
                        break;
                    }
                    System.out.println("");
                    circle.print();
                    System.out.println("Do you want to continue - put in y or Y");
                    looping = scanner.next().trim().charAt(0);
                    break;
                default:
                    System.out.println("Wrong input");
                    System.out.println("Do you want to continue - put in y or Y");
                    looping = scanner.next().trim().charAt(0);
            }
        }while(looping=='y' || looping=='Y');
    }
}
