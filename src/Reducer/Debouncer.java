package Reducer;

import com.sun.istack.internal.NotNull;
import com.sun.istack.internal.Nullable;

/**
 * Created by FLK on 12/7/18.
 */
public class Debouncer {

    //The debounce period of this debouncer
    private final long deouncePeriod;

    //The runnable you want to execute
    private Runnable runnable;

    //The handler to handler the call and cancel of the runnable
    private Handler handler;

    /*
     * Constructor
     *
     * @param   debouncePeriod  The debounce period of this debouncer
     * @param   runnable        The runnable you want to execute
     * @param   handler         The handler to handler the call and cancel of the runnable
     */
    public Debouncer(final int debouncePeriod, @Nullable final Runnable runnable, @Nullable Handler handler){
        this.deouncePeriod = debouncePeriod;
        this.runnable = runnable;

        if(handler == null){
            this.handler = new Handler();
        } else {
            this.handler = handler;
        }
    }

    public void call(){
        call(runnable);
    }

    public void call(@NotNull Runnable runnable){
        //When a new request is posted, just cancel the current runnable
        cancel();
        this.runnable = runnable;

        if(runnable != null){
            //Delay the runnable for the debounce period, if now new request comes, then execute
            handler.postDelay(runnable,deouncePeriod);
        } else {
            throw new IllegalArgumentException("runnable should not be empty");
        }
    }

    public void cancel(){
        handler.removeCallBack(runnable);
    }

    public Handler getHandler(){
        return handler;
    }
}
