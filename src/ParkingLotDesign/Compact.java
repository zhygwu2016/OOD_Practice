package ParkingLotDesign;

/**
 * Created by FLK on 4/14/18.
 */
public class Compact extends Vehicle {

    public Compact(final String id){
        super(id);
        vehicleType = VehicleType.Compact;
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
