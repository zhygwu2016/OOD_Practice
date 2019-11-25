package FactoryDesignPattern;


public class ShapeFactory {

    public static Shape createShape(ShapeType shapeType){

        if(shapeType == ShapeType.Triangle){
            return new Triangle();
        } else if (shapeType == ShapeType.Circle){
            return  new Circle();
        }
        else if (shapeType == ShapeType.Rectangle){
            return new Rectangle();
        }

        return null;
    }
}
