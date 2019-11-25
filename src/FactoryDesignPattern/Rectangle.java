package FactoryDesignPattern;


public class Rectangle extends Shape {


    public Rectangle() {
        super("Rectangle");
        shapeType = ShapeType.Rectangle;
    }

    @Override
    public void draw() {
        System.out.println("Draw a Rectangle with a ShapeName: " + shapeName);
    }
}
