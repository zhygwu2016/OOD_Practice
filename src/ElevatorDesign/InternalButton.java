package ElevatorDesign;

/**
 * Created by FLK on 2019-04-06.
 */
public class InternalButton extends Button{

    private final Elevator elevator;

    public InternalButton(final String id, int levelNumber, final Elevator elevator) {
        super(id, levelNumber);
        this.elevator = elevator;
    }

    public void sendRequest(){
        elevator.handleInternalRequest(new Request(levelNumber));
    }
}
