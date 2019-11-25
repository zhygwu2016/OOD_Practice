package Card;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Deck {

    private int size;
    private final List<Card> cards;

    public Deck(){
        size = 0;
        cards = new ArrayList<Card>();
    }

    public void init(){

        for(int i = 1; i <= 13; i++){
            for (Suit suit : Suit.values()){
                cards.add(new Card(suit,i));
            }
        }
        size = cards.size();
    }

    public void shuffle(){
        for(int i = 0; i < cards.size(); i++){

            final int randomIndex = new Random().nextInt(i + 1);

            final Card tempCard = cards.get(i);

            cards.set(i, cards.get(randomIndex));

            cards.set(randomIndex,tempCard);
        }
    }

    public int getSize(){
        return size;
    }

    public Card dealCard(){
        if(size == 0) return null;

        final Card topCard = cards.get(size - 1);

        cards.remove(size - 1);

        size--;

        return topCard;
    }

    private Card peek(){
        if(size == 0) return null;

        return cards.get(size - 1);
    }
}
