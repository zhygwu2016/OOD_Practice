package ElevatorDesign;

/**
 * Created by FLK on 2019-04-06.
 */
public abstract class Button {
    private final String id;

    protected final int levelNumber;

    public Button(final String id, final int levelNumber){
        this.id = id;
        this.levelNumber = levelNumber;
    }
}
