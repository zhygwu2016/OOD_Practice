package Class1.Poker.TexasPoker;

import Class1.Poker.Card;
import com.sun.istack.internal.NotNull;

import java.util.List;

/**
 * Created by FLK on 2020-01-11.
 */
public class FourOfAKind extends Pattern{

    private final int fourOfAKindValue;

    public FourOfAKind(@NotNull final String userId, @NotNull final List<Card> cards) {
        super(HandValues.Four_Of_A_Kind, userId, cards);
        fourOfAKindValue = cards.get(1).getValue();
    }

    @Override
    public int compareTo(Object o) {
        final Pattern other = (Pattern) o;

        //Same Pattern
        if(handValues.getValue() == other.getHandValues().getValue()) {
            final FourOfAKind otherFour = (FourOfAKind) o;

            //If both are Royal Flush, then compare their largest card number
            return fourOfAKindValue - otherFour.fourOfAKindValue;
        } else {
            //If not same pattern then return their pattern value
            return handValues.getValue() - other.handValues.getValue();
        }
    }

    public int getFourCardValue(){
        return fourOfAKindValue;
    }
}
