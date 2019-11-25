package DesignCard;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Frank Fang on 8/18/18.
 */
public class Player {

    private final String id;

    private final String name;

    private final List<Card> handCards;

    public Player(final String id, final String name){
        this.id = id;
        this.name = name;

        handCards = new ArrayList<Card>();
    }

    public String getId(){
        return id;
    }

    public String getName(){
        return name;
    }

    public boolean getCard(final Card card){
         if(card == null) return false;

         handCards.add(card);
         return true;
    }

    public Card popCard(final int index){
        if(index < 0 || index >= handCards.size()) return null;

        final Card selectedCard = handCards.get(index);

        handCards.remove(index);

        return selectedCard;
    }

    public List<Card> showHand(){
        return handCards;
    }

}
