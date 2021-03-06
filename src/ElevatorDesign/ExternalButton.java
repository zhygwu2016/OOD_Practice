package ElevatorDesign;

import static ElevatorDesign.Direction.DOWN;
import static ElevatorDesign.Direction.UP;

/**
 * Created by FLK on 2019-04-06.
 */
public class ExternalButton extends Button implements ElevatorEventListener{

    private final ElevatorSystem elevatorSystem;

    public ExternalButton(final String id, final int levelNumber, final ElevatorSystem elevatorSystem) {
        super(id, levelNumber);
        this.elevatorSystem = elevatorSystem;
    }

    public void sendUpRequest(){
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
        System.out.println("Allowed to add user when evelator stoped");
    }
}
