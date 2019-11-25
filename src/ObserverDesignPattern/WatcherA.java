package ObserverDesignPattern;

/**
 * Created by Frank Fang on 4/21/18.
 */
public class WatcherA implements IStateObserver {

    public WatcherA(){
        System.out.println("This is StateWatcherA");
    }

    public void onStateChange() {
        System.out.println("StateWatcherA watches StateChange");
    }
}
