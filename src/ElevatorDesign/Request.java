package ElevatorDesign;

/**
 * Created by FLK on 2019-04-06.
 */
public class Request {

    protected final int levelNumber;

    public Request(final int levelNumber) {
        this.levelNumber = levelNumber;
    }

    public int getLevelNumber(){
        return levelNumber;
    }
}
