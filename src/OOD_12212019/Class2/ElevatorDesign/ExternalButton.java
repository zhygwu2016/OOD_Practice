package Class2.ElevatorDesign;

import static Class2.ElevatorDesign.Direction.DOWN;
import static Class2.ElevatorDesign.Direction.UP;

/**
 * Created by FLK on 9/22/18.
 */
public class ExternalButton extends Button implements ElevatorEventListener{

    private final ElevatorSystem elevatorSystem;

    public ExternalButton(final String id, final int levelNumber, final ElevatorSystem elevatorSystem) {
        super(id, levelNumber);
        this.elevatorSystem = elevatorSystem;
    }

    public void sendUpRequest() {
        elevatorSystem.handleRequest(new ExternalRequest(levelNumber,UP));
    }

    public void sendDownRequest(){
        elevatorSystem.handleRequest(new ExternalRequest(levelNumber,DOWN));
    }

    public ElevatorSystem getElevatorSystem(){
        return elevatorSystem;
    }

    @Override
    public void onElevatorStop() {
        System.out.println("Allow to add users here");
    }

    @Override
    public void calLevelNumber(){
        super.calLevelNumber();
    }
}
