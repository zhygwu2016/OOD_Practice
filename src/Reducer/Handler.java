package Reducer;

import sun.jvm.hotspot.utilities.MessageQueue;

/**
 * Created by FLK on 12/7/18.
 */
public class Handler {

    private final MessageQueue messageQueue;

    public Handler(){
        messageQueue = new MessageQueue() {
            @Override
            public Object readMessage() {
                return null;
            }

            @Override
            public Object readMessageWithTimeout(long l) {
                return null;
            }

            @Override
            public void writeMessage(Object o) {

            }
        };
    }

    public void postDelay(Runnable runnable, long deouncePeriod) {
        //messageQueue.sendMessageAtTime(runnable,deouncePeriod);
    }

    public void removeCallBack(Runnable runnable) {
        //messageQueue.remove(runnable);
    }

    public void post(Runnable runnable) {
        //messageQueue.put(runnable);
    }
}
