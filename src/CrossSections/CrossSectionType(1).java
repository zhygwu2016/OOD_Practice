package CrossSections;

/**
 * Created by Frank Fang on 9/8/18.
 */
public enum CrossSectionType {

    ThreeWay("ThreeWay", 3),
    FourWay("FourWay",4);

    private String type;
    private int roadNum;

    CrossSectionType(final String type, final int roadNum){
        this.type = type;
        this.roadNum = roadNum;
    }

    public String toString(){
        return type;
    }

    public int getRoadNum(){
        return roadNum;
    }
}
