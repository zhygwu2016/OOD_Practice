package Class3.MiBand;

/**
 * Created by FLK on 2019-12-31.
 */
public abstract class MiBand {
    final String miBandId;


    // Represent for the current battery percentage, range 0 - 100;
    int batteryLife;

    public MiBand(final String id) {
        this.miBandId = id;
    }

    public void setBatteryLife(final int percentage){
        batteryLife = percentage;
    }

    public int getBatteryLife(){
        return batteryLife;
    }

    //Option 1
    public abstract void displayBatteryLife();

    //Option 2
    public abstract void displayBatteryLife(final DisplayOption displayOption);
}
