package ParkingLotDesign;

/**
 * Created by Frank Fang on 8/25/18.
 */
public class ParkingGarage implements IParkingSpace{

    private final String id;
    private final int levelNum;
    private final int size;
    private int emptySpot;

    private final ParkingLevel[] parkingLevels;

    public final static int MOTO_NUMBER_IN_LEVEL = 20;
    public final static int COMPACT_NUMBER_IN_LEVEL = 100;
    public final static int BUS_NUMBER_IN_LEVEL = 10;

    public ParkingGarage(final String id, final int levelNum){
        this.id = id;
        this.levelNum = levelNum;

        parkingLevels = new ParkingLevel[levelNum];

        for(int i = 0; i < levelNum; i++){
            parkingLevels[i] = new ParkingLevel("P" + i,MOTO_NUMBER_IN_LEVEL,COMPACT_NUMBER_IN_LEVEL,BUS_NUMBER_IN_LEVEL,this);
        }

        size = levelNum * (MOTO_NUMBER_IN_LEVEL + COMPACT_NUMBER_IN_LEVEL + BUS_NUMBER_IN_LEVEL);
        emptySpot = size;
    }

    @Override
    public boolean canPark(Vehicle vehicle) {

        for (ParkingLevel parkingLevel : parkingLevels){
            if (parkingLevel.canPark(vehicle)) return true;
        }
        return false;
    }

    public  boolean park(final Vehicle vehicle, final int level){
        if (level < 0 || level >= levelNum) return false;
        if(parkingLevels[level].canPark(vehicle)){
            parkingLevels[level].park(vehicle);
            emptySpot--;
            return true;
        }

        return false;
    }

    public void vehicleLeavePark(){
        emptySpot++;
    }

    @Override
    public int getEmptySpotNum() {
        return emptySpot;
    }

    @Override
    public int getSize() {
        return size;
    }
}
