package ElevatorDesign;

/**
 * Created by FLK on 2019-04-06.
 */
public class ExternalRequest extends Request {

    private final Direction direction;

    public ExternalRequest(final int levelNumber,final Direction direction) {
        super(levelNumber);
        this.direction = direction;
    }

    public Direction getDirection(){
        return direction;
    }
}
