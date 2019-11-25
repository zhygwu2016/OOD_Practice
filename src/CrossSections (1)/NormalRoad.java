package CrossSections;

import java.util.LinkedList;
import java.util.Queue;


public class NormalRoad implements IRoad {

    //The best data structure here is Queue, since it is first in first out
    private final Queue<Car> cars;


    private final String name;


    public NormalRoad(final String name){
        this.name = name;
        cars = new LinkedList<Car>();
    }

    @Override
    public int getCarNum(){
        return cars.size();
    }

    @Override
    public Queue<Car> getCars(){
        return cars;
    }

    //Implement all methods in the interface
    @Override
    public void add(Car car) {
        cars.offer(car);
    }

    @Override
    public Car passCar() {
        return cars.poll();
    }

    @Override
    public boolean isEmpty() {
        return cars.isEmpty();
    }
}
