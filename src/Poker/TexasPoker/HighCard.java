package Class1.Poker.TexasPoker;

import Class1.Poker.Card;
import com.sun.istack.internal.NotNull;

import java.util.List;

/**
 * Created by FLK on 2020-01-11.
 */
public class HighCard extends Pattern {
    public HighCard(@NotNull String userId,@NotNull List<Card> cards) {
        super(HandValues.High_Card, userId, cards);
    }

    @Override
    public int compareTo(Object o) {
        final Pattern other = (Pattern) o;

        //Same Pattern
        if(handValues.getValue() == other.handValues.getValue()) {

            for(int i = 4; i >= 0; i--){
                final Card thisCard = cards.get(i);
                final Card otherCard = other.getCards().get(i);

                if(thisCard.getValue() != otherCard.getValue()) {
                    return thisCard.getValue() - otherCard.getValue();
                }
            }

            return cards.get(4).getSuit().getValue() - other.getCards().get(4).getSuit().getValue();
        } else {
            //If not same pattern then return their pattern value
            return handValues.getValue() - other.handValues.getValue();
        }
    }
}
