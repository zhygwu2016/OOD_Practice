package Class3.MiBand;

import Class3.MiBand.DisplayableHardware.LEDColor;

/**
 * Created by FLK on 2019-12-31.
 */
public class MiBandV1 extends MiBand{

    //Option 1
    private final LEDColor LEDColor;

    public MiBandV1(final String id) {
        super(id);
        LEDColor = new LEDColor("123");
    }

    /**
     * Limited Options
     */
    @Override
    public void displayBatteryLife() {
        LEDColor.displayNumber(getBatteryLife());
    }

    @Override
    public void displayBatteryLife(final DisplayOption displayOption) {
        if(displayOption == DisplayOption.LED_COLOR) {
            LEDColor.displayNumber(getBatteryLife());
        } else {
            System.out.println(String.format("Error, %s is not supported for this device", displayOption.toString()));
        }
    }
}
