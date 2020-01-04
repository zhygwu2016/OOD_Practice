package Class3.MiBand.DisplayableHardware;

import java.util.Date;

/**
 * Created by FLK on 2019-12-31.
 */
public class Speaker implements IdisplayableHardware {
    private final String equipId;

    public Speaker(final String equipId) {
        this.equipId = equipId;
    }

    public String getEquipId(){
        return equipId;
    }

    @Override
    public void displayNumber(final int batteryLife) {
        readNumber(batteryLife);
    }

    @Override
    public void displayMessage(final String message) {
        readString(message);
    }

    @Override
    public void displayTime(final Date date) {
        readString(date.toString());
    }

    private void readNumber(final int num){
        //Do something with the number
        System.out.println(num);
    }

    private void readString(final String str){
        //Do something with the String
        System.out.println(str);
    }
}
