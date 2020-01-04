package Class1.ObseverDesignPattern1;

import java.util.ArrayList;
import java.util.List;

public class StateChangeObserverable {

    private List<IStateObserver> IStateObservers = new ArrayList<IStateObserver>();

    private int state;

    public StateChangeObserverable(final int state){
        this.state = state;
    }

    public int getState(){
        return  state;
    }

    public void setState(final int state){
        this.state = state;
        notifyListener();
    }

    public void registerListeners(IStateObserver IStateObserver){
        IStateObservers.add(IStateObserver);
    }

    public void unregisterListeners(IStateObserver IStateObserver){
        IStateObservers.remove(IStateObserver);
    }

    private void notifyListener(){

        for (IStateObserver IStateObserver : IStateObservers){
            IStateObserver.onStateChange();
        }
    }
}
