package Class3.MiBand.DisplayableHardware;

import java.util.Date;

/**
 * Created by FLK on 2019-12-31.
 */
public class Screen implements IdisplayableHardware {
    private final String equipId;

    private final String typeId;

    public Screen(final String equipId, final String typeId) {
        this.equipId = equipId;
        this.typeId = typeId;
    }

    public String getEquipId(){
        return equipId;
    }

    public String getTypeId(){
        return typeId;
    }

    @Override
    public void displayNumber(final int num) {
        //Do something with the number
        System.out.println(num);
    }

    @Override
    public void displayMessage(final String message) {
        displayString(message);
    }

    @Override
    public void displayTime(final Date date) {
        displayString(date.toString());
    }

    private void displayString(final String str){
        //Do something with the String
        System.out.println(str);
    }
}
