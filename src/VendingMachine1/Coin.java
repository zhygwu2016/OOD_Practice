package VendingMachine1;

public enum Coin {

    PENNY(1),

    NICKLE(5),

    DIME(10),

    QUATER(25);

    private int value;

    Coin(final int value){
        this.value = value;
    }

    public int getValue(){
        return value;
    }
}
