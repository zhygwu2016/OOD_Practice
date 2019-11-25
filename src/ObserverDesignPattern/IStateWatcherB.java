package ObserverDesignPattern;


public class IStateWatcherB implements IStateObserver {

    public IStateWatcherB(){
        System.out.println("This is StateWatcherB");
    }

    @Override
    public void onStateChange() {
        System.out.println("StateWatcherB watches StateChange");
    }
}
