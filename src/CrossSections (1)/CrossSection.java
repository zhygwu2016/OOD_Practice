package CrossSections;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class CrossSection{

    //It's CrossSectionType
    private final CrossSectionType crossSectionType;

    //CrossSection Contains roads, Use List<IRoad> make it general enough to handle different kinds of roads
    private final List<IRoad> roadImplements;

    //PriorityQueue handle the Order, first come first go
    private final PriorityQueue<Car> interSection;

    private final String id;

    public CrossSection(final String id, final CrossSectionType crossSectionType){

        this.id = id;

        this.crossSectionType = crossSectionType;

        roadImplements = new ArrayList<IRoad>(crossSectionType.getRoadNum());

        //Initiate the heap
        interSection = new PriorityQueue<Car>(crossSectionType.getRoadNum(), new Comparator<Car>() {

            //Min heap
            @Override
            public int compare(Car c1, Car c2) {
                if(c1.getArriveTime() == c2.getArriveTime()) return 0;

                return c1.getArriveTime() > c2.getArriveTime() ? 1 : -1;
            }
        });

        //Initiate the roads
        initRoad();
    }

    //Initiate the roads
    private void initRoad(){
        final int roadNum = crossSectionType.getRoadNum();

        for(int i = 0; i < roadNum; i++){
            roadImplements.add(new NormalRoad("" + i));
        }
    }

    //Pass a car, or a car drive through the cross section
    public Car passCar() {

        //Offer cars from the road
        for(IRoad roadImplement : roadImplements){
            if(roadImplement.getCars().peek() != null) interSection.offer(roadImplement.passCar());
        }

        //Then pop the car from the cross section
        final Car car = interSection.poll();

        //After car passes the cross section, it left the road, and should set the road to be null
        car.setRoad(null);

        return car;
    }

    //Tell whether the cross section is empty or not
    public boolean isEmpty() {
        for(IRoad roadImplement : roadImplements){
            if (!roadImplement.isEmpty()) return false;
        }

        return interSection.isEmpty();
    }

    //Getters
    public List<IRoad> getRoadImplements(){
        return roadImplements;
    }

    public IRoad getRoad(final int index){
        if(index >= roadImplements.size()) return null;
        return roadImplements.get(index);
    }
}
