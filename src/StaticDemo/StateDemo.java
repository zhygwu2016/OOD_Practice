package StaticDemo;

import com.oracle.tools.packager.Log;

public class StateDemo {

    private static int state = 1;

    public static final String TAG = StateDemo.class.getName();

    public void setState(final int temp){
        state = temp;
    }

    public void checkState(){
        if(state == 1){
            System.out.println(TAG + " State is 1, correct");
            Log.info(TAG + ": The state is correct");
        } else {
            System.out.print(TAG + " State is " + state + " , Wrong");
            Log.info(TAG + ": The state is Wrong");
        }
    }
}
