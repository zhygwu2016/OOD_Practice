package StaticDemo;

/**
 * Created by Frank Fang on 8/18/18.
 */
public class StaticDemo {

    private int state = 1;

    public static final String TAG = StaticDemo.class.getName();

    public void  setState(final int temp){
        state = temp;
    }

    public boolean checkState(){
        if (state == 1){
            System.out.println(TAG + " State is 1, correct");
            return true;
        } else {
            System.out.println(TAG + " :The state is wrong");
            return false;
        }
    }
}
