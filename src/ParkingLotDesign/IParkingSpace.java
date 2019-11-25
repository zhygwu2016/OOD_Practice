package ParkingLotDesign;

/**
 * Created by FLK on 4/14/18.
 */
public interface IParkingSpace {

    boolean canPark(Vehicle vehicle);

    int getEmptySpotNum();

    int getSize();
}
