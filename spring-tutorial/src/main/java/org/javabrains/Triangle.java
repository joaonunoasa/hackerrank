package org.javabrains;

public class Triangle {

    // autowire by name, type and constructor

    private Point pointA;
    private Point pointB;
    private Point pointC;


    public Point getPointA() {
        return pointA;
    }

    public void setPointA(Point pointA) {
        this.pointA = pointA;
    }

    public Point getPointB() {
        return pointB;
    }

    public void setPointB(Point pointB) {
        this.pointB = pointB;
    }

    public Point getPointC() {
        return pointC;
    }

    public void setPointC(Point pointC) {
        this.pointC = pointC;
    }

    void draw() {
        System.out.println("Auto wiring Triangle Points: " + getPointA() + " " + getPointB() + " " + getPointC());
    }
}