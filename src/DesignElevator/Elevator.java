package DesignElevator;

import com.sun.istack.internal.NotNull;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

import static DesignElevator.ElevatorSystem.MAX_FLOOR;

public class Elevator implements FloorEventListener{

    private final String id;

    private final int capacity;

    private final PriorityQueue<Floor> upFloor;

    private final PriorityQueue<Floor> downFloor;

    private Direction direction;

    private Floor currentFloor;

    private List<ElevatorEventListener> elevatorEventListeners;

    private List<User> users;

    public Elevator(final String id, final int capacity){
        this.id = id;
        this.capacity = capacity;
        direction = Direction.Stop;
        elevatorEventListeners = new ArrayList<ElevatorEventListener>();
        users = new ArrayList<User>();

        upFloor = new PriorityQueue<Floor>(MAX_FLOOR,new Comparator<Floor>() {
            @Override
            public int compare(Floor o1, Floor o2) {
                if(o1 == o2) return 0;

                return o2.getFloorNum() > o1.getFloorNum() ? 1 : -1;
            }
        });

        downFloor = new PriorityQueue<Floor>(MAX_FLOOR, new Comparator<Floor>() {
            @Override
            public int compare(Floor o1, Floor o2) {
                if(o1.getFloorNum() == o2.getFloorNum()) return 0;

                return  o1.getFloorNum() > o2.getFloorNum() ? 1 : -1;
            }
        });

        currentFloor = null;
    }

    public String getId(){
        return this.id;
    }

    public Direction getDirection(){
        return this.direction;
    }

    public Floor getCurrentFloor(){
        return this.currentFloor;
    }

    public boolean addFloor(@NotNull Floor floor){

        if(floor.getFloorNum() == currentFloor.getFloorNum()){
            return false;
        } else if(floor.getFloorNum() > currentFloor.getFloorNum()){
            upFloor.offer(floor);
        } else {
            downFloor.offer(floor);
        }

        return true;
    }

    public void moveUp(){
        direction = Direction.Up;

        while(!upFloor.isEmpty()){
            currentFloor = upFloor.poll();
            notifyEventListner();
        }

        direction = Direction.Stop;
    }

    public void moveDown(){
        direction = Direction.Down;
        while(!downFloor.isEmpty()){
            currentFloor = downFloor.poll();
            notifyEventListner();
        }

        direction = Direction.Stop;
    }

    public boolean addUser(User user) {
        if(users.size() > capacity) return false;

        users.add(user);
        return true;
    }

    public void addElevatorEventListener(Floor floor){
        elevatorEventListeners.add(floor);
    }

    public void addElevatorEventListener(List<Floor> floors){
        elevatorEventListeners.addAll(floors);
    }

    public void stopElevator(){
        direction = Direction.Stop;
    }

    private void notifyEventListner(){

        for (ElevatorEventListener elevatorEventListener : elevatorEventListeners){
            elevatorEventListener.onElevatorStop(this);
        }
    }

    @Override
    public void onRequest(final Floor floor) {
        if (floor.isRequestUp()){
            if ((direction == Direction.Up || direction == Direction.Stop)
                    && floor.getFloorNum() > currentFloor.getFloorNum()){
                upFloor.offer(floor);
                moveUp();
            }
        }

        if(floor.isRequestDown()){
            if((direction == Direction.Down || direction == Direction.Stop)
                    && floor.getFloorNum() < currentFloor.getFloorNum()){
                downFloor.offer(floor);
                moveDown();
            }
        }
    }
}
