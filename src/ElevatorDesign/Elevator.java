package ElevatorDesign;

import com.oracle.tools.packager.Log;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

import static ElevatorDesign.Direction.STOP;
import static ElevatorDesign.ElevatorSystem.MAX_FLOOR;

/**
 * Created by FLK on 2019-04-06.
 */
public class   Elevator {

    //The id of the Elevator
    private final String id;

    //The capacity of the elevator
    private final int capacity;

    //The task manager for up and down tasks
    private final PriorityQueue<Integer> upTasks;

    private final PriorityQueue<Integer> downTasks;

    //The current running direction
    private Direction currentDirection;

    //The current floor number
    private int currentLevelNumber;

    //The observers of this elevator
    private final List<ElevatorEventListener> elevatorEventListeners;

    //Internal Buttons
    private final List<InternalButton> internalButtons;

    public Elevator(final String id, final int capacity){
        this.id = id;
        this.capacity = capacity;
        currentDirection = Direction.STOP;
        currentLevelNumber = 1;
        elevatorEventListeners = new ArrayList<>();
        internalButtons = new ArrayList<>();

        //Initialize Internal Buttons
        initInternalButtons();

        //For up tasks, we use minHeap here
        upTasks = new PriorityQueue<>(MAX_FLOOR,(i1,i2) -> {
            return i1 - i2;
        });

        //For down tasks, we use maxHeap here
        downTasks  = new PriorityQueue<>(MAX_FLOOR,(i1,i2) -> {
            return i2 - i1;
        });
    }

    //Initialize Internal Buttons
    private void initInternalButtons(){
        for(int i = 1; i <= MAX_FLOOR; i++) {
            internalButtons.add(new InternalButton(id + "-" + i, i,this));
        }
    }

    //Getters
    public String getId(){
        return id;
    }

    public int getCapacity(){
        return capacity;
    }

    public Direction getCurrentDirection(){
        return currentDirection;
    }

    public int getCurrentLevelNumber(){
        return currentLevelNumber;
    }

    //Register Listeners(Optional)
    public void registerListeners(final ElevatorEventListener elevatorEventListener){
        elevatorEventListeners.add(elevatorEventListener);
    }

    //Remove all Listeners(Optional)
    public void removeAllListeners(){
        elevatorEventListeners.clear();
    }

    //Remove specific listeners(Optional)
    public void deregisterListeners(final ElevatorEventListener elevatorEventListener){
        elevatorEventListeners.remove(elevatorEventListener);
    }

    //The method to accept the external of an Elevator(Core)
    public boolean handleExternalRequest(final ExternalRequest externalRequest){
        //Check the request is valid or not first
        if(!checkValid(externalRequest)) {
            return false;
        }

        final int requestLevelNumber = externalRequest.getLevelNumber();

        //The logic to handle up/down request is the following:
        if(externalRequest.getDirection() == Direction.UP && currentDirection == Direction.UP) {
            if(requestLevelNumber > currentLevelNumber) {
                upTasks.offer(requestLevelNumber);
            } else {
                return false;
            }
        } else if(externalRequest.getDirection() == Direction.DOWN && currentDirection == Direction.DOWN) {
            if (requestLevelNumber < currentLevelNumber) {
                downTasks.offer(requestLevelNumber);
            } else {
                return false;
            }
        } else {
            return false;
        }

        return true;
    }

    //    public void handleExternalRequest(final ExternalRequest externalRequest) throws InvalidRequestException{
//        if (!checkValid(externalRequest)) {
//            return;
//        }
//        final int requestLevelNumber = externalRequest.getLevelNumber();
//        if (externalRequest.getDirection() == UP){
//            if (externalRequest.getLevelNumber() > currentLevelNumber){
//                upTasks.offer(requestLevelNumber);
//            } else {
//                throw new InvalidRequestException("This Up Request is Invalid");
//            }
//        } else if(externalRequest.getDirection() == DOWN){
//            if (externalRequest.getLevelNumber() < currentLevelNumber){
//                downTasks.offer(requestLevelNumber);
//            } else {
//                throw new InvalidRequestException("This Up Request is Invalid");
//            }
//        }
//    }

    //The method to handle internal request (Core)
    public  boolean handleInternalRequest(final Request request){

        if(request instanceof ExternalRequest ) return false;

        if(!checkValid(request)) return false;

        final int requestLevelNumber = request.getLevelNumber();
        //Handle the task according to the currentLevel
        if(requestLevelNumber > currentLevelNumber) {
            upTasks.offer(requestLevelNumber);
        } else {
            downTasks.add(requestLevelNumber);
        }

        return true;
    }

    //(Core)
    private boolean checkValid(final Request request){
        if(request == null) return false;

        final int requestLevelNumber = request.getLevelNumber();

        if(requestLevelNumber < 1 || requestLevelNumber > MAX_FLOOR) {
            Log.info("Elevator: This request level is out of range");
            return false;
        } else if (requestLevelNumber == currentLevelNumber
                || upTasks.contains(requestLevelNumber)
                || downTasks.contains(requestLevelNumber)) {
            Log.info("Elevator: The request is duplicated");
            return false;
        }

        return true;
    }

    //Elevator Move up
    public void moveUp(){
        currentDirection = Direction.UP;

        while(!upTasks.isEmpty()){
            currentLevelNumber = upTasks.poll();
        }

        currentDirection = Direction.STOP;
    }

    //Elevator Move Down
    public void moveDown(){
        currentDirection = Direction.DOWN;

        while(!downTasks.isEmpty()) {
            currentLevelNumber = downTasks.poll();
        }

        currentDirection = Direction.STOP;
    }

    public void run(){
        if(currentDirection == STOP){
            while (!upTasks.isEmpty()) {
                moveUp();
            }

            while(!downTasks.isEmpty()){
                moveDown();
            }
        }
    }

}
