package DependencyInjection;

public class ServiceA extends Service implements ServiceObservable{

    public ServiceA(){
        this.serviceName = "ServiceA";
    }

    @Override
    public void processRequest() {
        System.out.println("Process ServiceA");
    }

    @Override
    public void runService(){
        System.out.println("Run Service A");
    }
}
