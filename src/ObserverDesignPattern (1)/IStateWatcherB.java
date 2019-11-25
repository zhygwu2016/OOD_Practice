package ObserverDesignPattern;

/**
 * Created by Frank Fang on 8/25/18.
 */
public class IStateWatcherB implements IStateObserver{
    public IStateWatcherB(){
        System.out.println("THis is StateWatcherB");
    }

    @Override
    public void onStateChange(){
        System.out.println("StateWatcherB watches the stateChange");
        System.out.println("StateWatcherB buy more stock");
    }
}
