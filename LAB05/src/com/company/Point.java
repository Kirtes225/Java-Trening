package com.company;

import java.awt.geom.Point2D;
import java.util.Random;

import static com.company.Equation.calc;

public class Point {
    public static void main(String[] args) {
        int yes = 0, no =0;
        double x, y;
        Random random = new Random();
        for(;;){
            Point2D point2D = new Point2D.Double(random.nextDouble(), random.nextDouble());
            if(calc(-8 + (8 - (-8))*point2D.getX(), -8 + (8 - (-8))*point2D.getY()))
                yes++;
            else
                no++;
            System.out.println("YES: " + yes + "\tNO: " + no);
        }
    }
}
