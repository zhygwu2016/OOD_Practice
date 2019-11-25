package CallCenterDesign;

public enum Rank {

    Representative(0),

    Senior(1),

    Manager(2);

    private final int rank;

    Rank(final int rank){
        this.rank = rank;
    }

    public int value(){
        return rank;
    }
}
