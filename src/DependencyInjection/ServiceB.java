package DependencyInjection;

public class ServiceB extends Service implements ServiceObservable {

    public ServiceB(){
        this.serviceName = "ServiceB";
    }

    @Override
    public void processRequest() {
        System.out.println("Process ServiceB");
    }

    @Override
    public void runService(){
        System.out.println("Run Service B");
    }
}
