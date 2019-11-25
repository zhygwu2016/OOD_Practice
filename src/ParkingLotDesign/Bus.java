package ParkingLotDesign;

/**
 * Created by FLK on 4/14/18.
 */
public class Bus extends Vehicle{


    public Bus(final String id){
        super(id);
        vehicleType = VehicleType.Bus;
        size = vehicleType.getValue();
    }

    protected boolean park(ParkingSpot parkingSpot) {
        if(!canPark(parkingSpot)) return false;

        this.parkingSpot = parkingSpot;

        parkingSpot.vehiclePark(this);

        return true;
    }
}
