package ParkingLotDesign;

/**
 * Created by FLK on 4/14/18.
 */
public class ParkingLevel implements IParkingSpace{

    private final int motoNum;
    private final int compactNum;
    private final int busNum;
    private final int size;
    private final String id;

    private final ParkingGarage parkingGarage;
    private final ParkingSpot[] motoSpots;
    private final ParkingSpot[] compactSpots;
    private final ParkingSpot[] busSpots;

    private int emptyMoto;
    private int emptyCompact;
    private int emptyBus;

    public ParkingLevel(final String id, final int motoNum, final int compactNum, final int busNum, final ParkingGarage parkingGarage){
        this.id = id;
        this.motoNum = motoNum;
        this.compactNum = compactNum;
        this.busNum = busNum;
        size = motoNum + compactNum + busNum;
        emptyMoto = motoNum;
        emptyCompact = compactNum;
        emptyBus = busNum;

        this.parkingGarage = parkingGarage;
        motoSpots = new ParkingSpot[motoNum];
        compactSpots = new ParkingSpot[compactNum];
        busSpots = new ParkingSpot[busNum];

        for(int i = 0; i < size; i++){
            if (i < motoNum) {
                motoSpots[i] = new ParkingSpot(id + i,VehicleType.MotoCycle,this);
            } else if(i >= motoNum && i < motoNum + compactNum){
                compactSpots[i - motoNum] = new ParkingSpot(id + i,VehicleType.Compact,this);
            } else {
                busSpots[i - motoNum - compactNum] = new ParkingSpot(id + i, VehicleType.Bus,this);
            }
        }

    }

    public boolean canPark(Vehicle vehicle) {
        if(vehicle instanceof MotoCycle){
            return emptyMoto > 0;
        } else if (vehicle instanceof Compact){
            return emptyCompact > 0;
        }  else {
            return  emptyBus > 0;
        }
    }

    public int getEmptySpotNum() {
        return emptyBus + emptyMoto + emptyCompact;
    }

    public int getSize() {
        return size;
    }

    public boolean parkVehicle(Vehicle vehicle){
        if(!canPark(vehicle)) return false;

        if(vehicle instanceof MotoCycle){
            park(vehicle,motoSpots);
            emptyMoto--;
        } else if (vehicle instanceof Compact){
            park(vehicle,compactSpots);
            emptyCompact--;
        } else {
            park(vehicle,busSpots);
            emptyBus--;
        }

        return true;
    }

    private void park(Vehicle vehicle, ParkingSpot[] parkingSpots){
        for (ParkingSpot parkingSpot : parkingSpots){
            if(parkingSpot.isEmpty()){
                parkingSpot.vehiclePark(vehicle);
                vehicle.park(parkingSpot);
            }
        }
    }

    public void vehicleLeavePark(Vehicle vehicle){
        if(vehicle.getVehicleType() == VehicleType.MotoCycle){
            emptyMoto++;
        } else if(vehicle.getVehicleType() == VehicleType.Compact){
            emptyCompact++;
        } else {
            emptyBus++;
        }
        parkingGarage.vehicleLeavePark();
    }


}
