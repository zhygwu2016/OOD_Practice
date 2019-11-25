package Reducer;

import com.sun.istack.internal.Nullable;

/**
 * Created by FLK on 12/7/18.
 */
public class RateLimiter {
    //The handler to handle to deal with
    private final Handler handler;

    //The throttle period
    private final int throttlePeriod;

    //The time that the runnable suppose to be executed
    private long postTime;

    //The runnable that needs to be executed
    private Runnable runnable;

    /*
     * Constructor
     *
     * @param   throttlePeriod  The throttle period of this rate limiter
     * @param   runnable        The runnable you want to execute
     * @param   handler         The handler to handler the call and cancel of the runnable
     */
    public RateLimiter(final int throttlePeriod, @Nullable Handler handler, @Nullable final Runnable runnable){
        this.throttlePeriod = throttlePeriod;

        if(handler != null) {
           this.handler = handler;
        } else {
            this.handler = new Handler();
        }

        this.runnable = runnable;
    }

    public void call(){
        if (runnable == null) {
            throw new IllegalArgumentException("runnable should not be null");
        }

        //The time left should wait between last call and next call
        final long leftTime = postTime - System.currentTimeMillis();

        if(leftTime <= 0) {
            handler.post(runnable);
            //Update the post time when the runnable get executed
            postTime = throttlePeriod + System.currentTimeMillis();
        } else {
            //Remove the current runnable to make sure it won't get executed
            handler.removeCallBack(runnable);

            //Create a new runnable to wait for the left time and then execute the runnable
            handler.postDelay(new Runnable() {
                @Override
                public void run() {
                    handler.post(runnable);

                    //Update the post time when the runnable get executed
                    postTime = throttlePeriod + System.currentTimeMillis();
                }
            },leftTime);
        }
    }

    public void cancel(){
        //cancel the existing runnable
        handler.removeCallBack(runnable);

        //reset the post time
        postTime = 0;
    }

    public void setRunnable(final Runnable runnable){
        cancel();
        this.runnable = runnable;
    }
}
