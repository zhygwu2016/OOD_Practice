package DesignElevator;

import java.util.ArrayList;
import java.util.List;

public class ElevatorSystem {
    public static final int MAX_FLOOR = 15;
    public static final int ElEVATOR_CAPACITY = 20;
    public static final int ELEVATOR_NUM = 4;

    private final List<Floor> floors;
    private final List<Elevator> elevators;

    public ElevatorSystem(){
        floors = new ArrayList<Floor>(MAX_FLOOR);
        elevators = new ArrayList<Elevator>(ELEVATOR_NUM);

        initFloor();
        initElevator();

        addFloorEventListener();
        addElevatorEventListener();
    }

    private void initFloor(){
        for (int i = 0; i < MAX_FLOOR; i++){
            floors.add(new Floor(i + 1));
        }
    }

    private void initElevator(){
        for (int i = 0; i < ELEVATOR_NUM; i++){
            final Elevator elevator = new Elevator("" + i + 1, ElEVATOR_CAPACITY);
        }
    }

    private void addElevatorEventListener(){
        for(Elevator elevator : elevators){
            elevator.addElevatorEventListener(floors);
        }
    }

    private void addFloorEventListener(){
        for (Floor floor : floors){
            floor.addFloorEventListener(elevators);
        }
    }


}
