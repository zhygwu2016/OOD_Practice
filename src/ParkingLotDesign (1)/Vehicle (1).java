package ParkingLotDesign;

/**
 * Created by Frank Fang on 8/25/18.
 */
public abstract class Vehicle {



    protected String id;
    protected int size;
    protected VehicleType vehicleType;

    protected ParkingSpot parkingSpot;

    public Vehicle(final String id){
        this.id = id;
        this.vehicleType = null;
        parkingSpot = null;
        size = 0;
    }

    public String getId(){
        return this.id;
    }

    public VehicleType getVehicleType(){
        return vehicleType;
    }

    protected boolean park(final ParkingSpot parkingSpot){
        if(parkingSpot == null || !parkingSpot.isEmpty()){
            return false;
        }

        parkingSpot.vehiclePark(this);

        return true;
    }

    protected boolean leavePark(){
        if(parkingSpot == null) return false;

        parkingSpot.vehicleLeavePark();

        parkingSpot = null;

        return true;
    }

}
