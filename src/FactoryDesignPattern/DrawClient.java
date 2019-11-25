package FactoryDesignPattern;


public class DrawClient {

    //No Need to change anything here if we add more shapes
    public void draw(ShapeType shapeType){
        final Shape shape = ShapeFactory.createShape(shapeType);
        shape.draw();
    }
}
