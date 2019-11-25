package FactoryDesignPattern;


public class Circle extends Shape {

    public Circle() {
        super("Circle");
        shapeType = ShapeType.Circle;
    }

    @Override
    public void draw() {
        System.out.println("Draw a Circle with a ShapeName: " + shapeName);
    }
}
