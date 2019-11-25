package CrossSections;

// Assuming there a limited types of CrossSections
public enum CrossSectionType {

    ThreeWay("ThreeWay", 3),

    FourWay("FourWay", 4);

    private String type;
    private int roadNum;

    CrossSectionType(final String type, final int roadNum){
        this.type = type;
        this.roadNum = roadNum;
    }

    public String toString(){
        return  type;
    }

    public int getRoadNum(){
        return roadNum;
    }

}
