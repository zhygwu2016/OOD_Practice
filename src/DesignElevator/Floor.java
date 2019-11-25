package DesignElevator;

import java.util.ArrayList;
import java.util.List;

public class Floor implements ElevatorEventListener{

    private final int floorNum;

    private final List<Elevator> elevators;

    private final List<User> users;

    private final List<FloorEventListener> floorEventListeners;

    private boolean isRequestUp;

    private boolean isRequestDown;

    public Floor(final int floorNum){
        this.floorNum = floorNum;
        elevators = new ArrayList<Elevator>();
        users = new ArrayList<User>();
        floorEventListeners = new ArrayList<FloorEventListener>();
    }

    public int getFloorNum() {
        return floorNum;
    }

    public boolean isRequestUp(){
        return isRequestUp;
    }

    public boolean isRequestDown(){
        return isRequestDown;
    }

    public void setRequestUp(){
        isRequestUp = true;
        notifyListener();
    }

    public void setRequestDown(){
        isRequestDown = true;
        notifyListener();

    }

    public void addFloorEventListener(Elevator elevator){
        floorEventListeners.add(elevator);
    }

    public void addFloorEventListener(List<Elevator> elevators){
        floorEventListeners.addAll(elevators);
    }

    public void notifyListener(){
        for (FloorEventListener floorEventListener : floorEventListeners){
            floorEventListener.onRequest(this);
        }
    }

    public void setElevatorStop(final Elevator elevator){
        elevator.stopElevator();
    }

    public void runElevatorDown(final Elevator elevator){
        elevator.moveDown();
    }

    public void runElevatorUp(final Elevator elevator){
        elevator.moveUp();
    }

    public boolean addUser(final Elevator elevator, Direction direction){

        for(User user : users){
            if(user.getDirection() == direction){
                elevator.addUser(user);
                users.remove(user);
            }
        }
        return true;
    }

    @Override
    public void onElevatorStop(final Elevator elevator) {
        if(elevator.getDirection() == Direction.Down && elevator.getCurrentFloor().getFloorNum() == floorNum){
            setElevatorStop(elevator);
            addUser(elevator, Direction.Down);
            runElevatorDown(elevator);
            isRequestDown = false;
        }

        if(elevator.getDirection() == Direction.Up && elevator.getCurrentFloor().getFloorNum() == floorNum){
            setElevatorStop(elevator);
            addUser(elevator,Direction.Up);
            runElevatorUp(elevator);
            isRequestUp = false;
        }
    }
}
