package ObserverDesignPattern;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Frank Fang on 4/21/18.
 */
public class StateObserverable  {

    private List<IStateObserver> IStateObservers = new ArrayList<IStateObserver>();

    private int state;

    public StateObserverable(final int state){
        this.state = state;
    }

    public void setState(final int state){
        this.state = state;
        notifyListener();
    }

    private void notifyListener(){
        for (IStateObserver iStateObservers : IStateObservers){
            iStateObservers.onStateChange();
        }
    }

    public void addListener(IStateObserver iStateObserver){
        IStateObservers.add(iStateObserver);
    }
}
