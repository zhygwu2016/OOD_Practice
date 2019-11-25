package CallCenterDesign;

public class Employee {

    private final Rank rank;

    private Call call;

    private final String id;

    private ServiceCenter serviceCenter;

    public Employee(final String id,final Rank rank){
        this.id = id;
        this.rank = rank;
    }

    public void setServiceCenter(ServiceCenter serviceCenter){
        this.serviceCenter = serviceCenter;
    }

    public String getId(){
        return id;
    }

    public boolean isAvailable(){
        return call == null;
    }

    public boolean takeCall(final Call call){
        if(!isAvailable()) return false;
        if(call.getRank() > rank.value()){
            return  false;
        }

        this.call = call;
        return  true;
    }

    public boolean transferCall(final Call call, Employee employee){
        if(!employee.isAvailable()) return false;

        return employee.takeCall(call);
    }

    public void setCallRank(final Call call, final int rank){
        call.setRank(rank);
    }


    public Rank getRank(){
        return rank;
    }

    public Call getCurrentCall(){
        return call;
    }
}
