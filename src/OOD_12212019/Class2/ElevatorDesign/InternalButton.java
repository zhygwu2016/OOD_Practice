package Class2.ElevatorDesign;

/**
 * Created by FLK on 9/22/18.
 */
public class InternalButton extends Button {

    private final Elevator elevator;

    public InternalButton(final String id, final int levelNumber, final Elevator elevator) {
        super(id, levelNumber);
        this.elevator = elevator;
    }

    public void sendRequest() {
        elevator.handleInternalRequest(new Request(levelNumber));
    }

    public Elevator getElevator(){
        return elevator;
    }
}
