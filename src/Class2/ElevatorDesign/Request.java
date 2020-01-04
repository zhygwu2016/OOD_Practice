package Class2.ElevatorDesign;

/**
 * Created by FLK on 9/22/18.
 */
public class Request {

    protected final int levelNumber;

    public Request(final int levelNumber){
        this.levelNumber = levelNumber;
    }

    public int getLevelNumber(){
        return levelNumber;
    }
}
