package com.chomentowski.mBankHomework.shapes;

public class ShapeSimulation {

    public static void main(String[] args) {
        Shape rectangle = new Rectangle(2, 5);
        Shape square = new Square(5.5);

        System.out.println(rectangle.calculateArea());
        System.out.println(square.calculateArea());
    }
}
