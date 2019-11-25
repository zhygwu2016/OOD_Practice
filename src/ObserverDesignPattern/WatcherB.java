package ObserverDesignPattern;

/**
 * Created by Frank Fang on 4/21/18.
 */
public class WatcherB implements IStateObserver {

    public WatcherB(){
        System.out.println("This is StateWatcherB");
    }

    public void onStateChange() {
        System.out.println("StateWatcherB watches StateChange");
    }
}
