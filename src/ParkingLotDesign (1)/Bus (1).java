package ParkingLotDesign;

/**
 * Created by Frank Fang on 8/25/18.
 */
public class Bus extends Vehicle{

    public Bus(final String id){
        super(id);
        vehicleType = VehicleType.Bus;
        size = vehicleType.getSize();
    }
}
