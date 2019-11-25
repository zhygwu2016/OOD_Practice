package DesignElevator;

public enum Direction {

    Up("Up"),

    Down("Down"),

    Stop("Stop");

    private String direction;

    Direction(final String direction){
        this.direction = direction;
    }

    public String toString(){
        return direction;
    }


}
