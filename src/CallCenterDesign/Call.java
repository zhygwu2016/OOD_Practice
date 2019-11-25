package CallCenterDesign;

public class Call {

    public final String id;

    private long createTime;

    private int rank;

    private Employee handler;

    private final User user;

    public Call(final String id, final User user){
        this.id = id;
        this.user = user;
        rank = 1;
        this.createTime = System.currentTimeMillis();
    }

    public void setRank(final int rank){
        this.rank = rank;
    }

    public boolean setHandler(final Employee handler){
        if(handler.takeCall(this)){
            this.handler = handler;
            return true;
        }

        return false;
    }

    public boolean isWaiting(){
        return handler == null;
    }

    public void disConnect(){
        this.handler = null;
    }

    public int getRank(){
        return rank;
    }

    public long getCreateTime(){
        return createTime;
    }

    public User getUser(){
        return user;
    }

    public Employee getHandler(){
        return handler;
    }

}
