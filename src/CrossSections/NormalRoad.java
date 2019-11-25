package CrossSections;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by Frank Fang on 9/8/18.
 */
public class NormalRoad implements IRoad{

    //The best data structure here is Queue, since it is FIFO
    private final Queue<Car> cars;

    private final String name;//Id

    public NormalRoad(final String name){
        this.name = name;
        cars = new LinkedList<Car>();
    }


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

    @Override
    public int getCarNum() {
        return cars.size();
    }

    @Override
    public Queue<Car> getCars() {
        return cars;
    }
}
