package Class1.Card;

public enum Suit {
    Club("Club",1),
    Diamond("Diamond",2),
    Heart("Heart",3),
    Spade("Spade",4);

    private final String suit;
    private final int value;

    Suit(String suit, int value){
        this.suit = suit;
        this.value = value;
    }

    public String toString(){
        return this.suit;
    }

    public int getValue(){
        return value;
    }
}
