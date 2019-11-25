package DesignCard;

/**
 * Created by Frank Fang on 8/18/18.
 */
public class Card {

    private final Suit suit;
    private final  int value;

    public Card(final Suit suit,final int value){
        this.suit = suit;
        this.value = value;
    }

    public int getValue(){
        return this.value;
    }

    public Suit getSuit(){
        return this.suit;
    }
}
