package FactoryDesignPattern;


public abstract class Shape {

    protected final String shapeName;

    protected ShapeType shapeType;

    public Shape(String shapeName){
        this.shapeName = shapeName;
    }

    abstract void draw();

    protected String getShapeName() {
        return shapeName;
    }

    protected ShapeType getShapeType(){
        return  shapeType;
    }
}
