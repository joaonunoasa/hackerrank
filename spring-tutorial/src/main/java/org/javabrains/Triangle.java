package org.javabrains;

public class Triangle {

    private String type;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    void draw() {
        System.out.println("Triangle draw of type " + getType());
    }
}