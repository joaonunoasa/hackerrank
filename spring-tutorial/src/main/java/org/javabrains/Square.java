package org.javabrains;

public class Square {

    private final String size;

    public Square(String size) {
        this.size = size;
    }

    private String getSize() {
        return size;
    }

    void draw() {
        System.out.println("Square of size " + getSize());
    }
}
