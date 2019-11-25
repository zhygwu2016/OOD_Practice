package ParkingLotDesign;

/**
 * Created by Frank Fang on 8/25/18.
 */
public class Compact extends Vehicle {
    public Compact(final String id){
        super(id);
        vehicleType = VehicleType.Compact;
        size = vehicleType.getSize();
    }
}
