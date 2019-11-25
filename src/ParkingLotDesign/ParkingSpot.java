package ParkingLotDesign;

/**
 * Created by FLK on 4/14/18.
 */
public class ParkingSpot implements IParkingSpace {

    private final String id;
    private Vehicle parkingVehicle;
    private final int size;
    private VehicleType vehicleType;

    private final ParkingLevel parkingLevel;


    public ParkingSpot(final String id, final VehicleType vehicleType, final ParkingLevel parkingLevel){
        this.id = id;
        this.vehicleType = vehicleType;
        parkingVehicle = null;
        size = vehicleType.getValue();
        this.parkingLevel = parkingLevel;
    }

    public String getId(){
        return id;
    }

    public int getSize(){
        return size;
    }

    public Vehicle getVehicle(){
        return parkingVehicle;
    }

    public VehicleType getVehicleType(){
        return vehicleType;
    }

    public boolean isEmpty(){
        return parkingVehicle == null;
    }

    public boolean canPark(final Vehicle vehicle){
        if(!isEmpty() || vehicle.getSize() > size) return false;

        return true;
    }

    public boolean vehiclePark(final Vehicle vehicle){
        if(!canPark(vehicle)) return false;

        parkingVehicle = vehicle;
        return true;
    }

    public int getEmptySpotNum() {
        return parkingVehicle == null ? 1 : 0;
    }

    public void vehicleLeavePark(){
        parkingVehicle = null;
        parkingLevel.vehicleLeavePark(parkingVehicle);
    }
}
