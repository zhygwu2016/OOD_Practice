package Class1.Poker;

public class Card implements Comparable{

    private final Suit suit;
    private final int value;

    public Card(Suit suit, int value){
        this.suit = suit;
        this.value = value;
    }

    public int getValue(){
        return this.value;
    }

    public Suit getSuit(){
        return this.suit;
    }

    @Override
    public int compareTo(Object o) {
        return value - ((Card) o).value;
    }
}
