package FactoryDesignPattern;


public enum ShapeType {

    Triangle("Triangle"),

    Circle("Circle"),

    Rectangle("Rectangle");

    private String shapeType;

    ShapeType(String shapeType){
        this.shapeType = shapeType;
    }

    public String toString(){
        return shapeType;
    }
}
