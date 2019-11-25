package ObserverDesignPattern;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Frank Fang on 8/25/18.
 */
public class StateChangeObserverable {

    private List<IStateObserver> iStateObservers = new ArrayList<IStateObserver>();

    private int state;

    public StateChangeObserverable(final int state){
        this.state = state;
    }

    public int getState(){
        notifyListener();
        return state;
    }

    public void setState(final int state){
        this.state = state;

        notifyListener();
    }

    public void registerListners(IStateObserver iStateObserver){
        iStateObservers.add(iStateObserver);
    }

    public void unregisterListeners(IStateObserver iStateObserver){
        iStateObservers.remove(iStateObserver);
    }

    private void notifyListener(){

        for (IStateObserver iStateObserver : iStateObservers){
            iStateObserver.onStateChange();
        }
    }

}
