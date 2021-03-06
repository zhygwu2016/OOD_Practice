package Class3.MiBand;

import Class3.MiBand.DisplayableHardware.ArrayLED;
import Class3.MiBand.DisplayableHardware.IdisplayableHardware;
import Class3.MiBand.DisplayableHardware.Screen;
import Class3.MiBand.DisplayableHardware.Speaker;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by FLK on 2019-12-31.
 */
public class MiBandV3 extends MiBand {
    //Option 1
    private Screen screen;

    //Option 2
    private final Map<DisplayOption, IdisplayableHardware> hardwareMap;

    public MiBandV3(String id) {
        super(id);
        //Option 1
        screen = new Screen("SC-123", "xyz");

        //Option 2
        hardwareMap = new HashMap<>();
        initHardware();
    }

    private void initHardware() {
        hardwareMap.put(DisplayOption.LED_ARRAY,new ArrayLED("LA-123"));
        hardwareMap.put(DisplayOption.SCREEN, new Screen("SC-123", "xyz"));
        hardwareMap.put(DisplayOption.VOICE, new Speaker("SP-123"));
    }

    //Option 1 - Limited options
    @Override
    public void displayBatteryLife() {
        screen.displayNumber(getBatteryLife());
    }

    @Override
    public void displayBatteryLife(DisplayOption displayOption) {
        displayNumber(getBatteryLife(), displayOption);
    }

    //Re-usability
    private void displayNumber(final int num, final DisplayOption displayOption) {
        final IdisplayableHardware hardware = hardwareMap.get(displayOption);

        if(hardware != null) {
            hardware.displayNumber(num);
        } else {
            System.out.println(String.format("Error, %s is not supported for this device", displayOption.toString()));
        }
    }
}
