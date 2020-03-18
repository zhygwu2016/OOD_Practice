package Class1.Poker.TexasPoker;

import Class1.Poker.Card;
import com.google.common.collect.ImmutableList;

import java.util.List;

/**
 * Created by FLK on 2020-01-11.
 */
public abstract class Pattern implements Comparable{
    protected final HandValues handValues;

    protected final String userId;

    protected final ImmutableList<Card> cards;

    public Pattern(final HandValues handValues, final String userId, final List<Card> cards){
        this.handValues = handValues;
        this.userId = userId;
        this.cards = ImmutableList.copyOf(cards);
    }

    public String getUserId(){
        return userId;
    }

    public HandValues getHandValues(){
        return handValues;
    }

    public List<Card> getCards(){
        return cards;
    }
}
