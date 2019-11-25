package ParkingLotDesign;

/**
 * Created by Frank Fang on 8/25/18.
 */
public class ParkingLevel implements IParkingSpace {

    private final int motoNum;
    private final int compactNum;
    private final int busNum;
    private final int size;
    private final String id;

    private final ParkingGarage parkingGarage;
    private final ParkingSpot[] motoSpots;
    private final ParkingSpot[] compactSpot;
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
        compactSpot = new ParkingSpot[compactNum];
        busSpots = new ParkingSpot[busNum];

        for(int i = 0; i < size; i++){
            if (i < motoNum) {
                motoSpots[i] = new ParkingSpot(id + i,VehicleType.MotoCycle,this);
            } else if(i >= motoNum && i < motoNum + compactNum){
                compactSpot[i - motoNum] = new ParkingSpot(id + i,VehicleType.Compact,this);
            } else {
                busSpots[i - motoNum - compactNum] = new ParkingSpot(id + i, VehicleType.Bus,this);
            }
        }

    }


    @Override
    public boolean canPark(Vehicle vehicle) {
        if(vehicle instanceof MotoCycle){
            return emptyMoto > 0;
        } else if (vehicle instanceof Compact){
            return emptyCompact > 0;
        } else {
            return emptyBus > 0;
        }
    }

    @Override
    public int getEmptySpotNum() {
        return emptyBus + emptyCompact + emptyMoto;
    }

    @Override
    public int getSize() {
        return size;
    }

    public boolean park(Vehicle vehicle){

        final ParkingSpot[] parkingSpots;

        if(vehicle instanceof MotoCycle){
            parkingSpots = motoSpots;
        } else if (vehicle instanceof Compact) {
            parkingSpots = compactSpot;
        } else {
            parkingSpots = busSpots;
        }

        for (ParkingSpot parkingSpot : parkingSpots){
            if (parkingSpot.isEmpty()){
                parkingSpot.vehiclePark(vehicle);
                vehicle.park(parkingSpot);
                return true;
            }
        }
        return false;
    }

    public void vehicleLeavePark(Vehicle vehicle){

        if (vehicle == null) return;
        if (vehicle instanceof MotoCycle){
            emptyMoto++;
        } else if (vehicle instanceof Compact) {
            emptyCompact++;
        } else {
            emptyBus++;
        }
        parkingGarage.vehicleLeavePark();
    }
}
