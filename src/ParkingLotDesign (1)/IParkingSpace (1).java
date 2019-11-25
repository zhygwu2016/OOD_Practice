package ParkingLotDesign;

/**
 * Created by Frank Fang on 8/25/18.
 */
public interface IParkingSpace {

    //Whether the vehicle can park
    boolean canPark(Vehicle vehicle);

    //Return the number of empty parking spot
    int getEmptySpotNum();

    // This representer for the numbers of parkingSpot
    int getSize();
}
