package CrossSections;

import java.util.Queue;

/**
 * Created by Frank Fang on 9/8/18.
 */
//This is the interface that is the abstract of the class which can addCar, passCar
public interface IRoad {

    void add(Car car);

    Car passCar();

    boolean isEmpty();

    int getCarNum();

    Queue<Car> getCars();
}
