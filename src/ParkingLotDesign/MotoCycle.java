package ParkingLotDesign;

/**
 * Created by FLK on 4/14/18.
 */
public class MotoCycle extends Vehicle{

    public MotoCycle(final String id){
        super(id);
        vehicleType = VehicleType.MotoCycle;
        size = vehicleType.getValue();
    }

    @Override
    protected boolean park(final ParkingSpot parkingSpot) {
        if(!canPark(parkingSpot)) return false;

        this.parkingSpot = parkingSpot;

        parkingSpot.vehiclePark(this);

        return true;
    }
}