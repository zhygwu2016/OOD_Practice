package CrossSections;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

/**
 * Created by Frank Fang on 9/8/18.
 */
public class CrossSection {

    //It's CrossSectionType
    private final CrossSectionType crossSectionType;

    //CrossSection Contains roads,Use List<IRoad> make it general enough to handle different kinds of roads
    private final List<IRoad> roadImplements;

    //Data Structure to handle the order, first come first go
    private final PriorityQueue<Car> interSection;


    //Id
    private final String id;

    public CrossSection(final String id, final CrossSectionType crossSectionType){
        this.id = id;

        this.crossSectionType = crossSectionType;

        roadImplements = new ArrayList<IRoad>(crossSectionType.getRoadNum());

        //Initiate Min Heap
        interSection = new PriorityQueue<Car>(crossSectionType.getRoadNum(), new Comparator<Car>() {
            @Override
            public int compare(Car c1, Car c2) {
                if (c1.getArriveTime() == c2.getArriveTime()) return 0;

                return c1.getArriveTime() > c2.getArriveTime() ? 1 : -1;
                //c1.getArriveTime() - c2.getArriveTime();
            }
        });

        //Initiate the roads
        initRoad();
    }

    //Initiate roads
    private void initRoad(){
        final int roadNum = crossSectionType.getRoadNum();

        for (int i = 0; i < roadNum; i++){
            roadImplements.add(new NormalRoad("" + i));
        }
    }

    //Pass a car, or car from the cross section
    public Car passCar(){

        //Offer cars from the road
        for (IRoad road : roadImplements){
            if (road.getCars().peek() != null) interSection.offer(road.passCar());
        }

        //Then pop the car from cross section
        final Car car = interSection.poll();

        //After car passes the cross section, its road should become null
        car.setRoad(null);

        return car;
    }

    //Tell whether the cross section is empty or not
    public boolean isEmpty(){
        //Check all roads in this scetion are empty or not
        for (IRoad road : roadImplements){
            if (!road.isEmpty()) return false;
        }

        //check the priorityQueue is empty or not
        return interSection.isEmpty();
    }

    //Getter
    public List<IRoad> getRoadImplements(){
        return roadImplements;
    }

    public IRoad getRoad(final int index){
        if (index >= roadImplements.size()) return null;
        return roadImplements.get(index);
    }

}
