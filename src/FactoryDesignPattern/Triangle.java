package FactoryDesignPattern;


public class Triangle extends Shape {


    public Triangle() {
        super("Triagnle");
        shapeType = ShapeType.Triangle;
    }

    @Override
    public void draw() {
        System.out.println("Draw a triangle with a ShapeName: " + shapeName);
    }

}
