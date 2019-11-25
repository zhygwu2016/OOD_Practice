package ParkingLotDesign;

/**
 * Created by Frank Fang on 8/25/18.
 */
public class MotoCycle extends Vehicle {

    public MotoCycle(final String id){
        super(id);
        vehicleType = VehicleType.MotoCycle;
        size = vehicleType.getSize();
    }
}
