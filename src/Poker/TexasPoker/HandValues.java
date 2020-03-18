package Class1.Poker.TexasPoker;

/**
 * Created by FLK on 2020-01-11.
 */
public enum HandValues {
    High_Card(0),
    One_Pair(1),
    Two_Pairs(2),
    Three_Of_A_kind(3),
    Straight(4),
    Flush(5),
    Full_House(6),
    Four_Of_A_Kind(7),
    Straight_Flush(8),
    Royal_Flush(9);

    private final int value;

    HandValues(final int value){
        this.value = value;
    }

    public int getValue(){
        return value;
    }
}
