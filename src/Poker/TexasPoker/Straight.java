package Class1.Poker.TexasPoker;

import Class1.Poker.Card;
import com.sun.istack.internal.NotNull;

import java.util.List;

/**
 * Created by FLK on 2020-01-11.
 */
public class Straight extends Pattern{
    public Straight(@NotNull final String userId, @NotNull final List<Card> cards) {
        super(HandValues.Straight, userId, cards);
    }

    @Override
    public int compareTo(Object o) {
        final Pattern other = (Pattern) o;

        //Same Pattern
        if(handValues.getValue() == other.handValues.getValue()) {

            final Card thisCard = cards.get(0);
            final Card otherCard = other.getCards().get(0);

            return thisCard.getValue() - otherCard.getValue();
        } else {
            //If not same pattern then return their pattern value
            return handValues.getValue() - other.handValues.getValue();
        }
    }
}
