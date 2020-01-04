package Class1.ObseverDesignPattern1;

public class IStateWatcherA implements IStateObserver {

    public IStateWatcherA(){
        System.out.println("This is StateWatcherA");
    }

    @Override
    public void onStateChange() {
        System.out.println("StateWatcherA watches StateChange");
    }
}
