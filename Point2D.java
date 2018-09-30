package com.company;

public class Point2D {
    public int id;
    public double x;
    public double y;

    public Point2D(int id, double x, double y) {
        this.id = id;
        this.x = x;
        this.y = y;
    }

    public Point2D() {
        this.id = 0;
        this.x = 0.0;
        this.y = 0.0;
    }

    public static double getDistPoints(Point2D pt1, Point2D pt2) {
        return Math.sqrt(Math.pow(pt1.x - pt2.x, 2)
                + Math.pow(pt1.y - pt2.y, 2));
    }

}
