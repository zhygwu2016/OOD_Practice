package Class1.HumanResrouce;

/**
 * Created by FLK on 2019-12-21.
 */
public class Robot implements IEmailReceiver {
    public static final String TAG = TechbowCEO.class.getSimpleName();

    @Override
    public void onEmailMessageReceived(String emailMessage) {
        System.out.println(String.format("一封来自老刘的信： %s ",emailMessage));
    }
}
