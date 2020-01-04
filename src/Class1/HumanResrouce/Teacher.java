package Class1.HumanResrouce;

/**
 * Created by FLK on 2019-12-21.
 */
public class Teacher extends People{
    public static final String TAG = Teacher.class.getSimpleName();

    public Teacher(String id, String name) {
        super(id, name);
        position = Position.TEACHER;
    }

    @Override
    public void onSupervisorMessageReceived(String message) {
        System.out.println(String.format("%s : 老刘发话了",TAG));
        sendReportersMessage(String.format("老刘最高指示如下： %s ",message));
    }

    @Override
    public void onReportersMessageReceived(String message) {
        System.out.println(String.format("%s : Received a message： %s ",TAG,message));
    }
}
