package Class3.MiBand.DisplayableHardware;

import Class3.MiBand.NotSupportedException;

import java.util.Date;

/**
 * Created by FLK on 2019-12-31.
 */
public interface IdisplayableHardware {
    void displayNumber(final int batteryLife);

    void displayMessage(final String message) throws NotSupportedException;

    void displayTime(final Date date) throws NotSupportedException;
}
