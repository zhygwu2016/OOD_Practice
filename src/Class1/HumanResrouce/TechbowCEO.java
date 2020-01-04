package Class1.HumanResrouce;

/**
 * Created by FLK on 2019-12-21.
 */
public class TechbowCEO extends People {
    public static final String TAG = TechbowCEO.class.getSimpleName();

    public static final String GOOD_NEWS = "I get an offer";
    public static final String BAD_NEWS = "gua le";

    public TechbowCEO(final String id, final String name) {
        super(id, "Zizuo Liu");
        position = Position.CEO;
    }

    @Override
    public void onSupervisorMessageReceived(String message) {
        System.out.println("How dare you !");
    }

    @Override
    public void onReportersMessageReceived(String message) {

        if (GOOD_NEWS.equals(message)) {
            System.out.println(String.format("%s : 按惯例，恭喜 @XXX 某公司 Offer","老刘"));
        } else if(BAD_NEWS.equals(message)) {
            System.out.println(String.format("%s : 这题我上课不是讲过了吗？","老刘"));
        } else {
            System.out.println("I don't care");
        }
    }
}
