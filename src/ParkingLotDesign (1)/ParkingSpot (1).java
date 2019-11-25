package ParkingLotDesign;

/**
 * Created by Frank Fang on 8/25/18.
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
        size = vehicleType.getSize();
        this.parkingLevel = parkingLevel;
    }

    public String getId(){
        return id;
    }

    public VehicleType getVehicleType(){
        return vehicleType;
    }

    public Vehicle getParkingVehicle(){
        return parkingVehicle;
    }

    public boolean isEmpty(){
        return parkingVehicle == null;
    }


    @Override
    public boolean canPark(Vehicle vehicle) {
        if(!isEmpty() || vehicle.size > size) return false;
        return true;
    }

    public boolean vehiclePark(final Vehicle vehicle){
        if(!canPark(vehicle)) return false;

        parkingVehicle = vehicle;
        return true;
    }

    public void vehicleLeavePark(){
        parkingVehicle = null;
        parkingLevel.vehicleLeavePark(parkingVehicle);
    }

    @Override
    public int getEmptySpotNum() {
        return parkingVehicle == null ? 1 : 0;
    }



    @Override
    public int getSize() {
        return 1;
    }
}
