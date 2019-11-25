package ObserverDesignPattern;

/**
 * Created by Frank Fang on 8/25/18.
 */
public class IStateWatcherA implements IStateObserver{

    public IStateWatcherA(){
        System.out.println("This is StateWatcherA");
    }

    @Override
    public void onStateChange(){
        System.out.println("StateWatchA watches StateChange");
        System.out.println("StateWatchA sell the stock");
    }
}
