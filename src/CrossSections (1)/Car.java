package CrossSections;

public class Car {

    //Fields
    private final String vin;
    private long arriveTime;

    //Contains the interface
    private IRoad road;

    public Car(final String vin, final long arriveTime){
        this.vin = vin;
        this.arriveTime = arriveTime;
    }

    //Getters
    public String getVin(){
        return vin;
    }

    public long getArriveTime(){
        return arriveTime;
    }

    //Decouple, those method should be general enough to handle all types of roads
    public void setRoad(IRoad road){
        this.road = road;
    }

    public IRoad getRoad(){
        return road;
    }

}
