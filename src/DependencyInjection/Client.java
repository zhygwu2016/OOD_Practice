package DependencyInjection;

public class Client {

    private ServiceObservable serviceObservable;

    public Client(ServiceObservable serviceObservable){
        this.serviceObservable = serviceObservable;
    }

    public ServiceObservable getServiceObservable(){
        return serviceObservable;
    }

    public void requestProcess(){
        this.serviceObservable.processRequest();
    }
}
