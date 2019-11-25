package ParkingLotDesign;

/**
 * Created by Frank Fang on 8/25/18.
 */
public enum VehicleType {

    MotoCycle("MotoCycle",1),

    Compact("Compact",2),

    Bus("Bus",3);

    private final String vehicleType;
    private final int size;

    VehicleType(final String vehicleType, final int size){
        this.vehicleType = vehicleType;
        this.size = size;
    }

    public String toString(){
        return vehicleType;
    }

    public int getSize(){
        return size;
    }
}


