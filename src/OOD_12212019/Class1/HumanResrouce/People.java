package Class1.HumanResrouce;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by FLK on 2019-12-21.
 */
public abstract class People {

    final String id;
    final String name;

    final List<People> directReporter;

    final List<IEmailReceiver> emailReceivers;

    final List<IUpMessageDispatcher> upMessageDispatchers;

    final List<IDownMessageDispatcher> downMessageDispatchers;

    People directSupervisor;

    Position position;

    public People(final String id, final String name){
        this.id = id;
        this.name = name;

        directReporter = new ArrayList<>();
        emailReceivers = new ArrayList<>();
        upMessageDispatchers = new ArrayList<>();
        downMessageDispatchers = new ArrayList<>();
    }

    public int getLevel() {

        if(position == null) {
            return 0;
        }

        return position.getLevel();
    }

    public boolean setDirectReporter(final People people) {
        if(people.getLevel() >= this.getLevel()) {
            directSupervisor = people;
            return true;
        }

        return false;
    }

    public boolean addDirectReporter(final People people){
        if(people.getLevel() <= this.getLevel()) {
            directReporter.add(people);
            people.setDirectReporter(this);
            return true;
        }
        return false;
    }

    public void sendSupervisorMessage(final String message){
        if(directSupervisor != null) {
            directSupervisor.onReportersMessageReceived(message);
        }

        for(IUpMessageDispatcher supervisors : upMessageDispatchers) {
            supervisors.onMessageReceived(message);
        }
    }

    public void sendReportersMessage(final String message){
        for(People reporter : directReporter) {
            reporter.onSupervisorMessageReceived(message);
        }

        for(IDownMessageDispatcher reporters : downMessageDispatchers) {
            reporters.onMessageReceived(message);
        }
    }

    public void sendEmail(String emailMessage) {
        for (IEmailReceiver emailReceiver : emailReceivers) {
            emailReceiver.onEmailMessageReceived(emailMessage);
        }
    }

    public void addEmailReceiver(final IEmailReceiver iEmailReceiver){
        emailReceivers.add(iEmailReceiver);
    }

    public void removeEmailReceiver(final IEmailReceiver iEmailReceiver){
        emailReceivers.remove(iEmailReceiver);
    }



    public abstract void onSupervisorMessageReceived(String message);

    public abstract void onReportersMessageReceived(String message);

}
