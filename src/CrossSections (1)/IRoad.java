package CrossSections;

import java.util.Queue;

//This is the interface that is the abstract of the classes which can addCar, passCar
public interface IRoad {

    void add(Car car);

    Car passCar();

    boolean isEmpty();

    Queue<Car> getCars();

    int getCarNum();
}
