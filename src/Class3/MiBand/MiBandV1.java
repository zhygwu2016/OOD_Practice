package Class3.MiBand;

import Class3.MiBand.DisplayableHardware.ColorLED;

/**
 * Created by FLK on 2019-12-31.
 */
public class MiBandV1 extends MiBand{

    //Option 1
    private ColorLED colorLED;

    public MiBandV1(String id) {
        super(id);
        colorLED = new ColorLED("123");
    }

    /**
     * Limited Options
     */
    @Override
    public void displayBatteryLife() {
        colorLED.displayNumber(getBatteryLife());
    }

    @Override
    public void displayBatteryLife(final DisplayOption displayOption) {
        if(displayOption == DisplayOption.LED_COLOR) {
            colorLED.displayNumber(getBatteryLife());
        } else {
            System.out.println(String.format("Error, %s is not supported for this device", displayOption.toString()));
        }
    }
}
