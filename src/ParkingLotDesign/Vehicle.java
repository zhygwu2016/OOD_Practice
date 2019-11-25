package ParkingLotDesign;

/**
 * Created by FLK on 4/14/18.
 */
public abstract class Vehicle {

    protected final Long enterTime;
    protected Long leaveTime;

    protected VehicleType vehicleType;
    protected String id;
    protected int size;

    protected ParkingSpot parkingSpot;


    public Vehicle(final String id){
        this.id = id;
        enterTime = System.currentTimeMillis();
        leaveTime = null;
        vehicleType = null;
        parkingSpot = null;
        size = 0;
    }


    //How to improve this?
    public Long getEnterTime(){
        return enterTime;
    }

    public Long getLeaveTime(){
        return getLeaveTime();
    }

    public VehicleType getVehicleType(){
        return vehicleType;
    }

    public String getId(){
        return id;
    }

    public int getSize(){
        return size;
    }

    abstract protected boolean park(final ParkingSpot parkingSpot);

    public boolean canPark(final ParkingSpot spot){

        if(!spot.isEmpty() || spot.getSize() < size){
            return false;
        }

        return true;
    }


    protected boolean leavePark(){
        if(parkingSpot == null) return false;

        parkingSpot.vehicleLeavePark();

        parkingSpot = null;

        return true;
    }
}
