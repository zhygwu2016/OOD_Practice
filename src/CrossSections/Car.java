package CrossSections;

/**
 * Created by Frank Fang on 9/8/18.
 */
public class Car {

    //Field
    private final long arriveTime;
    private final String vin;

    //Contains the interface
    private IRoad road;

    public Car(final String vin, final long arriveTime){
        this.vin = vin;
        this.arriveTime = arriveTime;
    }

    //Getter
    public String getVin(){
        return vin;
    }

    public long getArriveTime(){
        return arriveTime;
    }

    //Decouple, those method should be general enough to handle all types pf roads
    public void setRoad(IRoad road){
        this.road = road;
    }

    public IRoad getRoad(){
        return road;
    }

}
